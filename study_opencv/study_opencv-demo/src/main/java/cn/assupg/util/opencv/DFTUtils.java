package cn.assupg.util.opencv;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;



public class DFTUtils {

    private static List<Mat> planes;
    private static Mat complexImage;

    private DFTUtils() {
    }

    private static final DFTUtils instance = new DFTUtils();

    public static DFTUtils getInstance() {
        planes = new ArrayList<>();
        complexImage = new Mat();
        return instance;
    }

    public Mat transformImageWithText(String sourcePictureFilePath, String waterMarkText, String targetPictureFilePath) {
        Mat sourcePictureFilePathMat = Imgcodecs.imread(sourcePictureFilePath);
        if (sourcePictureFilePathMat.empty()) {
            return null;
        }

        Point point = new Point(50, 100);
        Scalar scalar = new Scalar(0, 0, 0, 0);
        transformImageWithText(sourcePictureFilePathMat, waterMarkText, point, 2.0, scalar);

        Mat antiTransformImageMat = antitransformImage();   //反转换图像
        //Mat dst=new Mat(mat.rows(),mat.cols(),CvType.CV_8UC3);
        //Imgproc.cvtColor(mat, dst, Imgproc.COLOR_BayerBG2GRAY);

        Imgcodecs.imwrite(targetPictureFilePath, antiTransformImageMat);
        return antiTransformImageMat;
    }

    public Mat transformImage(Mat image) {
        // planes数组中存的通道数若开始不为空,需清空.
        if (!planes.isEmpty()) {
            planes.clear();
        }
        // optimize the dimension of the loaded image
        Mat padded = this.optimizeImageDim(image);
        padded.convertTo(padded, CvType.CV_32F);
        // prepare the image planes to obtain the complex image
        planes.add(padded);

        planes.add(Mat.zeros(padded.size(), CvType.CV_32F));

        // prepare a complex image for performing the dft
        Core.merge(planes, complexImage);
        // dft
        Core.dft(complexImage, complexImage);
        // optimize the image resulting from the dft operation
        Mat magnitude = this.createOptimizedMagnitude(complexImage);
        planes.clear();
        return magnitude;
    }

    public void transformImageWithText(Mat image, String watermarkText, Point point, Double fontSize, Scalar scalar) {
        // planes数组中存的通道数若开始不为空,需清空.
        if (!planes.isEmpty()) {
            planes.clear();
        }
        // optimize the dimension of the loaded image
        Mat padded = this.optimizeImageDim(image);
        //Mat padded = image;
        padded.convertTo(padded, CvType.CV_32F);
//        // prepare the image planes to obtain the complex image
//        planes.add(padded);
//        planes.add(Mat.zeros(padded.size(), CvType.CV_32F));
//        // prepare a complex image for performing the dft
//        Core.merge(planes, complexImage);


        List<Mat> images = new ArrayList<Mat>();
        images.add(Mat.zeros(padded.size(), CvType.CV_8U));
        Core.split(padded, images);//RGB通道分离
        Mat mat0 = images.get(0);//获得第二通道分量
        Mat mat1 = images.get(1);//获得第二通道分量
        Mat mat2 = images.get(2);//获得第二通道分量

        //Imgcodecs.imwrite("c:\\1.png", mat0);
        //Imgcodecs.imwrite("c:\\2.png", mat1);
        //Imgcodecs.imwrite("c:\\3.png", mat2);

        Core.dft(images.get(0), images.get(0));
        Core.dft(images.get(1), images.get(1));
        Core.dft(images.get(2), images.get(2));


        Core.merge(images, complexImage);//RGB通道合并

        // dft
        //Core.dft(complexImage, complexImage);
        // 频谱图上添加文本
        Imgproc.putText(complexImage, watermarkText, point, Core.FONT_HERSHEY_DUPLEX, fontSize, scalar, 2);
        Core.flip(complexImage, complexImage, -1);
        Imgproc.putText(complexImage, watermarkText, point, Core.FONT_HERSHEY_DUPLEX, fontSize, scalar, 2);
        Core.flip(complexImage, complexImage, -1);
        planes.clear();
    }

    public Mat antitransformImage() {
        Mat invDFT0 = new Mat();
        Mat invDFT1 = new Mat();
        Mat invDFT2 = new Mat();

        List<Mat> images = new ArrayList<Mat>();
        Core.split(complexImage, images);//RGB通道分离

        Core.idft(images.get(0), invDFT0, Core.DFT_SCALE | Core.DFT_REAL_OUTPUT, 0);
        Core.idft(images.get(1), invDFT1, Core.DFT_SCALE | Core.DFT_REAL_OUTPUT, 0);
        Core.idft(images.get(2), invDFT2, Core.DFT_SCALE | Core.DFT_REAL_OUTPUT, 0);

        //Core.idft(complexImage, invDFT, Core.DFT_SCALE | Core.DFT_REAL_OUTPUT, 0);
        invDFT0.convertTo(images.get(0), CvType.CV_8U);
        invDFT1.convertTo(images.get(1), CvType.CV_8U);
        invDFT2.convertTo(images.get(2), CvType.CV_8U);
        Core.merge(images, complexImage);//RGB通道合并
        planes.clear();
        return complexImage;
    }

    /**
     * 为加快傅里叶变换的速度，对要处理的图片尺寸进行优化
     *
     * @param image the {@link Mat} to optimize
     *
     * @return the image whose dimensions have been optimized
     */
    private Mat optimizeImageDim(Mat image) {
        // init
        Mat padded = new Mat();
        // get the optimal rows size for dft
        int addPixelRows = Core.getOptimalDFTSize(image.rows());
        // get the optimal cols size for dft
        int addPixelCols = Core.getOptimalDFTSize(image.cols());
        // apply the optimal cols and rows size to the image
        Core.copyMakeBorder(image, padded, 0, addPixelRows - image.rows(), 0, addPixelCols - image.cols(),
                Core.BORDER_CONSTANT, Scalar.all(0));

        return padded;
    }

    /**
     * Optimize the magnitude of the complex image obtained from the DFT, to
     * improve its visualization
     *
     * @param complexImage the complex image obtained from the DFT
     *
     * @return the optimized image
     */
    private Mat createOptimizedMagnitude(Mat complexImage) {
        // init
        List<Mat> newPlanes = new ArrayList<>();
        Mat mag = new Mat();
        // split the comples image in two planes
        Core.split(complexImage, newPlanes);
        // compute the magnitude
        Core.magnitude(newPlanes.get(0), newPlanes.get(1), mag);

        // move to a logarithmic scale
        Core.add(Mat.ones(mag.size(), CvType.CV_32F), mag, mag);
        Core.log(mag, mag);
        // optionally reorder the 4 quadrants of the magnitude image
        this.shiftDFT(mag);
        // normalize the magnitude image for the visualization since both JavaFX
        // and OpenCV need images with value between 0 and 255
        // convert back to CV_8UC1
        mag.convertTo(mag, CvType.CV_8UC1);
        Core.normalize(mag, mag, 0, 255, Core.NORM_MINMAX, CvType.CV_8UC1);

        return mag;
    }

    /**
     * Reorder the 4 quadrants of the image representing the magnitude, after
     * the DFT
     *
     * @param image the {@link Mat} object whose quadrants are to reorder
     */
    private void shiftDFT(Mat image) {
        image = image.submat(new Rect(0, 0, image.cols() & -2, image.rows() & -2));
        int cx = image.cols() / 2;
        int cy = image.rows() / 2;

        Mat q0 = new Mat(image, new Rect(0, 0, cx, cy));
        Mat q1 = new Mat(image, new Rect(cx, 0, cx, cy));
        Mat q2 = new Mat(image, new Rect(0, cy, cx, cy));
        Mat q3 = new Mat(image, new Rect(cx, cy, cx, cy));

        Mat tmp = new Mat();
        q0.copyTo(tmp);
        q3.copyTo(q0);
        tmp.copyTo(q3);

        q1.copyTo(tmp);
        q2.copyTo(q1);
        tmp.copyTo(q2);
    }
}
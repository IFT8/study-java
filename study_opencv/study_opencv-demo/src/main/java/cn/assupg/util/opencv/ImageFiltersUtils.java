package cn.assupg.util.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;


/**
 * 外OpenCV For Java支持各种的图像处理包括形态学操作，二值图像分析、图像特征检测与识别、模板匹配、直方图相关功能等等。常见的机器学习算法与图像分析方法。可以说是功能最强大的图像处理SDK与开发平台之一
 */
public class ImageFiltersUtils {

    private ImageFiltersUtils() {
    }

    private static final ImageFiltersUtils instance = new ImageFiltersUtils();

    public static ImageFiltersUtils getInstance() {
        return instance;
    }

    ///**
    // * 将Mat对象转换为BufferedImage对象
    // * 特别要说明一下，BufferedImage与Mat的RGB通道顺序是不一样，正好相反，在Mat对象中三通道的顺序为BGR而在BufferedImage中为RGB。
    // *
    // * @param mat 将Mat对象转换为BufferedImage对象
    // *
    // * @return 将Mat对象转换为BufferedImage对象
    // */
    //public BufferedImage transformMat2BufferedImage(Mat mat) {
    //    int width = mat.cols();
    //    int height = mat.rows();
    //    int dims = mat.channels();
    //    int[] pixels = new int[width * height];
    //    byte[] rgbdata = new byte[width * height * dims];
    //    mat.get(0, 0, rgbdata);
    //    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    //    int index = 0;
    //    int r = 0, g = 0, b = 0;
    //    for (int row = 0; row < height; row++) {
    //        for (int col = 0; col < width; col++) {
    //            if (dims == 3) {
    //                index = row * width * dims + col * dims;
    //                b = rgbdata[index] & 0xff;
    //                g = rgbdata[index + 1] & 0xff;
    //                r = rgbdata[index + 2] & 0xff;
    //                pixels[row * width + col] = ((255 & 0xff) << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | b & 0xff;
    //            }
    //            if (dims == 1) {
    //                index = row * width + col;
    //                b = rgbdata[index] & 0xff;
    //                pixels[row * width + col] = ((255 & 0xff) << 24) | ((b & 0xff) << 16) | ((b & 0xff) << 8) | b & 0xff;
    //            }
    //        }
    //    }
    //    setRGB(image, 0, 0, width, height, pixels);
    //    return image;
    //}
    //
    ///**
    // * 将BufferedImage对象转换为Mat对象
    // * 特别要说明一下，BufferedImage与Mat的RGB通道顺序是不一样，正好相反，在Mat对象中三通道的顺序为BGR而在BufferedImage中为RGB。
    // *
    // * @param image 将BufferedImage对象转换为Mat对象
    // *
    // * @return 将BufferedImage对象转换为Mat对象
    // */
    //public Mat transformBufferedImage2Mat(BufferedImage image) {
    //    int width = image.getWidth();
    //    int height = image.getHeight();
    //    Mat src = new Mat(new Size(width, height), CvType.CV_8UC3);
    //    int[] pixels = new int[width * height];
    //    byte[] rgbdata = new byte[width * height * 3];
    //    getRGB(image, 0, 0, width, height, pixels);
    //    int index = 0, c = 0;
    //    int r = 0, g = 0, b = 0;
    //    for (int row = 0; row < height; row++) {
    //        for (int col = 0; col < width; col++) {
    //            index = row * width + col;
    //            c = pixels[index];
    //            r = (c & 0xff0000) >> 16;
    //            g = (c & 0xff00) >> 8;
    //            b = c & 0xff;
    //            index = row * width * 3 + col * 3;
    //            rgbdata[index] = (byte) b;
    //            rgbdata[index + 1] = (byte) g;
    //            rgbdata[index + 2] = (byte) r;
    //        }
    //    }
    //
    //    src.put(0, 0, rgbdata);
    //    return src;
    //}


    /**
     * 反色处理
     *
     * @param image 反色处理
     *
     * @return 反色处理
     */
    public Mat inverse(Mat image) {
        int width = image.cols();
        int height = image.rows();
        int dims = image.channels();
        byte[] data = new byte[width * height * dims];
        image.get(0, 0, data);

        int index = 0;
        int r = 0, g = 0, b = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width * dims; col += dims) {
                index = row * width * dims + col;
                b = data[index] & 0xff;
                g = data[index + 1] & 0xff;
                r = data[index + 2] & 0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                data[index] = (byte) b;
                data[index + 1] = (byte) g;
                data[index + 2] = (byte) r;
            }
        }

        image.put(0, 0, data);
        return image;
    }

    /**
     * 亮度提升
     *
     * @param image 亮度提升
     *
     * @return 亮度提升
     */
    public Mat brightness(Mat image) {
        // 亮度提升
        Mat dst = new Mat();
        Mat black = Mat.zeros(image.size(), image.type());
        Core.addWeighted(image, 1.2, black, 0.5, 0, dst);
        return dst;
    }

    /**
     * 亮度降低
     *
     * @param image 亮度降低
     *
     * @return 亮度降低
     */
    public Mat darkness(Mat image) {
        // 亮度降低
        Mat dst = new Mat();
        Mat black = Mat.zeros(image.size(), image.type());
        Core.addWeighted(image, 0.5, black, 0.5, 0, dst);
        return dst;
    }

    public Mat gray(Mat image) {
        // 灰度
        Mat gray = new Mat();
        Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
        return gray;
    }

    /**
     * 锐化
     *
     * @param image 锐化
     *
     * @return 锐化
     */
    public Mat sharpen(Mat image) {
        // 锐化
        Mat dst = new Mat();
        float[] sharper = new float[]{0, -1, 0, -1, 5, -1, 0, -1, 0};
        Mat operator = new Mat(3, 3, CvType.CV_32FC1);
        operator.put(0, 0, sharper);
        Imgproc.filter2D(image, dst, -1, operator);
        return dst;
    }

    /**
     * 高斯模糊
     *
     * @param image 高斯模糊
     *
     * @return 高斯模糊
     */
    public Mat blur(Mat image) {
        // 高斯模糊
        Mat dst = new Mat();
        Imgproc.GaussianBlur(image, dst, new Size(15, 15), 0);
        return dst;
    }


    /**
     * 梯度
     *
     * @param image 梯度
     *
     * @return 梯度
     */
    public Mat gradient(Mat image) {
        // 梯度
        Mat grad_x = new Mat();
        Mat grad_y = new Mat();
        Mat abs_grad_x = new Mat();
        Mat abs_grad_y = new Mat();

        Imgproc.Sobel(image, grad_x, CvType.CV_32F, 1, 0);
        Imgproc.Sobel(image, grad_y, CvType.CV_32F, 0, 1);
        Core.convertScaleAbs(grad_x, abs_grad_x);
        Core.convertScaleAbs(grad_y, abs_grad_y);
        grad_x.release();
        grad_y.release();
        Mat gradxy = new Mat();
        Core.addWeighted(abs_grad_x, 0.5, abs_grad_y, 0.5, 10, gradxy);
        return gradxy;
    }
}
package cn.assupg.study.util.opencv;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DFTUtilsTest {

    private String sourcePictureFilePath = "D:\\20161021101658050.png";
    Mat srcImage;

    @BeforeClass
    public void setUp() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        srcImage = Imgcodecs.imread(sourcePictureFilePath);
    }


    @Test
    public void testTransformImage() throws Exception {
        Mat srcImage1 = Imgcodecs.imread(sourcePictureFilePath, 0);
        new ImageGui(DFTUtils.getInstance().transformImage(srcImage1), "assupg").imshow().waitKey(0);
    }

    @Test
    public void testTransformImageWithText1() throws Exception {
        String targetPictureFilePath = "d:\\test.png";

        Mat comodin = DFTUtils.getInstance().transformImageWithText(sourcePictureFilePath, "comodin", targetPictureFilePath);;
        //new ImageGui(comodin, "assupg").imshow().waitKey(0);

        new ImageGui(DFTUtils.getInstance().transformImage(targetPictureFilePath), "assupg").imshow().waitKey(0);
    }

    @Test
    public void testTransformImageWithText() throws Exception {
        DFTUtils instance = DFTUtils.getInstance();

        Point point = new Point(50, 100);
        Scalar scalar = new Scalar(0, 0, 0, 0);
        instance.transformImageWithText(srcImage, "|admin|20170707155000", point, 1.0, scalar);
        Mat mat = instance.antiTransformImage();
        System.out.println(mat);
        String targetFilePath = "D:\\testTransformImageWithText.jpg";
        Imgcodecs.imwrite(targetFilePath, mat);

        Mat srcImage1 = Imgcodecs.imread(targetFilePath, 0);
        System.out.println(srcImage1);
        Mat mat1 = instance.transformImage(srcImage1);

        new ImageGui(mat1, "assupg").imshow().waitKey(0);

        String targetFilePath1 = "D:\\testTransformImageWithText1.jpg";
        Imgcodecs.imwrite(targetFilePath1, mat1);
    }

    //@Test
    //public void testName004() throws Exception {
    //    Mat dst = new Mat(srcImage.rows(), srcImage.cols(), CvType.CV_8UC3);
    //    Imgproc.cvtColor(srcImage, dst, Imgproc.COLOR_GRAY2RGB);
    //    System.out.println(dst);
    //
    //
    //
    //    String targetFilePath = "D:\\testName004.jpg";
    //    Imgcodecs.imwrite(targetFilePath, dst);
    //}

    @Test
    public void testName003() throws Exception {
        Mat dst111 = new Mat(srcImage.rows(), srcImage.cols(), CvType.CV_8UC1);
        Imgproc.cvtColor(srcImage, dst111, Imgproc.COLOR_RGB2GRAY);
        System.out.println(dst111);

        String targetFilePath = "D:\\testName003.jpg";
        Imgcodecs.imwrite(targetFilePath, dst111);
    }

    @Test
    public void testName002() throws Exception {
        Mat srcImage = Imgcodecs.imread(sourcePictureFilePath);
        System.out.println(srcImage);

        String targetFilePath = "D:\\testName002.jpg";
        Imgcodecs.imwrite(targetFilePath, srcImage);
    }

    @Test
    public void testName001() throws Exception {
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println(mat.dump());
    }
}
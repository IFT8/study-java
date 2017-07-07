package cn.assupg.study.util.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ImageFiltersUtilsTest {

    private String sourcePictureFilePath = "D:\\companiesCode_signaturePicture.jpg";
    Mat srcImage;

    @BeforeClass
    public void setUp() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        srcImage = Imgcodecs.imread(sourcePictureFilePath);
    }

    @Test
    public void testInverse() throws Exception {
        String writefilePath = "d:\\testInverse.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().inverse(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testBrightness() throws Exception {
        String writefilePath = "d:\\testBrightness.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().brightness(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testDarkness() throws Exception {
        String writefilePath = "d:\\testDarkness.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().darkness(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testGray() throws Exception {
        String writefilePath = "d:\\testGray.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().gray(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testSharpen() throws Exception {
        String writefilePath = "d:\\testSharpen.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().sharpen(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testBlur() throws Exception {
        String writefilePath = "d:\\testBlur.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().blur(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

    @Test
    public void testGradient() throws Exception {
        String writefilePath = "d:\\testGradient.jpg";
        Mat inverse = ImageFiltersUtils.getInstance().gradient(srcImage);
        Imgcodecs.imwrite(writefilePath, inverse);
    }

}
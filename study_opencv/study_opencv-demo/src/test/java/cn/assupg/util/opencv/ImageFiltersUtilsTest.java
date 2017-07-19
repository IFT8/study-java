package cn.assupg.util.opencv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URLDecoder;


public class ImageFiltersUtilsTest {
    protected final Log logger = LogFactory.getLog(getClass());

    private String sourcePictureFilePathStr;
    private File outRootDir;
    Mat srcImageMat;

    @BeforeClass
    public void setUp() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        sourcePictureFilePathStr = URLDecoder.decode(ImageFiltersUtilsTest.class.getResource("/dev_image_template/companiesCode_signaturePicture.jpg").getFile(), "UTF-8").substring(1);
        outRootDir = new File(sourcePictureFilePathStr).getParentFile();

        srcImageMat = Imgcodecs.imread(sourcePictureFilePathStr);
    }

    @Test
    public void testInverse() throws Exception {
        File outFile = new File(outRootDir, "testInverse.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().inverse(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testBrightness() throws Exception {
        File outFile = new File(outRootDir, "testBrightness.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().brightness(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testDarkness() throws Exception {
        File outFile = new File(outRootDir, "testDarkness.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().darkness(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testGray() throws Exception {
        File outFile = new File(outRootDir, "testGray.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().gray(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testSharpen() throws Exception {
        File outFile = new File(outRootDir, "testSharpen.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().sharpen(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testBlur() throws Exception {
        File outFile = new File(outRootDir, "testBlur.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().blur(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

    @Test
    public void testGradient() throws Exception {
        File outFile = new File(outRootDir, "testGradient.jpg");
        System.out.println(outFile);

        Mat inverse = ImageFiltersUtils.getInstance().gradient(srcImageMat);
        Imgcodecs.imwrite(outFile.getPath(), inverse);
    }

}
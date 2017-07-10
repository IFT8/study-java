package cn.assupg.study.util.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URLDecoder;


public class DFTUtilsTest {

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
    public void testTransformImageWithText() throws Exception {
        File outFile = new File(outRootDir, "testTransformImageWithText.jpg");
        System.out.println(outFile);
        DFTUtils dftUtils = DFTUtils.getInstance();
        Mat transformImageWithTextMat = dftUtils.transformImageWithText(sourcePictureFilePathStr, "comodin", outFile.getPath());

        Mat mat = dftUtils.transformImage(transformImageWithTextMat);
        Imgcodecs.imwrite("D:\\555.png", mat);
    }


    @Test
    public void testName001() throws Exception {
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println(mat.dump());
    }
}
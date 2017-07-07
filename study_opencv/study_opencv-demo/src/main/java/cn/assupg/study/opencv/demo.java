package cn.assupg.study.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;

public class demo {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println(mat.dump());
    }


    private void addDirToPath(String s) {
        try {
            //获取系统path变量对象
            Field field = ClassLoader.class.getDeclaredField("sys_paths");
            //设置此变量对象可访问
            field.setAccessible(true);
            //获取此变量对象的值
            String[] path = (String[]) field.get(null);
            //创建字符串数组，在原来的数组长度上增加一个，用于存放增加的目录
            String[] tem = new String[path.length + 1];
            //将原来的path变量复制到tem中
            System.arraycopy(path, 0, tem, 0, path.length);
            //将增加的目录存入新的变量数组中
            tem[path.length] = s;
            //将增加目录后的数组赋给path变量对象
            field.set(null, tem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        //获取存放dll文件的绝对路径
        String path = System.getProperty("riskArsenalWeb.root");
        System.out.println("######## 路径为 : " + path + " ########");
        //将此目录添加到系统环境变量中
        addDirToPath(path);
        //加载相应的dll文件，注意要将'\'替换为'/'
        System.load(path.replaceAll("\\\\", "/") + "/opencv_java300.dll");
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("######## Opencv加载完毕 ########");
    }
}

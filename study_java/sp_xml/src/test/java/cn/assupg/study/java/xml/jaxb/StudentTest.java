package cn.assupg.study.java.xml.jaxb;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by supeng on 11/16/2016.
 */
public class StudentTest {

    @Test
    public void testName001() throws Exception {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller(); //编排，把java对象转换xml
            Classroom classroom = new Classroom(1, "10计算机应用技术", 2010);
            Student student = new Student();
            student.setId(1);
            student.setName("张三");
            student.setAge(24);
            student.setClassroom(classroom);
            marshaller.marshal(student, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testName002() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>24</age><classroom><grade>2010</grade><id>1</id><name>10计算机应用技术</name></classroom><id>1</id><name>张三</name></student>";
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();   //反编排，把xml转换为Java对象
        Student student = (Student) unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(student);
    }
}
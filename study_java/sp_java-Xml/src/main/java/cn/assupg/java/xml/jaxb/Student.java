package cn.assupg.java.xml.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by supeng on 11/16/2016.
 */
@XmlRootElement
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classroom=" + classroom +
                '}';
    }
}

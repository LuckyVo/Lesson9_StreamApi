package geekbrains.Lesson9_StreamApi;

import java.awt.*;
import java.util.List;

public class Student implements Students{
    public String name;
    public List<Course> course;

    public Student(String name, List<Course> course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return course;
    }
}

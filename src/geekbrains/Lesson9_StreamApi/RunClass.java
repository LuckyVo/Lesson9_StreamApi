package geekbrains.Lesson9_StreamApi;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Stream;

public class RunClass {
    public static void main(String[] args) {
        List<Course> course = new ArrayList();
        Course setCourse = new Course("Информатика");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Вован", course = new ArrayList<>(Arrays.asList(
                        new Course("Математика"),
                        new Course("Биология"),
                        new Course("География"),
                        new Course("Химия")

                ))),
                new Student("Петька", course = new ArrayList<>(Arrays.asList(
                        new Course("Психология"),
                        new Course("Информатика"),
                        new Course("История"),
                        new Course("Искуства")

                ))),
                new Student("Сашка", course = new ArrayList<>(Arrays.asList(
                        new Course("Информатика"),
                        new Course("История"),
                        new Course("Физика"),
                        new Course("Биология")

                ))),
                new Student("Лёха", course = new ArrayList<>(Arrays.asList(
                        new Course("Информатика"),
                        new Course("История")
                ))),
                new Student("Катька", course = new ArrayList<>(Arrays.asList(
                        new Course("Информатика"),
                        new Course("История"),
                        new Course("Физика")

                )))));

        List<String> unique = uniqueCourses(students);
        List<String> studCourses = studentCourses(students, setCourse);
        List<String> mostEducated = mostWanted(students);
        System.out.println(unique);
        System.out.println(studCourses);
        System.out.println(mostEducated);


    }

    static List<String> uniqueCourses(List<Student> students) {
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    static List<String> studentCourses(List<Student> students, Course setCourse) {
        return students.stream()
                .filter(student -> student.getAllCourses().stream().anyMatch(course -> course.name == setCourse.name))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    static List<String> mostWanted(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(o -> o.getAllCourses().size() * -1))
                .limit(3)
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}

package geekbrains.Lesson9_StreamApi;

public class Course implements Courses{
    public String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}


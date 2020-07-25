package model;

public class Student {
    private Integer id;
    private String name;
    private String birthday;
   private double mark;

    public Student() {
    }

    public Student(Integer id, String name, String birthday, double mark) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.mark = mark;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}

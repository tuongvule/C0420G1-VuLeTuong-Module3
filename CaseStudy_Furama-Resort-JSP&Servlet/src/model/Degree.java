package model;

public class Degree {
    private int id;
    private String nameDegree;

    public Degree() {
    }

    public Degree(int id, String nameDegree) {
        this.id = id;
        this.nameDegree = nameDegree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }
}

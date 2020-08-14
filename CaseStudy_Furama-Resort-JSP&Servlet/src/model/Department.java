package model;

public class Department {
    private int id;
    private String nameDepartment;

    public Department() {
    }

    public Department(int id, String nameDepartment) {
        this.id = id;
        this.nameDepartment = nameDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
}

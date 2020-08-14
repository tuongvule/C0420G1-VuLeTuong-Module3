package model;

public class Employee {
    private int id;
    private String name;
    private String birthday;
    private String idCard;
    private String salary;
    private String phoneNumber;
    private String email;
    private String address;
    private int idPosition;
    private int idDegree;
    private int idDepartment;

    public Employee() {
    }

    public Employee(String name, String birthday, String idCard, String salary, String phoneNumber, String email, String address, int idPosition, int idDegree, int idDepartment) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idDegree = idDegree;
        this.idDepartment = idDepartment;
    }

    public Employee(int id, String name, String birthday, String idCard, String salary, String phoneNumber, String email, String address, int idPosition, int idDegree, int idDepartment) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idDegree = idDegree;
        this.idDepartment = idDepartment;
    }

    public Employee(String name, String birthday, int idCard, int phoneNumber, int email, int address, int idPosition, int idDegree, int idDepartment) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
}

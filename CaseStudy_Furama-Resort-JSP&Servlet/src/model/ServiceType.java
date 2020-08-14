package model;

public class ServiceType {
    private int id;
    private String nameServiceType;

    public ServiceType() {
    }

    public ServiceType(int id, String nameServiceType) {
        this.id = id;
        this.nameServiceType = nameServiceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }
}

package model;

public class Service {
    private int id;
    private String name;
    private int area;
    private int floor;
    private String numberOfPeople;
    private String cost;
    private String status;
    private int idRentType;
    private int idServiceType;

    public Service() {
    }

    public Service(String name, int area, int floor, String numberOfPeople, String cost, String status, int idRentType, int idServiceType) {
        this.name = name;
        this.area = area;
        this.floor = floor;
        this.numberOfPeople = numberOfPeople;
        this.cost = cost;
        this.status = status;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
    }

    public Service(int id, String name, int area, int floor, String numberOfPeople, String cost, String status, int idRentType, int idServiceType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.floor = floor;
        this.numberOfPeople = numberOfPeople;
        this.cost = cost;
        this.status = status;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }
}

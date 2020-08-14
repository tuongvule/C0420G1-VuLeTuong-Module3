package model;

public class RentType {
    private int id;
    private String nameRentType;
    private int price;

    public RentType() {
    }

    public RentType(int id, String nameRentType, int price) {
        this.id = id;
        this.nameRentType = nameRentType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

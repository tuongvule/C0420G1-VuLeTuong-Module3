package model;

public class Position {
    private int id;
    private String namePosition;

    public Position() {
    }

    public Position(int id, String namePosition) {
        this.id = id;
        this.namePosition = namePosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}

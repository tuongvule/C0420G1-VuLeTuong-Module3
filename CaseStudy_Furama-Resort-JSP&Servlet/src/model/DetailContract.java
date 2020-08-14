package model;

public class DetailContract {
    private int id;
    private int quantity;
    private int idContract;
    private int idAccompanyService;

    public DetailContract() {
    }

    public DetailContract(int id, int quantity, int idContract, int idAccompanyService) {
        this.id = id;
        this.quantity = quantity;
        this.idContract = idContract;
        this.idAccompanyService = idAccompanyService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdAccompanyService() {
        return idAccompanyService;
    }

    public void setIdAccompanyService(int idAccompanyService) {
        this.idAccompanyService = idAccompanyService;
    }
}

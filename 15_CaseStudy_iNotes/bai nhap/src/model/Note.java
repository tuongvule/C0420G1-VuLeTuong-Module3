package model;

public class Note {
    int id;
    String title;
    String content;
    int type_Id;
    int idDelete =0;

    public int getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(int idDelete) {
        this.idDelete = idDelete;
    }

    public Note() {
    }

    public Note(int id, String title, String content, int type_Id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type_Id = type_Id;
    }

    public Note(String title, String content, int type_Id) {
        this.title = title;
        this.content = content;
        this.type_Id = type_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType_Id() {
        return type_Id;
    }

    public void setType_Id(int type_Id) {
        this.type_Id = type_Id;
    }

}

package model;

public class Note {
    int id;
    String title;
    String content;
    int type_Id;
    public int delete_note ;



    public Note(int id, int delete_note) {
        this.id = id;
        this.delete_note = delete_note;
    }

    public Note(int id, String title, String content, int type_Id, int delete_note) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type_Id = type_Id;
        this.delete_note = delete_note;
    }

    public Note(String title, String content, int type_Id, int delete_note) {
        this.title = title;
        this.content = content;
        this.type_Id = type_Id;
        this.delete_note = delete_note;
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

    public int getDelete_note() {
        return delete_note;
    }

    public void setDelete_note(int delete_note) {
        this.delete_note = delete_note;
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

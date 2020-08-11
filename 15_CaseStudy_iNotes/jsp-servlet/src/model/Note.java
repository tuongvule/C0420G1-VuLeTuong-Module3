package model;

public class Note {
    private Integer noteId;
    private Integer typeId;
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title) {
        this.title = title;
    }

    public Note(Integer noteId, Integer typeId, String title, String content) {
        this.noteId = noteId;
        this.typeId = typeId;
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, int typeId) {
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
}

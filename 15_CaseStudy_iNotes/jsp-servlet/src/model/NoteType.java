package model;

public class NoteType {
    private  Integer noteTypeId;
    private String name;
    private String description;

    public NoteType() {
    }

    public NoteType(Integer noteTypeId, String name, String description) {
        this.noteTypeId = noteTypeId;
        this.name = name;
        this.description = description;
    }

    public Integer getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(Integer noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

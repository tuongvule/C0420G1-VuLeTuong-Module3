package module;

public class NoteType {
    private int id_note_type;
    private String name_type;

    public NoteType() {
    }

    public NoteType(int id_note_type, String name_type) {
        this.id_note_type = id_note_type;
        this.name_type = name_type;
    }

    public NoteType(String name_type) {
        this.name_type = name_type;
    }

    public int getId_note_type() {
        return id_note_type;
    }

    public void setId_note_type(int id_note_type) {
        this.id_note_type = id_note_type;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }
}

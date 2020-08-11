package bo;

import model.Note;
import model.NoteType;

import java.util.List;

public interface INoteBo {
    public List<Note> selectAllNote();
    public Note selectNote(int id);
    public void insertNote(Note note);
    public boolean deleteNote(Note note);
    public boolean editNote(Note note);
    public List<Note> searchNote(String title);
    public List<NoteType> selectAllNoteType();
}

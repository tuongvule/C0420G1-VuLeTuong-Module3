package bo;

import module.Note;
import module.NoteType;

import java.util.List;

public interface INoteBo {
    List<Note> selectAllNote();
    Note selectNote(int id);
    void insertNote(Note note);
    boolean deleteNote(Note note);
    List<Note> searchNote(String title);
    List<NoteType> selectAllNoteType();
}

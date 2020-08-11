package bo;

import model.Note;
import model.NoteType;

import java.util.List;

public interface NoteBO {
    List<NoteType> findAllNoteType();
    List<Note> findAll();
    List<Note> findByTitle(String title);
    void save(Note note);
    List<Note> sortNoteByTitle();
    void edit(int id, Note note);
    void remove(int noteId);
    Note findByNoteId(Integer noteId);
}

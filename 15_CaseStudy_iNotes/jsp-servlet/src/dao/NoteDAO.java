package dao;

import model.Note;
import model.NoteType;

import java.util.List;

public interface NoteDAO {
    List<Note> findAll();
    List<NoteType> findAllNoteType();
    List<Note> findByTitle(String title);
    Note findByNoteId(Integer noteId);
    void save(Note note);
    List<Note> sortNoteByTitle();
    void edit(int noteId, Note note);
    void remove(int noteId);
}

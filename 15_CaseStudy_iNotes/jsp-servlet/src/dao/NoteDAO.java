package dao;

import model.Note;
import model.NoteType;

import java.sql.SQLException;
import java.util.List;

public interface NoteDAO {
    List<Note> findAll();

    List<NoteType> findAllNoteType();

    void save(Note note);

//    Note findById(int noteId);

    List<Note> findByTitle(String title);



//    List<Note> sortByName();

    void update(int id, Note note);

    void remove(int id);
}

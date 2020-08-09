package bo;

import model.Note;
import model.NoteType;

import java.util.List;

public interface NoteBO {
    List<NoteType> findAllNoteType();
    List<Note> findAll();

    void save(Note note);

//    Note findById(int noteId);

    List<Note> findByTitle(String title);



//    List<Note> sortByName();

    void update(int id, Note note);

    void remove(int id);
}

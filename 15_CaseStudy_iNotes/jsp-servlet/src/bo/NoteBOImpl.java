package bo;

import dao.NoteDAO;
import dao.NoteDAOImpl;
import model.Note;
import model.NoteType;

import java.util.List;

public class NoteBOImpl implements NoteBO{
    private NoteDAO noteDAO = new NoteDAOImpl();

    @Override
    public List<NoteType> findAllNoteType() {
        return this.noteDAO.findAllNoteType();
    }

    @Override
    public List<Note> findAll() {
        return this.noteDAO.findAll();
    }

    @Override
    public void save(Note note) {
        this.noteDAO.save(note);
    }

    @Override
    public List<Note> findByTitle(String title) {
        return this.noteDAO.findByTitle(title);
    }

    @Override
    public void update(int id, Note note) {
        this.noteDAO.save(note);
    }

    @Override
    public void remove(int id) {
        this.noteDAO.remove(id);
    }
}

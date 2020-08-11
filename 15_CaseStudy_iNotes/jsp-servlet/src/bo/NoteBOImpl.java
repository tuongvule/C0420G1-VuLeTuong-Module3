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
    public List<Note> sortNoteByTitle() {
        return this.noteDAO.sortNoteByTitle();
    }

    @Override
    public List<Note> findByTitle(String title) {
        return this.noteDAO.findByTitle(title);
    }

    @Override
    public void edit(int id, Note note) {
        this.noteDAO.edit(id,note);
    }

    @Override
    public void remove(int idNote) {
        this.noteDAO.remove(idNote);
    }

    @Override
    public Note findByNoteId(Integer noteId) {
        return this.noteDAO.findByNoteId(noteId);
    }
}

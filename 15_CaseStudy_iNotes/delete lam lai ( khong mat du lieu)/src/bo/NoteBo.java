package bo;

import dao.NoteDao;
import module.Note;
import module.NoteType;

import java.util.List;

public class NoteBo implements INoteBo {
    NoteDao noteDao = new NoteDao();
    @Override
    public List<Note> selectAllNote() {
        return this.noteDao.selectAllNote();
    }

    @Override
    public Note selectNote(int id) {
       return this.noteDao.selectNote(id);
    }

    @Override
    public void insertNote(Note note) {
        this.noteDao.insertNote(note);

    }

    @Override
    public boolean deleteNote(Note note) {
        return this.noteDao.deleteNote(note);
    }

    @Override
    public List<Note> searchNote(String title) {
        return this.noteDao.searchNote(title);
    }

    @Override
    public List<NoteType> selectAllNoteType() {
        return this.noteDao.selectAllNoteType();
    }
}

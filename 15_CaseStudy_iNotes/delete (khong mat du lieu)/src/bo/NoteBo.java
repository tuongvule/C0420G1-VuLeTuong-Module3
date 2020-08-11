package bo;

import dao.NoteDao;
import model.Note;
import model.NoteType;

import java.util.List;

public class NoteBo implements INoteBo {
    NoteDao noteDao = new NoteDao();
    @Override
    public List<Note> selectAllNote() {
        return noteDao.selectAllNote();
    }
    public List<NoteType> selectAllNoteType(){
        return noteDao.selectAllTypeNote();
    }

    @Override
    public Note selectNote(int id) {
        return noteDao.selectNote(id);
    }

    @Override
    public void insertNote(Note note) {
        noteDao.insertNote(note);
    }

    @Override
    public boolean deleteNote(Note note)
    {
        return noteDao.deleteNote(note);
    }
    @Override
    public boolean editNote(Note note) {
        return noteDao.editNote(note);
    }

    @Override
    public List<Note> searchNote(String title) {
        return noteDao.searchNote(title);
    }
}

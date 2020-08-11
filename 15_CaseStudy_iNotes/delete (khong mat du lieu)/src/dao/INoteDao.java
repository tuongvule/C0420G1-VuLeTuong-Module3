package dao;

import model.Note;
import model.NoteType;

import java.sql.SQLException;
import java.util.List;

public interface INoteDao {
public List<Note> selectAllNote();
public Note selectNote(int id) throws SQLException;
public void insertNote(Note note);
public boolean deleteNote(Note note);
public boolean editNote(Note note);
public List<Note> searchNote(String title);
public List<NoteType> selectAllTypeNote();
}

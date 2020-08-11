package dao;
import model.Note;
import model.NoteType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class NoteDAOImpl implements NoteDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_NOTE_TYPE = "select id_type, `name`, `description` from note_type;";
    private static final String FIND_ALL_NOTE = "select id, title, content, id_type from note;";
    private static final String FIND_NOTE_BY_ID = "select id, title, content, id_type from note where id=?;";
    private static final String FIND_NOTE_BY_TITLE="select id, title, content, id_type from note where title like concat ('%',?,'%')";
    private static final String SAVE_SQL= "INSERT INTO note (title, content, id_type) VALUES (?, ?, ?);";
    private static final String UPDATE_SQL= "UPDATE note SET title = ?, content = ?, id_type = ? WHERE (id = ?);";
    private static final String REMOVE = "delete from note where (id=?)";
    private static final String SORT_NOTE_BY_TITLE = "select * from note order by title asc;";

    @Override
    public List<Note> findAll() {
        List<Note> noteList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_NOTE);
            ResultSet resultSet =     preparedStatement.executeQuery();
            Note note = null;
            while (resultSet.next()){
                note = new Note();
                note.setNoteId(resultSet.getInt(1));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("id_type"));
                noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }
    @Override
    public List<NoteType> findAllNoteType() {
        List<NoteType> noteTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_ALL_NOTE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            NoteType noteType = null;
            while (resultSet.next()){
                noteType = new NoteType();
                noteType.setNoteTypeId(resultSet.getInt("id_type"));
                noteType.setName(resultSet.getString("name"));
                noteTypeList.add(noteType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteTypeList;
    }
    @Override
    public void save(Note note) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_SQL);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setInt(3, note.getTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> sortNoteByTitle() {
        List<Note> noteList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SORT_NOTE_BY_TITLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Note note = null;
            while (resultSet.next()){
                note = new Note();
                note.setNoteId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("id_type"));
                noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }

    @Override
    public List<Note> findByTitle(String title) {
        List<Note> noteList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_NOTE_BY_TITLE);
            preparedStatement.setString(1,title);
            ResultSet resultSet =     preparedStatement.executeQuery();
            Note note = null;
            while (resultSet.next()){
                note = new Note();
                note.setNoteId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("id_type"));
                noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }
    @Override
    public Note findByNoteId(Integer noteId) {
        Note note = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_NOTE_BY_ID);
            preparedStatement.setInt(1,noteId);
            ResultSet resultSet =     preparedStatement.executeQuery();
            while (resultSet.next()) {
                note = new Note();
                note.setNoteId(resultSet.getInt("id"));
                note.setTitle(resultSet.getString("title"));
                note.setContent(resultSet.getString("content"));
                note.setTypeId(resultSet.getInt("id_type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return note;
    }
    @Override
    public void edit(int noteId, Note note) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setInt(3, note.getTypeId());
//            preparedStatement.setInt(4, note.getNoteId());
            preparedStatement.setInt(4,noteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void remove(int noteId) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(REMOVE);
            preparedStatement.setInt(1,noteId);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

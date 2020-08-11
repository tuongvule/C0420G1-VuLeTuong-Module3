package dao;

import model.Note;
import model.NoteType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDao implements INoteDao{
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_NOTE ="select * from note";
    private static final String SELECT_ALL_TYPE_NOTE ="select id,`name` from note_type";
    private static final String INSERT_NOTE_SQL ="insert into note (title,content,type_id) value (?,?,?)";
    private static final String SELECT_NOTE_BY_ID ="select id,title,content,type_id from note where id =?";
    private static final String UPDATE_NOTE_SQL = "update note set title = ?,content= ?, type_id =? where id = ?;";
    private static final String DELETE_NOTE_SQL = "delete from note where id = ?;";
    private static final String SELECT_NOTE_BY_TITLE = "{call search_by_title (?)}";
    @Override
    public List<Note> selectAllNote() {
        List<Note> noteList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_NOTE);
            ResultSet rs = preparedStatement.executeQuery();
            Note note;
            while (rs.next()){
                 note = new Note();
                 note.setId(rs.getInt("id"));
                 note.setTitle(rs.getString("title"));
                 note.setContent(rs.getString("content"));
                 note.setType_Id(rs.getInt("type_id"));
                 noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }
    public List<NoteType> selectAllTypeNote(){
        List<NoteType> noteTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_TYPE_NOTE);
            ResultSet rs = preparedStatement.executeQuery();
            NoteType noteType;
            while (rs.next()){
                noteType = new NoteType();
                noteType.setId_note_type(rs.getInt("id"));
                noteType.setName_type(rs.getString("name"));
                noteTypeList.add(noteType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteTypeList;
    }

    @Override
    public Note selectNote(int id) {
        Note note = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_NOTE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String content = rs.getString("content");
                int type_id = rs.getInt("type_id");
                note = new Note(id,title,content,type_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return note;
    }

    @Override
    public void insertNote(Note note) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_NOTE_SQL);
            preparedStatement.setString(1,note.getTitle());
            preparedStatement.setString(2,note.getContent());
            preparedStatement.setInt(3,note.getType_Id());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteNote(int id) {
        boolean deleteNote = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_NOTE_SQL);
            preparedStatement.setInt(1,id);
            deleteNote = preparedStatement.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteNote;
    }

    @Override
    public boolean editNote(Note note) {
        boolean editNote = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_NOTE_SQL);
            preparedStatement.setString(1,note.getTitle());
            preparedStatement.setString(2,note.getContent());
            preparedStatement.setInt(3,note.getType_Id());
            preparedStatement.setInt(4,note.getId());
            editNote = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return editNote;
    }

    @Override
    public List<Note> searchNote(String title) {
        List<Note> noteList = new ArrayList<>();
        Note note= null;
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(SELECT_NOTE_BY_TITLE);
            callableStatement.setString(1,title);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                note= new Note();
                note.setId(rs.getInt("id"));
                note.setTitle(rs.getString("title"));
                note.setContent(rs.getString("content"));
                note.setType_Id(rs.getInt("type_id"));
                noteList.add(note);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }
}

package dao;

import model.Note;
import model.NoteType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDAOImpl implements NoteDAO{
    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_NOTE_TYPE = "select id_type, `name` , description from note_type";
    @Override
    public List<Note> findAll() {
        return null;
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
                noteType.setNoteTypeId(Integer.parseInt(resultSet.getString("id_type")));
                noteType.setNoteTypeId(Integer.parseInt(resultSet.getString("name")));
                noteType.setNoteTypeId(Integer.parseInt(resultSet.getString("note_type")));
                noteTypeList.add(noteType);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return noteTypeList;
    }

    @Override
    public void save(Note note) {

    }

    @Override
    public List<Note> findByTitle(String title) {
        return null;
    }

    @Override
    public void update(int id, Note note) {

    }

    @Override
    public void remove(int id) {

    }
}

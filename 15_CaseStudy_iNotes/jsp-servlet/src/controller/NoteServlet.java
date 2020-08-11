package controller;

import bo.NoteBO;
import bo.NoteBOImpl;
import model.Note;
import model.NoteType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteServlet", urlPatterns = "/noteServlet")
public class NoteServlet extends HttpServlet {
    private NoteBO noteBO = new NoteBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewNote(request, response);
                break;
            case "edit":
                editNote(request, response);
                break;
            case "delete":
                deleteNote(request, response);
                break;
            case "search-by-country":
//                showSearchByCountryForm(request, response);
                break;
            case "user-list-sorted-by-name":
//                listUserSortedByName(request, response);
                break;
            case "view":
//                viewUser(request, response);
                break;
            case "search":
//                showSearchForm(request, response);
            default:
                break;
        }
    }

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) {
        List<Note> noteList = this.noteBO.findAll();
        List<NoteType> noteTypeList = this.noteBO.findAllNoteType();
        request.setAttribute("noteList", noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        int noteId = Integer.parseInt(request.getParameter("noteId"));
//        Note note = this.noteBO.findByNoteId(noteId);
//        RequestDispatcher dispatcher;
//        if (note == null) {
//            dispatcher = request.getRequestDispatcher("error_404.jsp");
//        } else {
//            this.noteBO.remove(noteId);
//            try {
//                response.sendRedirect("/noteServlet");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        this.noteBO.remove(noteId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editNote(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int noteId = Integer.parseInt(request.getParameter("noteId"));
//        Note note = this.noteBO.findByNoteId(noteId);
        Note note = new Note(noteId,typeId,title,content);
        RequestDispatcher dispatcher;
        if (note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
//            note.setTitle(title);
//            note.setContent(content);
//            note.setTypeId(typeId);
            this.noteBO.edit(noteId, note);
//            request.setAttribute("note",note);
            request.setAttribute("message","Product information was updated");
            dispatcher = request.getRequestDispatcher("note/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewNote(HttpServletRequest request, HttpServletResponse response) {
        String tile = request.getParameter("title");
        String content = request.getParameter("content");
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Note note = new Note();
        note.setTitle(tile);
        note.setContent(content);
        note.setTypeId(typeId);
        this.noteBO.save(note);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");
        request.setAttribute("message", "New note was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "sort":
                sortNoteByTitle(request, response);
                break;
            case "view":
                showViewForm(request, response);
                break;
            case "find":
                findNoteForm(request, response);
            default:
                listNote(request, response);
                break;
        }
    }

    private void sortNoteByTitle(HttpServletRequest request, HttpServletResponse response) {
        List<Note> noteList =this.noteBO.sortNoteByTitle();
        List<NoteType> noteTypeList =this.noteBO.findAllNoteType();
        request.setAttribute("noteList", noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/list.jsp");
        request.setAttribute("message","ListNotes after Sorting");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void findNoteForm(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        List<Note> noteList =this.noteBO.findByTitle(title);
        List<NoteType> noteTypeList =this.noteBO.findAllNoteType();
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/list.jsp");
        request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        request.setAttribute("message","List All Note");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        Note note = this.noteBO.findByNoteId(noteId);
        RequestDispatcher dispatcher;
        if (note == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("note",note);
            dispatcher = request.getRequestDispatcher("note/view.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> noteTypeList = this.noteBO.findAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        Note note = this.noteBO.findByNoteId(noteId);
        RequestDispatcher dispatcher;
        if (note == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("note", note);
            dispatcher = request.getRequestDispatcher("note/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> noteTypeList = this.noteBO.findAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        Note note = this.noteBO.findByNoteId(noteId);
        RequestDispatcher dispatcher;
        if (note == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("note", note);
            dispatcher = request.getRequestDispatcher("note/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> noteTypeList = this.noteBO.findAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listNote(HttpServletRequest request, HttpServletResponse response) {
       List<Note> noteList = this.noteBO.findAll();
        List<NoteType> noteTypeList = this.noteBO.findAllNoteType();
        request.setAttribute("noteList", noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

package controller;

import bo.INoteBo;
import bo.NoteBo;
import model.Note;
import model.NoteType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NoteManagementServlet", urlPatterns = "/NoteManagementServlet")
public class NoteManagementServlet extends HttpServlet {
    private INoteBo iNoteBo = new NoteBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case "create":
                    createNote(request,response);
                    break;
                case "edit":
                    editNote(request,response);
                    break;
                case "delete":
                    deleteNote(request,response);
                    break;
                case "search":
                    searchNote(request,response);
                    break;
                default:
                    showList(request,response);
                    break;
            }

    }

    private void searchNote(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        List<Note> noteList =this.iNoteBo.searchNote(title);
        List<NoteType> noteTypeList =iNoteBo.selectAllNoteType();
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

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int delete_note = Integer.parseInt(request.getParameter("delete_note"));
        Note note = new Note(id,delete_note+1);
        this.iNoteBo.deleteNote(note);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("note/deletecss.jsp");
//        request.setAttribute("message","The note was deleted");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            response.sendRedirect("/NoteManagementServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int typeId = Integer.parseInt(request.getParameter("noteTypeId"));
        Note note = new Note(id,title,content,typeId);
        this.iNoteBo.editNote(note);
        try {
            response.sendRedirect("/NoteManagementServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
////        RequestDispatcher dispatcher = request.getRequestDispatcher("note/edit.jsp");
//        request.setAttribute("message","The note was updateed");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void createNote(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int type_Id = Integer.parseInt(request.getParameter("noteTypeId"));
        Note note = new Note(title,content,type_Id);
        this.iNoteBo.insertNote(note);
        try {
            response.sendRedirect("/NoteManagementServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");
//        request.setAttribute("message","New Note was created");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatNote(request,response);
                break;
            case "edit":
                showEditNote(request,response);
                break;
            case "delete":
                showDeleteNote(request,response);
                break;
            case "view":
                viewNote(request,response);
                break;

            default:
                showList(request,response);
                break;
        }
    }

    private void viewNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = iNoteBo.selectNote(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("note/viewcss.jsp");
        request.setAttribute("noteView",note);
        List<NoteType> noteTypeList = iNoteBo.selectAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = iNoteBo.selectNote(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("note/deletecss.jsp");
        request.setAttribute("noteDelete",note);
        List<NoteType> noteTypeList = iNoteBo.selectAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditNote(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Note note = iNoteBo.selectNote(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("note/editcss.jsp");
        request.setAttribute("noteEdit",note);
        List<NoteType> noteTypeList = iNoteBo.selectAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreatNote(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> noteTypeList = iNoteBo.selectAllNoteType();
        request.setAttribute("noteTypeList",noteTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Note> noteList = iNoteBo.selectAllNote();
        List<NoteType> noteTypeList =iNoteBo.selectAllNoteType();
        request.setAttribute("noteList",noteList);
        request.setAttribute("noteTypeList",noteTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("note/listcss.jsp");
        try {
            dispatcher.forward(request,response);
    } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

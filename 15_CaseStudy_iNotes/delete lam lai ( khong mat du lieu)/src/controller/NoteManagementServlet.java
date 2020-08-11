package controller;

import bo.INoteBo;
import bo.NoteBo;
import module.Note;
import module.NoteType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteManagementServlet",urlPatterns = "/NoteManagementServlet")
public class NoteManagementServlet extends HttpServlet {
    private INoteBo iNoteBo = new NoteBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createNote(request,response);
                break;
            case "edit":
//                editNote(request,response);
                break;
            case "delete":
//                deleteNote(request,response);
                break;
            case "search":
//                searchNote(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                showCreatNote(request,response);
                break;
            case "edit":
//                showEditNote(request,response);
                break;
            case "delete":
                showDeleteNote(request,response);
                break;
            case "search":

                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showDeleteNote(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = iNoteBo.selectNote(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("note/delete.jsp");
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

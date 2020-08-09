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
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
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
//                listNote(request, response);
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
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
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
                listNote(request, response);
                break;
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

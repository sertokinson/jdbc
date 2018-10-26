package ru.sertok.jdbc.servlets;

import ru.sertok.jdbc.repository.api.Repository;
import ru.sertok.jdbc.repository.impl.LocalRepository;
import ru.sertok.jdbc.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Repository repository;

    @Override
    public void init() throws ServletException {
        repository = new LocalRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = Utils.decode(req.getParameter("name"));
        String password = req.getParameter("password");
       // if(repository.isExist(name,password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user",name);
            resp.sendRedirect(req.getContextPath() + "/users");
       // }
        doGet(req,resp);
    }
}

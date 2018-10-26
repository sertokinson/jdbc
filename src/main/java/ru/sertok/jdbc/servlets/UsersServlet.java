package ru.sertok.jdbc.servlets;

import ru.sertok.jdbc.repository.api.Repository;
import ru.sertok.jdbc.repository.impl.LocalRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private Repository repository;

    @Override
    public void init() {
        repository = new LocalRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",repository.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jdbc/users.jdbc");
        dispatcher.forward(req,resp);
    }
}

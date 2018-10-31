package ru.sertok.jdbc.servlets;

import ru.sertok.jdbc.dao.impl.UserDao;
import ru.sertok.jdbc.repository.ConnectionUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        ConnectionUserDao connection = new ConnectionUserDao();
        userDao = connection.getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userDao.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/users.jsp");
        dispatcher.forward(req,resp);
    }
}

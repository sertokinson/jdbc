package ru.sertok.jdbc.servlets;

import ru.sertok.jdbc.repository.api.Repository;
import ru.sertok.jdbc.repository.impl.LocalRepository;
import ru.sertok.jdbc.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private Repository repository;

    @Override
    public void init() {
        repository = new LocalRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = Utils.decode(req.getParameter("name"));
        String password = req.getParameter("password");
        Date birthDate = new Date(req.getParameter("birthDate"));

        //repository.save(new User(name, Utils.hash(password), birthDate));
        resp.sendRedirect(req.getContextPath() + "/users");
    }


}
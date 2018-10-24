package ru.sertok.jsp.servlets;

import ru.sertok.jsp.entities.User;
import ru.sertok.jsp.repository.api.Repository;
import ru.sertok.jsp.repository.impl.LocalRepository;
import ru.sertok.jsp.utils.UpdatableBCrypt;
import ru.sertok.jsp.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

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
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        repository.save(new User(name, Utils.hash(password), birthDate));
        resp.sendRedirect(req.getContextPath() + "/users");
    }


}

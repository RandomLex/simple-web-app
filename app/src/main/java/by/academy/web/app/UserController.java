package by.academy.web.app;

import by.academy.web.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        int age = Integer.parseInt(req.getParameter("age"));
        log.info("Fio = {}, age = {}", fio, age);
        Teacher teacher = new Teacher(fio, age);
        HttpSession session = req.getSession();
        session.setAttribute("teacher", teacher);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result");
        requestDispatcher.forward(req, resp);
    }
}

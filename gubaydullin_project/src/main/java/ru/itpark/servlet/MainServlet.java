package ru.itpark.servlet;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.itpark.models.User;
import ru.itpark.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    private UsersService usersService;

    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("dev");
        context.load("ru.itpark\\context.xml");
        context.refresh();
        usersService = context.getBean(UsersService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        /*String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        User user = new User(name, mail);
        usersService.register(user);*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        /*String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        User user = new User(name, mail);
        usersService.register(user);*/
        String userNameSignUp = request.getParameter("usernamesignup");
        String emailSignUp = request.getParameter("emailsignup");
        //String passwordSignUp = request.getParameter("passwordsignup");
        User user = new User(userNameSignUp, emailSignUp);
        usersService.register(user);

        PrintWriter writer = response.getWriter();
        writer.write("<h6> Регистрация успешно завершена. </h6>");
    }



}

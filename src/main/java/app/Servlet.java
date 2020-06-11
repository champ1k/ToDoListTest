package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


@WebServlet(name = "sample-servlet", urlPatterns = "/sample")
public class Servlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(Servlet.class);
    CopyOnWriteArrayList users = new CopyOnWriteArrayList();
    int userquantity = users.size();

    @Override
    public void init() {
        log.info("App Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User(req.getHeader("User-Agent"),req.getHeader("X-Forwarded-For"));

        PrintWriter responseBody = resp.getWriter();
        users.add(user);
        resp.setContentType("text/html");
        for (int i =0;i<userquantity;i++) {
            responseBody.println("<b align=\"center\">"+users.get(i).toString()+"</b>");
        }


    }

    @Override
    public void destroy() {
        log.info("App Servlet destroyed");
    }



//    PrintWriter responseBody = resp.getWriter();
//
//        resp.setContentType("text/html");
//        responseBody.println("<h1 align=\"center\">Sample Servlet GET method processing</h1>");
//
//
//    String client = req.getParameter("client");
//        if (client == null) {
//        client = "anonymous user";
//    }
//
//    responseBody.println("<h3 align=\"center\">Hi, " + client + " </h3>");
}
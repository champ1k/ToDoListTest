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
    private ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();

    @Override
    public void init() {
        log.info("App Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User(req.getRemoteAddr(), req.getHeader("User-Agent"));
        users.put(user.getIp(), user.getAddress());
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        users.forEach((key, value) -> responseBody.println(key + "::" + value));

    }

    @Override
    public void destroy() {
        log.info("App Servlet destroyed");
    }

}
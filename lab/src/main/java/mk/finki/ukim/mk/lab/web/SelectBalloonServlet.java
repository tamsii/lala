package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="SelectBalloonServlet", urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        Order order = new Order(color);
        req.getSession().setAttribute("order", order);
        webContext.setVariable("color" ,color);
        springTemplateEngine.process("selectBalloonSize.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");
        req.getSession().setAttribute("size", size);
        resp.sendRedirect("/BalloonOrder");
    }
}

package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BalloonOrderServlet",urlPatterns = "/BalloonOrder")
public class BalloonOrderServlet extends HttpServlet  {
    private final SpringTemplateEngine springTemplateEngine;


    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        Order order = new Order(color, size);
        req.getSession().setAttribute("order", order);
        webContext.setVariable("order" ,order);
        springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String addressName = req.getParameter("addressName");
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        Order order = new Order(color, size, clientName, addressName, 0L);
        req.getSession().setAttribute("order",order);
        resp.sendRedirect("/ConfirmationInfo");
    }
}

package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.BitAction;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    HashMap<String, BitAction> map;

    @Override
    public void init(ServletConfig config) throws ServletException {
        map = new HashMap<String, BitAction>();
        String path = config.getServletContext().getRealPath("WEB-INF");

        try {
            FileReader fr = new FileReader(path + "/bit.properties");
            Properties prop = new Properties();
            prop.load(fr);
            Iterator iter = prop.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                String clsName = (String) prop.get(key);
                BitAction action = (BitAction) Class.forName(clsName).newInstance();
                map.put(key, action);
            }
        } catch (Exception e) {
            System.out.println("init error:" + e.getMessage());
        }
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
        String cmd = uri.substring(uri.indexOf("/", 1) + 1);
        BitAction action = map.get(cmd);
        String viewPage = action.pro(request, response);
        if (viewPage.endsWith(".do")) {
            response.sendRedirect(viewPage);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pro(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pro(request, response);
    }

}

package il.ac.hit.todolist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.todolist.model.HibernateToDoListDAO;
import il.ac.hit.todolist.model.IToDoListDAO;
import il.ac.hit.todolist.model.Item;
import il.ac.hit.todolist.model.ToDoListException;
import il.ac.hit.todolist.model.User;

/**
 * Servlet implementation class AppRouter
 */
@WebServlet("/controller/*")
public class AppRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IToDoListDAO dao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppRouter() {
        super();
        dao = HibernateToDoListDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String path = request.getPathInfo();
		
		switch(path)
		{
		case "/login":
			String jspPage = "/login.jsp";
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			if (userName != null || password != null)
			{
				if (userName.isEmpty() || password.isEmpty())
				{
					String message = "Ooops, you forgot to enter your credentials";
					request.setAttribute("message", message);
				}
				else
				{
					try {
						User user = dao.getAuthenticatedUser(userName, password);
						if (null != user)
						{
							List<Item> userItems = dao.getUserItems(user.getUserId());
							request.setAttribute("userItems", userItems);
							request.setAttribute("userFirstName", user.getFirstName());
							jspPage = "/userPage.jsp";
						}
						else
						{
							request.setAttribute("message", "Sorry, wrong userName or password");
						}
					} catch (ToDoListException e) {
						e.printStackTrace();
					}
				}
			}
			
			dispatcher = getServletContext().getRequestDispatcher(jspPage);
			dispatcher.forward(request, response);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

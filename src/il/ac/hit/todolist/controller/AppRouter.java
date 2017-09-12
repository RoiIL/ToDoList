package il.ac.hit.todolist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	RequestDispatcher dispatcher = null;
	User user = null;
	String userName = null;
	String password = null;
	String jspPage = "/index.jsp";
       
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
		String path = request.getPathInfo();

		switch(path)
		{
		case "/index":
			jspPage = "/index.jsp";
			break;
		case "/login":
			handleLoginPage(request, response);
			break;
		case "/addItem":
			handleAddItemPage(request, response);
			break;
		case "/userPage":
			jspPage = "/userPage.jsp";
			break;
		case "/deleteItem":
			handleDeleteItem(request, response);
			break;
			
		}
		dispatcher = getServletContext().getRequestDispatcher(jspPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void handleLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		jspPage = "/login.jsp";
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		
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
					user = dao.getAuthenticatedUser(userName, password);
					
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
	}
	
	private void handleAddItemPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		jspPage = "/addItem.jsp";
		String itemContent = request.getParameter("itemContent");
		
		if (null != user && null != itemContent)
		{
			if (!itemContent.isEmpty())
			{
				Item newItem = new Item(user.getUserId(), itemContent);
				try {
					dao.addItem(newItem);
					List<Item> userItems = dao.getUserItems(user.getUserId());
					request.setAttribute("userItems", userItems);
					request.setAttribute("userFirstName", user.getFirstName());
					jspPage = "/userPage.jsp";
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
			else
			{
				request.setAttribute("message", "Ooops... You did not write your plan...");
			}
		}
	}
	
	private void handleDeleteItem(HttpServletRequest request, HttpServletResponse response) 
	{	
		jspPage = "/userPage.jsp";
		String strItemId = request.getParameter("itemId");
		
		if (null != user && null != strItemId)
		{
			if (!strItemId.isEmpty())
			{
				try {
					long itemId = Long.parseLong(strItemId);
					Item item = dao.getItem(user.getUserId(), itemId);
					if (null != item)
					{
						dao.deleteItem(item);
					}
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
		}
		
		List<Item> userItems = null;
		try {
			userItems = dao.getUserItems(user.getUserId());
			request.setAttribute("userItems", userItems);
			request.setAttribute("userFirstName", user.getFirstName());
			jspPage = "/userPage.jsp";
		} catch (ToDoListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

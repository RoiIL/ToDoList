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
/**
 * @author IR
 *
 */
@WebServlet("/controller/*")
public class AppRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IToDoListDAO dao = null;
	RequestDispatcher dispatcher = null;
	String jspPage = "/index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppRouter() {
        super();
        dao = HibernateToDoListDAO.getInstance();
    }

	/**
	 * This method act like the router routing all post and get requests to be handles acordingly
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
		case "/signup":
			handleSignUpPage(request, response);
			break;
		case "/addItem":
			handleAddItemPage(request, response);
			break;
		case "/userPage":
			handleUserPage(request, response);
			break;
		case "/deleteItem":
			handleDeleteItem(request, response);
			break;
		case "/updateItem":
			handleUpdateItem(request, response);
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
	
	/**
	 * Handle the log in session, authenticating the user and forwading to it's page
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		jspPage = "/login.jsp";
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
						request.getSession().setAttribute("userId", user.getUserId());
						handleUserPage(request, response);
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
	
	/**
	 * Handling the sign up request for the new user
	 * @param request
	 * @param response
	 */
	private void handleSignUpPage(HttpServletRequest request, HttpServletResponse response) {
		jspPage = "/signup.jsp";
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (firstName != null || lastName != null || userName != null || password != null)
		{
			if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty())
			{
				String message = "Ooops, look like you didn't fill the blanks :)";
				request.setAttribute("message", message);
			}
			else
			{
				try {
					User newUser = new User(userName, firstName, lastName, password);
					request.getSession().setAttribute("userId", newUser.getUserId());
					dao.addUser(newUser);
					try {
						handleLoginPage(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Handling the user page, displaying the user's item allowing to add item, delete and update. 
	 * @param request
	 * @param response
	 */
	private void handleUserPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long userId = (Long)request.getSession().getAttribute("userId");
			List<Item> userItems = dao.getUserItems(userId);
			request.setAttribute("userItems", userItems);
			User user = dao.getUserById(userId);
			request.setAttribute("userFirstName", user.getFirstName());
			jspPage = "/userPage.jsp";
		} catch (ToDoListException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle adding and item if new content was typed
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleAddItemPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String itemContent = request.getParameter("itemContent");
		jspPage = "/addItem.jsp";
		if (null != itemContent)
		{
			if (!itemContent.isEmpty())
			{
				Long userId = (Long)request.getSession().getAttribute("userId");
				Item newItem = new Item(userId, itemContent);
				try {
					dao.addItem(newItem);
					handleUserPage(request, response);
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
	
	/**
	 * Deleting the chosen item
	 * @param request
	 * @param response
	 */
	private void handleDeleteItem(HttpServletRequest request, HttpServletResponse response) 
	{	
		jspPage = "/userPage.jsp";
		String strItemId = request.getParameter("itemId");
		
		if (null != strItemId)
		{
			if (!strItemId.isEmpty())
			{
				try {
					Long userId = (Long)request.getSession().getAttribute("userId");
					long itemId = Long.parseLong(strItemId);
					Item item = dao.getItem(userId, itemId);
					if (null != item)
					{
						dao.deleteItem(item);
					}
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
		}
		handleUserPage(request, response);
	}
	
	/**
	 * Updating the chosen item if new content was typed
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handleUpdateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		jspPage = "/updateItem.jsp";
		String updateContent = request.getParameter("updateContent");
		String strItemId = request.getParameter("itemId");
		long itemId = Long.parseLong(strItemId);
		
		if (null != updateContent)
		{
			if (!updateContent.isEmpty())
			{
				try {
					Long userId = (Long)request.getSession().getAttribute("userId");
					Item updateItem = dao.getItem(userId, itemId);
					updateItem.setContent(updateContent);
					dao.updateItem(updateItem);
					handleUserPage(request, response);
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
			else
			{
				request.setAttribute("message", "Ooops... You did't change your plan... </br> cancel maybe?");
				try {
					Long userId = (Long)request.getSession().getAttribute("userId");
					Item curItem = dao.getItem(userId, itemId);
					String curContent = curItem.getContent();
					request.setAttribute("itemContent", curContent);
					request.setAttribute("itemId", strItemId);
				} catch (ToDoListException e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			try {
				Long userId = (Long)request.getSession().getAttribute("userId");
				Item curItem = dao.getItem(userId, itemId);
				String curContent = curItem.getContent();
				request.setAttribute("itemContent", curContent);
				request.setAttribute("itemId", strItemId);
			} catch (ToDoListException e) {
				e.printStackTrace();
			}
		}
	}
}

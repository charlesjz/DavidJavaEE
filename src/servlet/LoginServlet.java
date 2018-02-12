package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.UserProfile;
import services.AuthService;
import services.AuthServiceImpl;
import services.InvalidUsernameOrPasswordException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		String result = "";
		
		System.out.println ( "doGet() is called." );
//		AuthService service = new AuthServiceImpl ( );
		AuthService service = AuthServiceImpl.getInstance();
		try {
			UserProfile userProfile = service.authenticate(username, password);
			request.setAttribute( "CurrentUserProfile", userProfile );
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp"); 
			rd.forward(request, response);  
		} catch (InvalidUsernameOrPasswordException e) {
//			result = "Authentication failed (invalid username or password). Please try again.";
//			String resultPageContent = "<html><head><title>" + result + "</title></head><body><h1>" + result + "</h1></body></htnml>";
//			response.getWriter().append( resultPageContent );
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?err=1"); 
			rd.forward(request, response);
		}
//		if ( "abc".equals( username ) && "123".equals( password ) ) {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

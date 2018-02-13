package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.UsageColletingFilter;

/**
 * Servlet implementation class CheckInfoServlet
 */
//@WebServlet(
//		urlPatterns = { "/CheckInfo" }, 
//		initParams = { 
//				@WebInitParam(name = "counter", value = "100")
//		})
public class CheckInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		
//		this.counter = Integer.parseInt( config.getInitParameter( "counter" ) );
//		
//	}

//	@Override
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		this.counter++;
//		
//		PrintWriter out = response.getWriter();
//		out.println ( "<html><head><title>Check Info</title></head><body>" );
//		out.println ( "<h2>counter = " + this.counter + "</h2>" );
//		out.println ( "<h2>request.getRemoteHost() = " + request.getRemoteHost() + "</h2>" );
//		out.println ( "<h2>request.getProtocol() = " + request.getProtocol() + "</h2>" );
//		out.println ( "<h2>request.getRemoteAddr() = " + request.getRemoteAddr() + "</h2>" );
//		out.println ( "<h2>counter = " + request. + "</h2>" );
//		out.println ( "<h2>counter = " + this.counter + "</h2>" );
//		out.println ( "<h2>counter = " + this.counter + "</h2>" );
//		out.println ( "<h2>counter = " + this.counter + "</h2>" );
//		out.println ( "</body></html>" );
//		out.flush();
//		
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.counter++;
		
		PrintWriter out = response.getWriter();
		out.println ( "<html><head><title>Check Info</title></head><body>" );
		out.println ( "<h2>counter = " + this.counter + "</h2>" );
		out.println ( "<h2>request.getRemoteHost() = " + request.getRemoteHost() + "</h2>" );
		out.println ( "<h2>request.getProtocol() = " + request.getProtocol() + "</h2>" );
		out.println ( "<h2>request.getRemoteAddr() = " + request.getRemoteAddr() + "</h2>" );
		out.println ( "<h2>request.getServletPath() = " + request.getServletPath() + "</h2>" );
		out.println ( "<h2>request.getHeader( \"User-Agent\" ) = " + request.getHeader( "User-Agent" ) + "</h2>" );
		
		out.println ( "<ul> Usage Per User:" );
	
		Map<String, Integer> usageCounters = (Map<String, Integer>) request.getSession().getAttribute( "USAGE_COUNTER" );
		for ( String counterName: usageCounters.keySet() ) {
			Integer counterValue = usageCounters.get(counterName);
//			System.out.println( counterName + " : " + counterValue );
			out.println ( "<li>" + counterName + " : " + counterValue + "</li>" );
		}
		
		out.println ( "</ul>" );
		
		out.println ( "<ul> Global Usage:" );
		
		Map<String, Integer> globalUsageCounters = (Map<String, Integer>) request.getServletContext().getAttribute( "G_USAGE_COUNTER" );
		for ( String counterName: globalUsageCounters.keySet() ) {
			Integer counterValue = globalUsageCounters.get(counterName);
//			System.out.println( counterName + " : " + counterValue );
			out.println ( "<li>" + counterName + " : " + counterValue + "</li>" );
		}
		
		out.println ( "</ul>" );
		
		out.println ( "</body></html>" );
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

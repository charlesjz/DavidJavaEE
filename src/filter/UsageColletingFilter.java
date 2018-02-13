package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UsageColletingFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })
public class UsageColletingFilter implements Filter {
	
//	private Map<String, Integer> usageCounters = new HashMap<> ();

    /**
     * Default constructor. 
     */
    public UsageColletingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		if ( request instanceof HttpServletRequest ) {
			String servletPath = ((HttpServletRequest)request).getServletPath();
			HttpSession session = ((HttpServletRequest)request).getSession();
			ServletContext servletContext = request.getServletContext();
			Map<String, Integer> usageCounters = (Map<String, Integer>) session.getAttribute( "USAGE_COUNTER" );
			Map<String, Integer> globalUsageCounters = (Map<String, Integer>) servletContext.getAttribute( "G_USAGE_COUNTER" );
			if ( usageCounters == null ) {
				usageCounters = new HashMap<> ();
			}
			Integer counter = usageCounters.get( servletPath );
			if ( counter == null ) {
				counter = 1;
			} else {
				counter ++;
			}

			if ( globalUsageCounters == null ) {
				globalUsageCounters = new HashMap<> ();
			}
			Integer globalCounter = globalUsageCounters.get( servletPath );
			if ( globalCounter == null ) {
				globalCounter = 1;
			} else {
				globalCounter ++;
			}
			usageCounters.put( servletPath, counter );
			globalUsageCounters.put( servletPath, globalCounter );
			session.setAttribute( "USAGE_COUNTER", usageCounters );
			servletContext.setAttribute("G_USAGE_COUNTER", globalUsageCounters);
		}
		
//		printCounters ( );

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
//	private void printCounters ( ) {
//		System.out.println( "----------------------------" );
//		for ( String counterName: usageCounters.keySet() ) {
//			Integer counterValue = this.usageCounters.get(counterName);
//			System.out.println( counterName + " : " + counterValue );
//		}
//	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

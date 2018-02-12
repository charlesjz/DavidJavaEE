package taglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Logo2Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter ( );
		getJspBody().invoke( sw );
		JspWriter out = getJspContext().getOut( );
		out.println ( "Welcome to Vic Web App ( <i>" + sw.toString() + "</i> )" );
	}

}

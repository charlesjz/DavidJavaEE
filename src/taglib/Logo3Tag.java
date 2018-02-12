package taglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Logo3Tag extends SimpleTagSupport {
	
	private boolean bold;
	private String date;

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter ( );
		getJspBody().invoke( sw );
		JspWriter out = getJspContext().getOut( );
		StringBuffer output = new StringBuffer ( "Welcome to Vic Web App" );
		if ( isBold() ) {
			output.append ( "<b>" );
		}
		output.append( sw.toString() + this.date );
		if ( isBold() ) {
			output.append( "</b>" );
		}
		out.println ( output.toString() );	}

}

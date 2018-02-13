package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.UserProfile;

public class AppDaoImpl implements AppDao {
	
	private DataSource dataSource = null;

	private AppDaoImpl() {
		
		try {
			InitialContext initCtx = new InitialContext ( );
			Context environmentContext = (Context) initCtx.lookup("java:comp/env");

			this.dataSource = (DataSource) environmentContext.lookup( "jdbc/mybase" );
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static AppDao _dao = null;
	public static AppDao getInstance ( ) {
		if ( _dao == null ) {
			_dao = new AppDaoImpl ( );
		}
		return _dao;
	}

	@Override
	public UserProfile retrieveUserProfile(String username) {
//		return DB.USER_PROFILES.get( username );
		
		Connection conn = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver"); 
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/mybase?", "root", "");
			if ( this.dataSource == null ) {
				return null;
			}
			
			conn = this.dataSource.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement( "SELECT USERID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL FROM USER WHERE USERNAME = ?" );
			stmt.setString( 1, username );
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				int userId = rs.getInt( "USERID" );
				String uname = rs.getString ( "USERNAME" );
				String password = rs.getString ( "PASSWORD" );
				String firstname = rs.getString ( "FIRSTNAME" );
				String lastname = rs.getString ( "LASTNAME" );
				String email = rs.getString ( "EMAIL" );
				
				System.out.println( userId + "/" + username + "/" + password + "/" + firstname + "/" + lastname + "/" + email );
				
				UserProfile up = new UserProfile ( username, password, firstname, lastname, email );
				return up;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			// handle any errors
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return null;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
		} finally {
			try {
				if ( conn != null && !conn.isClosed() ) {
					conn.close();
				}
			} catch (SQLException e) { }
		}

	}

}

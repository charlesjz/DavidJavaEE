package dao;

import java.util.HashMap;
import java.util.Map;

import domain.UserProfile;

public class DB {
	
	protected static Map<String, UserProfile> USER_PROFILES = new HashMap<> ( );
	
	static {
		USER_PROFILES.put( "john123", new UserProfile ( "john123", "password", "John", "Smith", "johnsmith@gmail.com") );
		USER_PROFILES.put( "peter123", new UserProfile ( "peter123", "password", "Peter", "Pan", "peterpan@gmail.com") );
		USER_PROFILES.put( "mary123", new UserProfile ( "mary123", "password", "Mary", "Poppins", "marypoppins@gmail.com") );
	}

}

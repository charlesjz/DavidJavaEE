package dao;

import domain.UserProfile;

public interface AppDao {
	
	public UserProfile retrieveUserProfile ( String username );

}

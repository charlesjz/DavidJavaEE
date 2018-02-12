package services;

import domain.UserProfile;

public interface AuthService {
	
	public UserProfile authenticate ( String username, String password ) throws InvalidUsernameOrPasswordException;

}

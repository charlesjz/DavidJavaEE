package services;

import dao.AppDao;
import dao.AppDaoImpl;
import domain.UserProfile;

public class AuthServiceImpl implements AuthService {

	private AuthServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static AuthService _service = null;
	public static AuthService getInstance() {
		if ( _service == null ) {
			_service = new AuthServiceImpl ( );
		}
		return _service;
	}

	@Override
	public UserProfile authenticate(String username, String password) throws InvalidUsernameOrPasswordException {
//		AppDao dao = new AppDaoImpl ( );
		AppDao dao = AppDaoImpl.getInstance();
		UserProfile up = dao.retrieveUserProfile(username);
		if ( up != null && up.getPassword().equals( password ) ) {
			 return up;
		} else {
			throw new InvalidUsernameOrPasswordException();
		}
	}

}

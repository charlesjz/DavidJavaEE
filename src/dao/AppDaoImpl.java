package dao;

import domain.UserProfile;

public class AppDaoImpl implements AppDao {

	private AppDaoImpl() { }
	
	private static AppDao _dao = null;
	public static AppDao getInstance ( ) {
		if ( _dao == null ) {
			_dao = new AppDaoImpl ( );
		}
		return _dao;
	}

	@Override
	public UserProfile retrieveUserProfile(String username) {
		return DB.USER_PROFILES.get( username );
	}

}

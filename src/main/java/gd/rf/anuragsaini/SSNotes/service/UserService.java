package gd.rf.anuragsaini.SSNotes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gd.rf.anuragsaini.SSNotes.dao.UserDaoImpl;
import gd.rf.anuragsaini.SSNotes.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Transactional
	public void createUser(User user) {
		 this.userDao.saveUser(user);
	}
	public User findUserInDatabase(String uEmail) {
		return this.userDao.findUserInDatabase(uEmail);
	}
	public boolean validatePasswordInDatabase(User user, String uPassword) {
		return this.userDao.verifyUserPassword(user, uPassword);
	}
}

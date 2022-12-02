package gd.rf.anuragsaini.SSNotes.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import gd.rf.anuragsaini.SSNotes.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void saveUser(User user) {
		this.hibernateTemplate.save(user);
	}
	public User findUserInDatabase(String uEmailInput) {
		User user = this.hibernateTemplate.get(User.class, uEmailInput);
		if(user != null) {
			return user;
		}
		return null;
	}
	public boolean verifyUserPassword(User userModel, String uPasswordInput) {
		if(userModel.getuPassword().equalsIgnoreCase(uPasswordInput)) {
			return true;
		}
		return false;
	}
}

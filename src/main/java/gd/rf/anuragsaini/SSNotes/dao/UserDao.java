package gd.rf.anuragsaini.SSNotes.dao;

import gd.rf.anuragsaini.SSNotes.entities.User;

public interface UserDao {
	public void saveUser(User user);
	public User findUserInDatabase(String uEmailInput);
	public boolean verifyUserPassword(User userModel, String uPasswordInput);
}

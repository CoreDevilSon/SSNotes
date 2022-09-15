package gd.rf.anuragsaini.SSNotes.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import gd.rf.anuragsaini.SSNotes.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int saveUser(User user) {
		int id = (Integer)this.hibernateTemplate.save(user);
		return id;
	}

}

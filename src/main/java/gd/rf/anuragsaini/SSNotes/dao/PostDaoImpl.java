package gd.rf.anuragsaini.SSNotes.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import gd.rf.anuragsaini.SSNotes.entities.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int savePost(Post post) {
		return (Integer) this.hibernateTemplate.save(post);
	}
	
	public List<Post> getUserPostsByEmail (String userEmail) {
		System.out.println("Dao");
		String hql = "FROM Post P WHERE P.pAuthorEmail=:uEmail";
		Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("uEmail", userEmail);
		return (List<Post>) query.getResultList();
	}

	public Post getPostById(int id) {
		return this.hibernateTemplate.get(Post.class, id);
	}

	public int editPost(int pid, String code, String description, Date date, String title, String visibility) {
		String hql = "UPDATE Post set pCode=:code, pDescription=:description, pEditDate=:date, pTitle=:title, pVisibility=:visibility WHERE pId=:id";
		Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("code", code);
		query.setParameter("description", description);
		query.setParameter("date", date);
		query.setParameter("title", title);
		query.setParameter("visibility", visibility);
		query.setParameter("id", pid);
		return query.executeUpdate();
	}

	public int deletePost(int pid) {
		String hql = "Delete FROM Post WHERE id=:pid";
		Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("pid", pid);
		return query.executeUpdate();
	}

}

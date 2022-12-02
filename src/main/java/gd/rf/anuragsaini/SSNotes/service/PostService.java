package gd.rf.anuragsaini.SSNotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gd.rf.anuragsaini.SSNotes.dao.PostDaoImpl;
import gd.rf.anuragsaini.SSNotes.entities.Post;

@Service
public class PostService {
	
	@Autowired
	private PostDaoImpl postDao;
	
	@Transactional
	public int createPost(Post post) {
		return this.postDao.savePost(post);
	}
	
    @Transactional
    public List<Post> getAllUserPostByEmail(String userEmail) {
		System.out.println("Service");
		return this.postDao.getUserPostsByEmail(userEmail);
	}
	
    @Transactional
    public Post getPostById(int id) {
    	return this.postDao.getPostById(id);
    }
    
    @Transactional
    public int editPostById(int pid, String code, String description, Date date, String title, String visibility) {
    	return this.postDao.editPost(pid, code, description, date, title, visibility);
    }
    
    @Transactional
    public int deletePostById(int pid) {
    	return this.postDao.deletePost(pid);
    }
}

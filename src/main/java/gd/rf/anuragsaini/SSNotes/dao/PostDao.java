package gd.rf.anuragsaini.SSNotes.dao;

import java.util.Date;
import java.util.List;

import gd.rf.anuragsaini.SSNotes.entities.Post;

public interface PostDao {
	public int savePost(Post post);
	public List<Post> getUserPostsByEmail(String userEmail);
	public Post getPostById(int postId);
	public int editPost(int pid, String code, String description, Date date, String title, String visibility); 
	public int deletePost(int pid);
}

package gd.rf.anuragsaini.SSNotes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	private String pTitle;
	
	@Column(columnDefinition = "LONGTEXT")
	private String pDescription;
	
	@Column(columnDefinition = "LONGTEXT")
	private String pCode;
	
	private String pAuthorEmail;
	
	@Temporal(TemporalType.DATE)
	private Date pCreateDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date pEditDate;
	
	private int pLikes;
	
	private String pVisibility;

	public String getpVisibility() {
		return pVisibility;
	}

	public void setpVisibility(String pVisibility) {
		this.pVisibility = pVisibility;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpAuthorEmail() {
		return pAuthorEmail;
	}

	public void setpAuthorEmail(String pAuthorEmail) {
		this.pAuthorEmail = pAuthorEmail;
	}

	public Date getpCreateDate() {
		return pCreateDate;
	}

	public void setpCreateDate(Date pCreateDate) {
		this.pCreateDate = pCreateDate;
	}

	public Date getpEditDate() {
		return pEditDate;
	}

	public void setpEditDate(Date pEditDate) {
		this.pEditDate = pEditDate;
	}

	public int getpLikes() {
		return pLikes;
	}

	public void setpLikes(int pLikes) {
		this.pLikes = pLikes;
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", pTitle=" + pTitle + ", pDescription=" + pDescription + ", pCode=" + pCode
				+ ", pAuthorEmail=" + pAuthorEmail + ", pCreateDate=" + pCreateDate + ", pEditDate=" + pEditDate + ", pLikes="
				+ pLikes + "]";
	}
	
	
	
	
}

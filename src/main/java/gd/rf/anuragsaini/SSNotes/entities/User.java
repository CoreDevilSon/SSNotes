package gd.rf.anuragsaini.SSNotes.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int uId;
	
	String uName;
	String uUserName;
	String uEmail;
	String uPassword;
	String uPasswordConfirm;

	@Temporal(TemporalType.DATE)
	Date uJoinDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date uLastActive;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuUserName() {
		return uUserName;
	}

	public void setuUserName(String uUserName) {
		this.uUserName = uUserName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	public String getuPasswordConfirm() {
		return uPasswordConfirm;
	}

	public void setuPasswordConfirm(String uPasswordConfirm) {
		this.uPasswordConfirm = uPasswordConfirm;
	}

	public Date getuJoinDate() {
		return uJoinDate;
	}

	public void setuJoinDate(Date uJoinDate) {
		this.uJoinDate = uJoinDate;
	}

	public Date getuLastActive() {
		return uLastActive;
	}

	public void setuLastActive(Date uLastActive) {
		this.uLastActive = uLastActive;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uUserName=" + uUserName + ", uEmail=" + uEmail
				+ ", uPassword=" + uPassword + ", uJoinDate=" + uJoinDate + ", uLastActive=" + uLastActive + "]";
	}
	
	
}

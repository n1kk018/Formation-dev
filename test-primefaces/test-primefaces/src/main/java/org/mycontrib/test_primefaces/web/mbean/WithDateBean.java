package org.mycontrib.test_primefaces.web.mbean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class WithDateBean {
	
	private Date date;
	private String commentaire;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public String doAction(){
		System.out.println("date:" + date + " , commentaire:" + commentaire);
		return null;
	}

}

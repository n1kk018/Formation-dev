package tp.test.activiti.pers;

import java.io.Serializable;

public class Personne implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private Long age;
	
	
	public Personne() {
		super();
	}
	
	
	
	
	public Personne(String nom, Long age) {
		super();
		this.username = nom;
		this.age = age;
	}




	@Override
	public String toString() {
		return "Personne [username=" + username + ", age=" + age + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String nom) {
		this.username = nom;
	}
	
	
	public Long getAge() {
		return age;
	}




	public void setAge(Long age) {
		this.age = age;
	}




	public Double getAgeD() {
		return (double)  age;
	}
	public void setAgeD(Double ageD) {
		this.age = (long) Math.round(ageD);
	}
	
	public String getAgeS() {
		return String.valueOf(age);
	}
	public void setAgeS(String ageS) {
		this.age = Long.parseLong(ageS);
	}
	
	

}

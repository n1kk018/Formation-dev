package org.mycontrib.test_primefaces.web.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	@Size(min=2,max=128)
	private String name;
	
	@NotNull
	@Size(min=2,max=128)
	private String address;
	
	@Size(min=10,max=24)
	private String telephone;
	
	@Size(min=6,max=128)
	@Pattern(regexp="^[-\\w._]+@[-\\w._]+\\.[a-zA-Z]{2,6}$")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}

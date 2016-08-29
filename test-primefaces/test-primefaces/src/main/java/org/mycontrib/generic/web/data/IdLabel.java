package org.mycontrib.generic.web.data;

public class IdLabel {
	
	private Long id;
	private String label;
		
	public IdLabel(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	public IdLabel() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return label;
	}
	
	

}

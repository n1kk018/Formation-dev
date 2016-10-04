package tp.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {
	
	private /*Integer*/ Long id;
	private String name;
	private String label;
	private /*Date*/ String date;
	private /*Double*/ Float price;
	
	

	public Product(Long id, String name, String label) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.date = "2014-01-01";
		this.price = 1.0f;
	}
	
	public Product(Long id, String name, String label,Float price) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.date = "2014-01-01";
		this.price = price;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", label=" + label
				+ ", date=" + date + ", price=" + price + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}

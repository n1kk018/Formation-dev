package tp;

import java.util.Date;

public class MessageEssential {
	private String text;
	private Date date;
		
	public MessageEssential(String text) {
		super();
		this.text = text;
		this.date = new Date();
	}

	public MessageEssential() {
		super();		
	}
	
	@Override
	public String toString() {
		return "MessageEssential [text=" + text + ", date=" + date + "]";
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

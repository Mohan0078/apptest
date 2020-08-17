package com.patel.chat;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

public class Message {

	
//	public static void main(String [] args)
//	{
//	DateFormat dateFormat = new SimpleDateFormat("h:mm a");
//	System.out.println(java.time.LocalDate.now()); 
//	System.out.println(dateFormat);  
//	}
//	
    private String from;
    private String to;
    private String content;
    private String username;// for storing all connected users on the side of the page

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
    public String toString() {
        return super.toString();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
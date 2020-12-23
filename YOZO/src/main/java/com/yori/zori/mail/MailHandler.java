package com.yori.zori.mail;
import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
 
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


public class MailHandler{

	 

	    private JavaMailSender mailSender;
	    private MimeMessage msg;
	    private MimeMessageHelper msgHelper;
	 
	    public MailHandler(JavaMailSender mailSender) throws MessagingException {
	        this.mailSender = mailSender;
	        msg = this.mailSender.createMimeMessage();
	        msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
	    }
	    
	    // Email Title

	    public void setSubject(String subject) {
	    	try {
	    		 msgHelper.setSubject(subject);
	    	}catch(Exception e) {
	    		
	    	}
	       
	    }
	    
	    // Email Content(Text)

	    public void setText(String htmlContent)  {
	    	try {
	    		msgHelper.setText(htmlContent, true);
	    	}catch(Exception e) {
	    		
	    	}
	        
	    }
	    
	    // Sender Info

	    public void setFrom(String email, String name) {
	    	try {
	    		 msgHelper.setFrom(email, name);
	    	}catch(Exception e) {
	    		
	    	}
	       
	    }
	    
	    // Recipient Info

	    public void setTo(String email) {
	    	try {
	    		msgHelper.setTo(email);
	    	}catch(Exception e) {
	    		
	    	}
	        
	    }
	
	    public void addInline(String cotentId, DataSource dataSource) {
	    	try {
	    		msgHelper.addInline(cotentId, dataSource);
	    	}catch(Exception e) {
	    		
	    	}
	        
	    }
	    
	    public void send() {
	        try {
	            mailSender.send(msg);
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}



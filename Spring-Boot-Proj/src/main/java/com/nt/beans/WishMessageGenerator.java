package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
    @Autowired
	private Calendar c;
	public String generateWishMessage(String name) {
      
		int hour=0;
		
		//c= Calendar.getInstance();
		
		hour=c.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<=12)
			return "Good Morning"+" "+name+" "+hour;
		else if(hour<=16)
			return "Good Afternoon"+" "+name+" "+hour;
		else if(hour<=20)
			return "Good Evening"+" "+name+" "+hour;
		else
		    return "Good Night"+" "+name+" "+hour;
		
	}
}

package com.niit.portalbackend;

import java.util.Date;

public class OutputMessage extends Message{
	
	private static final long serialVersionUID = 1L;
	private Date time;
	    
	    public OutputMessage(Message original, Date time) {
	        super(original.getUsername(), original.getMessage());
	        this.time = time;
	    }

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
	    
	    

}

package com.zycus.helpers;

public class Signal {
	public static final int SUCCESS = 1;
	public static final int FAIL = 2;
	public static final int WARN = 3;
	
	private int status;
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccessSignal()
	{
		return this.getStatus()==Signal.SUCCESS;
	}
	public boolean isWarningSignal()
	{
		return this.getStatus()==Signal.WARN;
	}
	public boolean isFailureSignal()
	{
		return this.getStatus()==Signal.FAIL;
	}
	
	
}

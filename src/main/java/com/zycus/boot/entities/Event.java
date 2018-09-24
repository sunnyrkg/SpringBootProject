package com.zycus.boot.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Event {
	@Id
	@GeneratedValue
	private long id;
	private String eventName;
	private Date eventDate;
	private int numberOfPanelsRequired;
	private int numberOfPanels;
	
}
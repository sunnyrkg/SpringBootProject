package com.zycus.boot.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zycus.enums.EventStatus;
@Entity
@Table
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	private String eventName;
	private Date eventTime;
	private Date raisedTime;
	private Date esclationTime;
	private int numberOfPanelsRequired;
	private int numberOfPanels;
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus;
	@ManyToOne
	@JoinColumn(name="raisedBy")
	private User raisedBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public Date getRaisedTime() {
		return raisedTime;
	}
	public void setRaisedTime(Date raisedTime) {
		this.raisedTime = raisedTime;
	}
	public Date getEsclationTime() {
		return esclationTime;
	}
	public void setEsclationTime(Date esclationTime) {
		this.esclationTime = esclationTime;
	}
	public int getNumberOfPanelsRequired() {
		return numberOfPanelsRequired;
	}
	public void setNumberOfPanelsRequired(int numberOfPanelsRequired) {
		this.numberOfPanelsRequired = numberOfPanelsRequired;
	}
	public int getNumberOfPanels() {
		return numberOfPanels;
	}
	public void setNumberOfPanels(int numberOfPanels) {
		this.numberOfPanels = numberOfPanels;
	}
	public EventStatus getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}
	public User getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(User raisedBy) {
		this.raisedBy = raisedBy;
	}
	
	
	
}
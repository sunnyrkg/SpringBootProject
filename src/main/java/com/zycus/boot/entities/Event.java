package com.zycus.boot.entities;

import java.time.Duration;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
}
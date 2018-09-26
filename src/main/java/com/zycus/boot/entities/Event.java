package com.zycus.boot.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zycus.enums.EventStatus;

@Entity
@Table
public class Event {
	@Id
	@GeneratedValue
	private Integer id;
	private String eventName;
	private Date eventTime;
	private Date raisedTime;
	private Date esclationTime;
	private int numberOfPanelsRequired;
	private int numberOfPanels;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="designationRequiredForPanel")
	private Designation designationRequiredForPanel;
	
	public Designation getDesignationRequiredForPanel() {
		return designationRequiredForPanel;
	}

	public void setDesignationRequiredForPanel(Designation designationRequiredForPanel) {
		this.designationRequiredForPanel = designationRequiredForPanel;
	}

	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus;

	@ManyToOne
	@JoinColumn(name = "raisedBy")
	private User raisedBy;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignedPanelMembers")
	private Set<User> assignedPanelMembers;
	
	@ManyToMany
	@JoinColumn(name = "skillSetRequired")
	private Set<Skill> skillSetRequired;

	public Set<Skill> getSkillSetRequired() {
		return skillSetRequired;
	}

	public void setSkillSetRequired(Set<Skill> skillSetRequired) {
		this.skillSetRequired = skillSetRequired;
	}

	public Set<User> getAssignedPanelMembers() {
		return assignedPanelMembers;
	}

	public void setAssignedPanelMembers(Set<User> assignedPanelMembers) {
		this.assignedPanelMembers = assignedPanelMembers;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
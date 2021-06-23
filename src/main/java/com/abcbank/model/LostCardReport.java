package com.abcbank.model;


import java.util.Date;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="lost_card_report_tbl")
public class LostCardReport {
	@Id
	@Column(name="card_number")
	private Long cardNumber;
	
	@Column(name="lost_on",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date lostOn;
	
	@Column(name="request_date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date requestDate;
	
	@Column(name="response_date")
	@Temporal(TemporalType.DATE)
	private Date responseDate;
	
	@Column(name="status",length=30,nullable = false)
	private String status;
	
	@Column(name="description",length=100)
	private String description;
	
	
	@ManyToOne
    @JoinColumn(name="account_number", nullable=false)
    private Account account;


	public Long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Date getLostOn() {
		return lostOn;
	}


	public void setLostOn(Date lostOn) {
		this.lostOn = lostOn;
	}


	public Date getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


	public Date getResponseDate() {
		return responseDate;
	}


	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


}

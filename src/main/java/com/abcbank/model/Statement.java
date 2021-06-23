package com.abcbank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="statement_tbl")
public class Statement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="statement_id")
	private Long statementId;
	
	@Column(name="transaction_date",nullable = false)
	private Date transactionDate;
	
	@Column(name="type",length=10,nullable = false)
	private String type;
	
	@Column(name="description",length=100,nullable = false)
	private String description;
	
	@Column(name="creditOrDebitAmount",nullable = false)
	private Double creditOrDebitAmount;
	
	@Column(name="closing_balance",nullable = false)
	private Double closingBalance;
	
	@ManyToOne
    @JoinColumn(name="account_number", nullable=false)
    private Account account;

	public Long getStatementId() {
		return statementId;
	}

	public void setStatementId(Long statementId) {
		this.statementId = statementId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCreditOrDebitAmount() {
		return creditOrDebitAmount;
	}

	public void setCreditOrDebitAmount(Double creditOrDebitAmount) {
		this.creditOrDebitAmount = creditOrDebitAmount;
	}
	

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}

package com.abcbank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="account_tbl")
public class Account {
	
	
	public Account() {
		super();
	}


	public Account(Long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name="account_type",length=10,nullable = false)
	private String accountType;
	
	@Column(name="account_balance",nullable = false)
	private Double accountBalance;
	
	
	@Column(name="ifsc",length=30,nullable = false)
	private String ifsc;
	
	@Column(name="opening_date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date openingDate;
	
	@Column(name="closing_date")
	@Temporal(TemporalType.DATE)
	private Date closingDate;
	
	@Column(name="status",length=10,nullable = false)
	private String status;
	
	@Column(name="branch_address",length=30,nullable = false)
	private String branchAddress;
	
	@Column(name="branch_name",length=30,nullable = false)
	private String branchName;
	
	@Column(name="branch_code",length=30,nullable = false)
	private Integer branchCode;
	
	
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
	
	
	@OneToMany(mappedBy="account")
	private List<Statement> statementList = new ArrayList<>();
	
	@OneToMany(mappedBy="account")
	private List<ChequeRequest> chequeRequestList = new ArrayList<>();
	
	@OneToMany(mappedBy="account")
	private List<LostCardReport> lostCardReportList = new ArrayList<>();


	@OneToMany(mappedBy="account")
	private List<Query> queryList = new ArrayList<>();


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public Double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public String getIfsc() {
		return ifsc;
	}


	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}


	public Date getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}


	public Date getClosingDate() {
		return closingDate;
	}


	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBranchAddress() {
		return branchAddress;
	}


	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public Integer getBranchCode() {
		return branchCode;
	}


	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Statement> getStatementList() {
		return statementList;
	}


	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}


	public List<ChequeRequest> getChequeRequestList() {
		return chequeRequestList;
	}


	public void setChequeRequestList(List<ChequeRequest> chequeRequestList) {
		this.chequeRequestList = chequeRequestList;
	}


	public List<LostCardReport> getLostCardReportList() {
		return lostCardReportList;
	}


	public void setLostCardReportList(List<LostCardReport> lostCardReportList) {
		this.lostCardReportList = lostCardReportList;
	}


	public List<Query> getQueryList() {
		return queryList;
	}


	public void setQueryList(List<Query> queryList) {
		this.queryList = queryList;
	}
	
}

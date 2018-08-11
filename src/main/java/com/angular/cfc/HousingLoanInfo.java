package com.angular.cfc;

public class HousingLoanInfo {

	private int interestDecreaseYear;
	private int year;
	private Double openingBalance;
	private Double emi;
	private Double interest;
	private Double principle;
	private Double closingBalance;
	private Double constantEmi;

	public Double getConstantEmi() {
		return constantEmi;
	}

	public void setConstantEmi(Double constantEmi) {
		this.constantEmi = constantEmi;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getPrinciple() {
		return principle;
	}

	public void setPrinciple(Double principle) {
		this.principle = principle;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInterestDecreaseYear() {
		return interestDecreaseYear;
	}

	public void setInterestDecreaseYear(int interestDecreaseYear) {
		this.interestDecreaseYear = interestDecreaseYear;
	}

	
	
}

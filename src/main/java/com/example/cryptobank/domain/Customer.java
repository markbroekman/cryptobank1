package com.example.cryptobank.domain;


import java.time.LocalDate;

public class Customer extends User{

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int socialSecurityNumber;
    private Address address;
    private BankAccount bankAccount;
    private Portfolio portfolio;


    public Customer(String username, String password, String salt,
                    String firstName, String lastName, LocalDate dateOfBirth, int socialSecurityNumber,
                    Address address) {
        super(username, password, salt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.portfolio = new Portfolio();
        this.bankAccount = new BankAccount();
    }

    public Customer(String username, String password) {
        super(username, password);
    }

    public Customer(){
        super();
    }


    // TODO: 20/08/2021 We moeten de usernames gaan vergelijken op username dus moeten we de comparable correct implementeren
    // de vraag die ik hier bij heb is of je dit steeds moet gaan willen vergelijken met de DB of dat je een lijst hebt met alle usernames en de
    // vergelijking uitvoert in java ipv de DB

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", address=" + address +
                ", bankAccount=" + bankAccount +
                ", portfolio=" + portfolio +
                '}';
    }
}

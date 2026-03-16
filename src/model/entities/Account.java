package model.entities;

import model.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
        super();
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
        if (balance <= 0.00) {
            throw new DomainException("The initial deposit cannot be less than or equal to zero.");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }
/* The account balance can only be changed using the deposit and withdrawal methods.
    public void setBalance(Double balance) {
        this.balance = balance;
    }
 */

    public void deposit(Double amount) throws DomainException{
        if (amount <= 0.00) {
            throw new DomainException("The deposit amount cannot be less than or equal to zero.");
        }
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainException{
        if (amount > withdrawLimit) {
        throw new DomainException("The amount exceeds withdraw limit.");
        }
        if (amount > balance) {
        throw new DomainException("Not enough balance.");
        }
        balance -= amount;
    }

    public String toString() {
        return "New balance: "
                + String.format("%.2f", balance);
    }
}

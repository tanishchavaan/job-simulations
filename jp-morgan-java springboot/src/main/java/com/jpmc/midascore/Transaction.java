package com.jpmc.midascore;  // THIS MUST MATCH the folder structure

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    private String id;
    private double amount;

    public Transaction() {}

    @JsonProperty("id")
    public String getId() { return id; }

    @JsonProperty("amount")
    public double getAmount() { return amount; }

    @JsonProperty("id")
    public void setId(String id) { this.id = id; }

    @JsonProperty("amount")
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + "}";
    }
}

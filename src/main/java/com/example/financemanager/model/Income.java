package com.example.financemanager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Income {
    private final LocalDate date;
    private final float total;
    private final float salary;
    private final float help;
    private final float company;
    private final float passive;
    private final float other;

    private final static String PRICE_FORMAT = "%.2f €";

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMMM yyyy");

    public Income(LocalDate date, float salary, float help, float company, float passive, float other) {
        this.date = date;
        this.total = salary + help + company + passive + other;
        this.salary = salary;
        this.help = help;
        this.company = company;
        this.passive = passive;
        this.other = other;
    }

    public StringProperty dateProperty() {
        return new SimpleStringProperty(date.format(DATE_FORMAT));
    }

    public StringProperty totalProperty() {
        return formatAmount(total);
    }

    private SimpleStringProperty formatAmount(float amount) {
        return new SimpleStringProperty(String.format(PRICE_FORMAT, amount));
    }

    public StringProperty salaryProperty() {
        return formatAmount(salary);
    }

    public StringProperty helpProperty() {
        return formatAmount(help);
    }

    public StringProperty companyProperty() {
        return formatAmount(company);
    }

    public StringProperty passiveProperty() {
        return formatAmount(passive);
    }

    public StringProperty otherProperty() {
        return formatAmount(other);
    }

    public LocalDate getDate() {
        return date;
    }

    public float getTotal() {
        return total;
    }

    public float getSalary() {
        return salary;
    }

    public float getHelp() {
        return help;
    }

    public float getCompany() {
        return company;
    }

    public float getPassive() {
        return passive;
    }

    public float getOther() {
        return other;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date=" + date +
                ", total=" + total +
                ", salary=" + salary +
                ", help=" + help +
                ", company=" + company +
                ", passive=" + passive +
                ", other=" + other +
                '}';
    }

    public int compareTo(Income income) {
        return -this.date.compareTo(income.date);
    }
}

package ru.mail.polis.homework.collections.mail;

public class Salary extends Sendable{
    private int value; // храним деньги в копейках

    public Salary(String to, String from, int value) {
        super(to, from);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

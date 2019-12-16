package ru.mail.polis.homework.collections.mail;

public class MailMessage extends Sendable {
    private String text;

    public MailMessage(String to, String from, String text) {
        super(to, from);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

package com.example.diploma.service;

public interface MailMessageSender {
    void send(String to, String from, String subject, String body);
}

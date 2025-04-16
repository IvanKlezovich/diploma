package com.example.diploma.security;

public interface MailMessageSender {

  void send(String to, String from, String subject, String body);
}

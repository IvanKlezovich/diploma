package com.example.diploma.security.impl;

import com.example.diploma.security.MailMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailMessageSenderImpl implements MailMessageSender {

  private final JavaMailSender javaMailSender;

  @Override
  public void send(String to, String from, String subject, String body) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(to);
    mailMessage.setFrom(from);
    mailMessage.setSubject(subject);
    mailMessage.setText(body);

    javaMailSender.send(mailMessage);
  }
}

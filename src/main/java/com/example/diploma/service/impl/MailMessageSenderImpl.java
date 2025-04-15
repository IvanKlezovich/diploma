package com.example.diploma.service.impl;

import com.example.diploma.service.MailMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
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

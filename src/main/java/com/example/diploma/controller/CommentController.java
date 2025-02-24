package com.example.diploma.controller;

import com.example.diploma.entity.Messages;
import com.example.diploma.service.CommentService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  @GetMapping("/all/{userId}")
  public List<Messages> getAllComments(@PathVariable UUID userId) {
    return commentService.getAllComments(userId);
  }

  @PostMapping("write/message")
  public Messages writeMessage(@RequestBody Messages message) {
    return commentService.addComment(message);
  }
}

package com.example.diploma.service.impl;

import com.example.diploma.entity.Messages;
import com.example.diploma.repository.CommentRepository;
import com.example.diploma.service.CommentService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;

  public List<Messages> getAllComments(UUID userId) {
    return commentRepository.findAllByUserId(userId);
  }

  public Messages addComment(Messages comment) {
    return commentRepository.save(comment);
  }
}

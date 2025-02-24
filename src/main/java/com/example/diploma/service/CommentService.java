package com.example.diploma.service;

import com.example.diploma.entity.Messages;
import java.util.List;
import java.util.UUID;

public interface CommentService {

  List<Messages> getAllComments(UUID userId);

  Messages addComment(Messages comment);
}

package com.example.diploma.entity.upload;

import lombok.Getter;
import org.springframework.util.MimeType;

@Getter
public enum FileType {
  CSV("csv", MimeType.valueOf("text/csv")),
  XLS("xls", MimeType.valueOf("application/vnd.ms-excel"));

  private final String type;

  private final MimeType mimeType;

  FileType(String type, MimeType mimeType) {
    this.type = type.toLowerCase();
    this.mimeType = mimeType;
  }
}

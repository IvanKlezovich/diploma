package com.example.diploma.service.upload.impl;

import com.example.diploma.entity.upload.FileType;
import com.example.diploma.service.upload.FileTypeDetectionService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileTypeDetectionServiceImpl implements FileTypeDetectionService {

  private static final String FILE_EXTENSION = "File type not specified. Please upload a file with a valid extension.";

  @Override
  public FileType detectFileType(MultipartFile file) {
    String contentType = FilenameUtils.getExtension(file.getOriginalFilename());
    if (!StringUtils.hasLength(contentType)) {
      throw new RuntimeException(FILE_EXTENSION);
    }
    return FileType.valueOf(contentType.toUpperCase());
  }
}

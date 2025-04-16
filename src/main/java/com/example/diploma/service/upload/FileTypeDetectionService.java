package com.example.diploma.service.upload;

import com.example.diploma.entity.upload.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface FileTypeDetectionService {

  FileType detectFileType(MultipartFile file);
}

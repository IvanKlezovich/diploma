package com.example.diploma.service.upload.strategy;

import com.example.diploma.dto.upload.TableImportDto;
import org.springframework.web.multipart.MultipartFile;

public interface ParseFileStrategy extends FileTypeProvider {

  TableImportDto parseFile(MultipartFile file);
}

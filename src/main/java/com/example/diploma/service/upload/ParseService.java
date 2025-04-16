package com.example.diploma.service.upload;

import com.example.diploma.dto.upload.TableImportDto;
import org.springframework.web.multipart.MultipartFile;

public interface ParseService {

  TableImportDto parse(MultipartFile file);
}

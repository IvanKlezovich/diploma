package com.example.diploma.service.upload;

import com.example.diploma.dto.UploadDataResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface DataService {

  UploadDataResponseDto uploadData(MultipartFile file);
}

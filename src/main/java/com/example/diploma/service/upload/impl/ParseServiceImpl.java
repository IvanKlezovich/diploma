package com.example.diploma.service.upload.impl;

import com.example.diploma.dto.upload.TableImportDto;
import com.example.diploma.entity.upload.FileType;
import com.example.diploma.service.upload.FileTypeDetectionService;
import com.example.diploma.service.upload.ParseService;
import com.example.diploma.service.upload.strategy.ParseFileStrategy;
import com.example.diploma.service.upload.strategy.file.FileStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ParseServiceImpl implements ParseService {

  private final FileStrategyFactory<ParseFileStrategy> fileParseTypeStrategyFactory;
  private final FileTypeDetectionService fileTypeDetector;

  @Override
  public TableImportDto parse(MultipartFile file) {
    FileType fileType = fileTypeDetector.detectFileType(file);
    ParseFileStrategy strategy = fileParseTypeStrategyFactory.getStrategy(fileType);

    TableImportDto tableImportDto = strategy.parseFile(file);

    return tableImportDto;
  }
}

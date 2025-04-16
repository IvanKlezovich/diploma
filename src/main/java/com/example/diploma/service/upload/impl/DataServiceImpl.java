//package com.example.diploma.service.upload.impl;
//
//import com.example.diploma.dto.UploadDataResponseDto;
//import com.example.diploma.dto.upload.TableImportDto;
//import com.example.diploma.service.upload.DataService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//@AllArgsConstructor
//public class DataServiceImpl implements DataService {
//
//  @Override
//  @Transactional
//  public UploadDataResponseDto uploadData(MultipartFile file) {
//    TableImportDto tableImportDto = parseService.parse(file);
//
//    if (queryService.isQueryExist(tableImportDto.ddl())) {
//      databaseService.cascadeDropSchemas(tableImportDto.tables());
//      databaseService.executeQueries(tableImportDto.ddl());
//    } else {
//      validateDataService.validate(tableImportDto.tables());
//      databaseService.clearTables(tableImportDto.tables());
//    }
//
//    databaseService.uploadData(tableImportDto.tables());
//
//    return UploadDataResponseDto
//        .builder()
//        .message("Success. Upload data from" + file.getOriginalFilename())
//        .build();
//  }
//}

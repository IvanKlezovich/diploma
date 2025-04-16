//package com.example.diploma.service.upload.strategy.file.parse.impl;
//
//import com.example.diploma.dto.upload.TableImportDto;
//import com.example.diploma.dto.upload.parse.TableDefinition;
//import com.example.diploma.service.upload.strategy.ParseFileStrategy;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.util.Pair;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//@AllArgsConstructor
//public class XlsParseFileStrategy implements ParseFileStrategy {
//
//  private static final int FIELD_ROW_INDEX = 0;
//  private static final String SHEET_NOT_FOUNT = "Sheet '%s' not found";
//
//  private final XlsProperties xlsProperties;
//  private final TableNameGenerator tableNameGenerator;
//
//  @Value("${app.null-replacement}")
//  private String nullReplacement;
//
//  @Override
//  public TableImportDto parseFile(MultipartFile file) {
//    List<TableDefinition> tableDefinitionList = new ArrayList<>();
//    List<String> queries;
//    try (HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream())) {
//
//      List<Pair<SchemaTable, String>> pairs = parseSheetMetadata(workbook);
//      for (Pair<SchemaTable, String> pair : pairs) {
//        HSSFSheet sheet = getSheet(workbook, pair.getSecond());
//        tableDefinitionList.add(parseToTableDto(sheet, pair.getFirst()));
//      }
//
//      queries = parseSheetDdl(workbook);
//    } catch (IOException e) {
//      throw new ParseFileException(e.getMessage());
//    }
//    return new TableImportDto(tableDefinitionList, new QueryDto(queries));
//  }
//
//  @Override
//  public FileType getType() {
//    return FileType.XLS;
//  }
//
//  private List<Pair<SchemaTable, String>> parseSheetMetadata(HSSFWorkbook workbook) {
//    HSSFSheet metadataSheet = getSheet(workbook, xlsProperties.tableReference());
//
//    List<Pair<SchemaTable, String>> pairList = new ArrayList<>();
//
//    for (Row row : metadataSheet) {
//      String table = row.getCell(TABLE_NAME_CELL_INDEX).getStringCellValue();
//      String sheetName = row.getCell(SHEET_NAME_CELL_INDEX).getStringCellValue();
//      Pair<SchemaTable, String> pair = Pair.of(stringToSchemaTable(table), sheetName);
//      pairList.add(pair);
//    }
//
//    return pairList;
//  }
//
//  private List<String> parseSheetDdl(HSSFWorkbook workbook) {
//    HSSFSheet sheet = workbook.getSheet(xlsProperties.ddl());
//
//    if (Objects.isNull(sheet)) {
//      return Collections.emptyList();
//    }
//
//    List<String> result = new ArrayList<>();
//
//    for (Row row : sheet) {
//      result.add(row.getCell(DDL_CELL_INDEX).getStringCellValue());
//    }
//
//    return result;
//  }
//
//  private TableDefinition parseToTableDto(HSSFSheet sheet, SchemaTable schemaTable) {
//    TableDefinition tableDefinition = new TableDefinition();
//    tableDefinition.setTableName(schemaTable.table());
//    tableDefinition.setSchemaName(schemaTable.schema());
//
//    for (Row row : sheet) {
//      if (row.getRowNum() == FIELD_ROW_INDEX) {
//        tableDefinition.setFields(parseFields(row));
//      } else {
//        parseData(row, tableDefinition);
//      }
//    }
//
//    return tableDefinition;
//  }
//
//  private List<String> parseFields(Row row) {
//    List<String> fieldsList = new ArrayList<>();
//
//    for (Cell cell : row) {
//      fieldsList.add(cell.getStringCellValue());
//    }
//
//    return fieldsList;
//  }
//
//  private void parseData(Row rowData, TableDefinition tableDefinition) {
//    List<String> dataRowList = new ArrayList<>();
//
//    for (Cell cell : rowData) {
//      String data = cell.getStringCellValue();
//      if (Objects.equals(data, nullReplacement)) {
//        dataRowList.add(null);
//      } else {
//        dataRowList.add(data);
//      }
//    }
//
//    tableDefinition.getData().add(dataRowList);
//  }
//
//  private HSSFSheet getSheet(HSSFWorkbook workbook, String sheetName) {
//    HSSFSheet sheet = workbook.getSheet(sheetName);
//    if (Objects.isNull(sheet)) {
//      throw new ParseFileException(String.format(SHEET_NOT_FOUNT, sheetName));
//    }
//    return sheet;
//  }
//
//  private SchemaTable stringToSchemaTable(String value) {
//    return tableNameGenerator.parse(value);
//  }
//}

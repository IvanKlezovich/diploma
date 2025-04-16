package com.example.diploma.dto.upload;

import com.example.diploma.dto.upload.parse.QueryDto;
import com.example.diploma.dto.upload.parse.TableDefinition;
import java.util.List;

public record TableImportDto(List<TableDefinition> tables, QueryDto ddl) {

}

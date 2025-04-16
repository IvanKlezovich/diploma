package com.example.diploma.dto.upload.parse;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableDefinition {

  private List<String> fields;
  private List<List<String>> data;

  public TableDefinition() {
    this.data = new ArrayList<>();
  }
}

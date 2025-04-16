package com.example.diploma.service.upload.strategy.file;

import com.example.diploma.entity.upload.FileType;
import com.example.diploma.service.upload.strategy.FileTypeProvider;
import java.util.List;

public interface FileStrategyFactory<R extends FileTypeProvider> {

  String STRATEGY_NOT_FOUND = "Strategy not found";

  R getStrategy(FileType file);

  default R getStrategy(List<R> strategies, FileType file) {
    return strategies.stream()
        .filter(strategy -> strategy.getType().equals(file))
        .findAny()
        .orElseThrow(() -> new RuntimeException(STRATEGY_NOT_FOUND));
  }
}

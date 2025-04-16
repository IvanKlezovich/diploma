package com.example.diploma.service.upload.strategy.file.parse;

import com.example.diploma.entity.upload.FileType;
import com.example.diploma.service.upload.strategy.ParseFileStrategy;
import com.example.diploma.service.upload.strategy.file.FileStrategyFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileParseStrategyFactory implements FileStrategyFactory<ParseFileStrategy> {

  private final List<ParseFileStrategy> strategyList;

  @Override
  public ParseFileStrategy getStrategy(FileType file) {
    return getStrategy(strategyList, file);
  }
}

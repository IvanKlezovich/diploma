package com.example.diploma.dto.scheduler;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulesDto {

  private MiniFormDto form;

  private List<StudyDay> studyDays;

}
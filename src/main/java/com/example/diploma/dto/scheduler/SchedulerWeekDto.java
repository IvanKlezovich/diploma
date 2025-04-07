package com.example.diploma.dto.scheduler;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SchedulerWeekDto {

  private List<MiniFormDto> formList;

  private List<SchedulesDto> form;
}
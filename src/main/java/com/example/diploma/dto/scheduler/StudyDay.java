package com.example.diploma.dto.scheduler;

import com.example.diploma.entity.Day;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyDay {

  private List<StudyLesson> lesson;

  private Day dayOfWeek;
}


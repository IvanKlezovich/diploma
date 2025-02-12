//package com.example.diploma.controller;
//
//import com.example.diploma.controller.documentation.DairyDocumentation;
//import com.example.diploma.dto.DayOfWeekDto;
//import com.example.diploma.service.DairyService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class DairyController implements DairyDocumentation {
//
//    private final DairyService dairyService;
//
//    @GetMapping("/current/{day}")
//    public ResponseEntity<DayOfWeekDto> getSchemaLesson(@PathVariable String day){
//        return ResponseEntity.ok(dairyService.getDayOfWeekByName(day));
//    }
//
//    @GetMapping("/current/week")
//    public ResponseEntity<List<DayOfWeekDto>> getWeekLessons(){
//        return null;
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<DayOfWeekDto> addSchemaLesson(@RequestBody DayOfWeekDto day){
//        return ResponseEntity.ok(dairyService.saveDayOfWeek(day));
//    }
//}

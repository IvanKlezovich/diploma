package com.example.diploma.controller.documentation;

import com.example.diploma.dto.DayOfWeekDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface DairyDocumentation {

  @Operation(summary = "Update a skill content by content id",
      description = "Access: skill_management, skm")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200", description = "update", content = {
          @Content(mediaType = "application/json",
              schema = @Schema(implementation = DayOfWeekDto.class))
      }),
      @ApiResponse(
          responseCode = "400",
          description = "exception.incorrectData",
          content = @Content
      ),
      @ApiResponse(
          responseCode = "401", description = "exception.notAuth", content = @Content
      ),
      @ApiResponse(
          responseCode = "403", description = "exception.noPermissions", content = @Content
      ),
      @ApiResponse(
          responseCode = "404", description = "exception.contentNotFound", content = @Content
      ),
  })
  ResponseEntity<DayOfWeekDto> getSchemaLesson(@PathVariable String day);
}

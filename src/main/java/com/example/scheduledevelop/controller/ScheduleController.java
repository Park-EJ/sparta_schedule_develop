package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

}

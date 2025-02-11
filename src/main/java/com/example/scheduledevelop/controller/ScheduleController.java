package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // Schedule 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // Schedule 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // Schedule 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // Schedule 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateByUsername(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateByUsername(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // Schedule 삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);
    }

//    @PostMapping
//    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto) {
//        ScheduleResponseDto scheduleResponseDto =
//                scheduleService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());
//
//        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
//    }

}

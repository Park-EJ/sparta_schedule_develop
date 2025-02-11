package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto save(String username, String title, String contents) {
        Schedule schedule = new Schedule(username, title, contents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getUsername(), savedSchedule.getTitle(), savedSchedule.getContents());

    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getContents()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
            Schedule findSchedule = scheduleRepository.findById(id).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id));

            return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getContents());
    }

    @Transactional
    public ScheduleResponseDto updateById(Long id, String username, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id));

        findSchedule.updateById(username, title, contents);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getContents());
    }

    @Transactional
    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        scheduleRepository.deleteById(id);
    }

//    public ScheduleResponseDto save(String title, String contents, String username) {
//        User findUser = userRepository.findUsersByUsernameOrElseThrow(username);
//
//        Schedule schedule = new Schedule(title, contents);
//        schedule.setUser(findUser);
//
//        Schedule savedSchedule = scheduleRepository.save(schedule);
//
//        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
//    }
}

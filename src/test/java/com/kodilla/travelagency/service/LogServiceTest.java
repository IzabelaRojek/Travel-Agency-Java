package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Log;
import com.kodilla.travelagency.repository.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceTest {
    @Autowired
    private LogService logService;

    @Autowired
    private LogRepository logRepository;

    @Test
    public void shouldGetAllLogs() {
        //Given
        long numberOfLogsInDb = logRepository.count();

        ///When
        List<Log> logs = logService.getAllLogs();

        //Then
        assertEquals(numberOfLogsInDb, logs.size());
    }

    @Test
    public void shouldSaveLog() {
        //Given
        Log log = new Log(1L, "testOperation");

        //When
        Log savedLog = logService.saveLog(log);
        Optional<Log> readLog = logRepository.findById(savedLog.getId());

        //Then
        List<Log> logs = logService.getAllLogs();
        assertEquals(logRepository.count(), logs.size());
        assertTrue(readLog.isPresent());

        //CleanUp
        logRepository.deleteById(savedLog.getId());
    }



}
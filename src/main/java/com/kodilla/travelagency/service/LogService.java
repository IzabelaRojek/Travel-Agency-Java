package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Log;
import com.kodilla.travelagency.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public Log saveLog(Log log) {
        return logRepository.save(log);
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }
}

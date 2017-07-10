package com.zipc.epm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.entity.AlertWordCount;
import com.zipc.epm.repository.AlertWordCountRepository;

@Service("alertWordCountService")
public class AlertWordCountServiceImpl implements AlertWordCountService {

    @Autowired
    private AlertWordCountRepository alertWordCountRepo;

    public void setAlertWordCountRepo(AlertWordCountRepository alertWordCountRepo) {
        this.alertWordCountRepo = alertWordCountRepo;
    }

    @Override
    @Transactional
    public List<AlertWordCount> findAll() {
        return alertWordCountRepo.findAll();
    }

}

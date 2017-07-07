package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordCount;

public interface AlertWordCountRepository {

    List<AlertWordCount> findAll();

    void delete(AlertWordCount alertWordCount);

}

package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.AlertWordCount;

public interface AlertWordCountRepository {

    List<AlertWordCount> findAll();

    void delete(AlertWordCount alertWordCount);

}

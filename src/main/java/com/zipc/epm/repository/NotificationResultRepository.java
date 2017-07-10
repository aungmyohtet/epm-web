package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.NotificationResult;

public interface NotificationResultRepository {

    void save(NotificationResult notificationResult);

    List<NotificationResult> findAll();

    NotificationResult findById(int id);

    void delete(NotificationResult notiResult);
}

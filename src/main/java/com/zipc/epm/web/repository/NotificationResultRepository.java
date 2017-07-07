package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.NotificationResult;

public interface NotificationResultRepository {

    void save(NotificationResult notificationResult);

    List<NotificationResult> findAll();

    NotificationResult findById(int id);

    void delete(NotificationResult notiResult);
}

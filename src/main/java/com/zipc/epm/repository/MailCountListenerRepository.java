package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.MailCountListener;

public interface MailCountListenerRepository {

    void save(MailCountListener mailCountListener);

    List<MailCountListener> findAll();

    MailCountListener findById(int id);

    void delete(int id);

    void delete(MailCountListener listener);
}

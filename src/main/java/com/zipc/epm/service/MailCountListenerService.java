package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.MailCountListener;

public interface MailCountListenerService {

    void add(MailCountListener mailCountListener);

    public List<MailCountListener> findAll();

    public void delete(int id);
}

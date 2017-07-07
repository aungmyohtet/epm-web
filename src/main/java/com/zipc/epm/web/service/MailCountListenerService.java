package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.MailCountListener;

public interface MailCountListenerService {

    void add(MailCountListener mailCountListener);

    public List<MailCountListener> findAll();

    public void delete(int id);
}

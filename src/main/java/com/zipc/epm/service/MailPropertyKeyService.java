package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.MailPropertyKey;

public interface MailPropertyKeyService {

    void add(MailPropertyKey mailPropertyKey);

    public List<MailPropertyKey> findAll();

    MailPropertyKey findById(int id);

    void update(MailPropertyKey mailPropertyKey);

    void delete(int id);
}

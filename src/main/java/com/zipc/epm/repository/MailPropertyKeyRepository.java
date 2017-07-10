package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.MailPropertyKey;
import com.zipc.epm.entity.MailPropertySetting;

public interface MailPropertyKeyRepository {

    void save(MailPropertyKey mailPropertyKey);

    List<MailPropertyKey> findAll();

    MailPropertyKey findById(int id);

    MailPropertyKey findByName(String name);

    void update(MailPropertyKey mailPropertyKey);

    void delete(int id);
}

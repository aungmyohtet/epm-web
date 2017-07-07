package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.MailPropertyKey;
import com.zipc.epm.web.entity.MailPropertySetting;

public interface MailPropertyKeyRepository {

    void save(MailPropertyKey mailPropertyKey);

    List<MailPropertyKey> findAll();

    MailPropertyKey findById(int id);

    MailPropertyKey findByName(String name);

    void update(MailPropertyKey mailPropertyKey);

    void delete(int id);
}

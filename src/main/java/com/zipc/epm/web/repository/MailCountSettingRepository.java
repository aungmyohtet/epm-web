package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.MailCountSetting;

public interface MailCountSettingRepository {

    void save(MailCountSetting mailCountSetting);

    List<MailCountSetting> findAll();

    MailCountSetting findById(int id);

    MailCountSetting findByName(String name);

    void update(MailCountSetting mailCountSetting);

    void delete(MailCountSetting mailCountSetting);
}

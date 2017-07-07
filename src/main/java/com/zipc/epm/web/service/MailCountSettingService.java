package com.zipc.epm.web.service;

import java.util.ArrayList;
import java.util.List;

import com.zipc.epm.web.entity.MailCountSetting;

public interface MailCountSettingService {

    void save(MailCountSetting mailCountSetting);

    List<MailCountSetting> findAll();

    MailCountSetting findById(int id);

    MailCountSetting findByName(String name);

    void delete(int id);

    void update(MailCountSetting mailCountSetting);

    ArrayList<String> getMailCountSettingNames();
}

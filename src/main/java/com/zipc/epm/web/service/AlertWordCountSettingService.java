package com.zipc.epm.web.service;

import java.util.ArrayList;
import java.util.List;

import com.zipc.epm.web.entity.AlertWordCountSetting;

public interface AlertWordCountSettingService {

    void add(AlertWordCountSetting alertWordCountSetting);

    List<AlertWordCountSetting> findAll();

    AlertWordCountSetting findById(int id);

    AlertWordCountSetting findByName(String name);

    void remove(int id);

    void update(AlertWordCountSetting alertWordCountSetting);

    ArrayList<String> getAlertWordCountSettingNames();
}

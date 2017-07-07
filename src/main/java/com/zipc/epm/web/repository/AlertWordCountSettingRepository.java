package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordCountSetting;

public interface AlertWordCountSettingRepository {

    void add(AlertWordCountSetting alertWordCountSetting);

    List<AlertWordCountSetting> findAll();

    AlertWordCountSetting findById(int id);

    AlertWordCountSetting findByName(String name);

    void delete(AlertWordCountSetting alertWordCountSetting);

    void update(AlertWordCountSetting alertWordCountSetting);
}

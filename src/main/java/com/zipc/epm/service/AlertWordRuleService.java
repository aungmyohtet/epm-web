package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.AlertWordRule;
import com.zipc.epm.entity.Project;

public interface AlertWordRuleService {

    void add(AlertWordRule alertWorldRule);

    List<AlertWordRule> findAll();

    AlertWordRule findById(int id);

    AlertWordRule findByProject(Project project);

    Integer getThresholdByProject(Project project);

    void add(int projectId, int threshold);

    void delete(int id);

    void update(AlertWordRule alertWordRule);
}

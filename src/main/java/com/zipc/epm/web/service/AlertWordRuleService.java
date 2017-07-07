package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordRule;
import com.zipc.epm.web.entity.Project;

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

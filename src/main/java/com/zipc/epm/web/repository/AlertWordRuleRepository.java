package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.AlertWordRule;
import com.zipc.epm.web.entity.Project;

public interface AlertWordRuleRepository {

    void save(AlertWordRule alertWorldRule);

    List<AlertWordRule> findAll();

    AlertWordRule findById(int id);

    AlertWordRule findByProject(Project project);

    Integer getThresholdByProject(Project project);

    void update(AlertWordRule alertWorldRule);

    void delete(AlertWordRule alertWorldRule);
}

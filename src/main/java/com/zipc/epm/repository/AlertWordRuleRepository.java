package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.AlertWordRule;
import com.zipc.epm.entity.Project;

public interface AlertWordRuleRepository {

    void save(AlertWordRule alertWorldRule);

    List<AlertWordRule> findAll();

    AlertWordRule findById(int id);

    AlertWordRule findByProject(Project project);

    Integer getThresholdByProject(Project project);

    void update(AlertWordRule alertWorldRule);

    void delete(AlertWordRule alertWorldRule);
}

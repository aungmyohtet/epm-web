package com.zipc.epm.web.repository;

import java.util.List;

import com.zipc.epm.web.entity.MailCountRule;
import com.zipc.epm.web.entity.Project;

public interface MailCountRuleRepository {

    void add(MailCountRule mailCountRule);

    List<MailCountRule> findAll();

    MailCountRule findById(int id);

    MailCountRule findByProject(Project project);

    void update(MailCountRule mailCountRule);

    Integer getThresholdByProject(Project project);

    void delete(MailCountRule mailCountRule);
}

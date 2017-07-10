package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.MailCountRule;
import com.zipc.epm.entity.Project;

public interface MailCountRuleService {

    void add(MailCountRule mailCountRule);

    public List<MailCountRule> findAll();

    MailCountRule findById(int id);

    void update(MailCountRule mailCountRule);

    void delete(int id);

    void add(int projectId, int threshold);

    MailCountRule findByProject(Project project);

}

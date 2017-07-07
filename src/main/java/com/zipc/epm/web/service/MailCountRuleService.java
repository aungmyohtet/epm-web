package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.MailCountRule;
import com.zipc.epm.web.entity.Project;

public interface MailCountRuleService {

    void add(MailCountRule mailCountRule);

    public List<MailCountRule> findAll();

    MailCountRule findById(int id);

    void update(MailCountRule mailCountRule);

    void delete(int id);

    void add(int projectId, int threshold);

    MailCountRule findByProject(Project project);

}

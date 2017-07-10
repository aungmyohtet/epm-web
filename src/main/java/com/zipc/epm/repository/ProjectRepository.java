package com.zipc.epm.repository;

import java.util.List;

import com.zipc.epm.entity.MailAddress;
import com.zipc.epm.entity.Project;

public interface ProjectRepository {

    void save(Project project);

    List<Project> findAll();

    Project findById(int id);

    Project findByName(String name);

    void update(Project project);

    void delete(Project project);

    Project isExistsMailAddress(MailAddress mailAddress, Project project);
}

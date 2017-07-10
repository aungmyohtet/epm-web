package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.MailAddress;
import com.zipc.epm.entity.Project;

public interface ProjectService {

    void save(Project project);

    List<Project> findAll();

    Project findById(int id);

    Project findByName(String name);

    void update(Project project);

    void delete(int id);

    void addMailAddressToProject(int mId, int pId);

    boolean IsExistsMailAddress(MailAddress mailAddress, Project project);

    List<MailAddress> findMailAddressesByID(int projectId);

    void deleteMailAddress(int pid, int mid);
}

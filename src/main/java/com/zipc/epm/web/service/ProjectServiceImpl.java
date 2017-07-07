package com.zipc.epm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.AlertWordRule;
import com.zipc.epm.web.entity.MailAddress;
import com.zipc.epm.web.entity.MailCount;
import com.zipc.epm.web.entity.MailCountRule;
import com.zipc.epm.web.entity.NotificationResult;
import com.zipc.epm.web.entity.Project;
import com.zipc.epm.web.repository.AlertWordRuleRepository;
import com.zipc.epm.web.repository.MailAddressRepository;
import com.zipc.epm.web.repository.MailCountRepository;
import com.zipc.epm.web.repository.MailCountRuleRepository;
import com.zipc.epm.web.repository.NotificationResultRepository;
import com.zipc.epm.web.repository.ProjectRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MailAddressRepository mailAddressRepo;

    @Autowired
    private AlertWordRuleRepository alertWordRuleRepo;

    @Autowired
    private MailCountRuleRepository mailCountRuleRepo;

    @Autowired
    private MailCountRepository mailCountRepo;

    @Autowired
    private NotificationResultRepository notiResultRepo;

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void setMailAddressRepo(MailAddressRepository mailAddressRepo) {
        this.mailAddressRepo = mailAddressRepo;
    }

    public void setAlertWordRuleRepo(AlertWordRuleRepository alertWordRuleRepo) {
        this.alertWordRuleRepo = alertWordRuleRepo;
    }

    public void setMailCountRuleRepo(MailCountRuleRepository mailCountRuleRepo) {
        this.mailCountRuleRepo = mailCountRuleRepo;
    }

    public void setMailCountRepo(MailCountRepository mailCountRepo) {
        this.mailCountRepo = mailCountRepo;
    }

    public void setNotiResultRepo(NotificationResultRepository notiResultRepo) {
        this.notiResultRepo = notiResultRepo;
    }

    @Override
    @Transactional
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public Project findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    @Transactional
    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    @Transactional
    public void update(Project project) {
        projectRepository.update(project);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Project proj = projectRepository.findById(id);
        for (MailAddress address : mailAddressRepo.findAll()) {
            address.getProjects().remove(proj);
        }
        for (AlertWordRule alertRule : alertWordRuleRepo.findAll()) {
            if (alertRule.getProject().equals(proj)) {
                alertWordRuleRepo.delete(alertRule);
            }
        }
        for (MailCountRule mailCountRule : mailCountRuleRepo.findAll()) {
            if (mailCountRule.getProject().equals(proj)) {
                mailCountRuleRepo.delete(mailCountRule);
            }
        }
        for (MailCount count : mailCountRepo.findAll()) {
            if (count.getProject().equals(proj)) {
                mailCountRepo.delete(count);
            }
        }
        for (NotificationResult noti : notiResultRepo.findAll()) {
            if (noti.getProject().equals(proj)) {
                notiResultRepo.delete(noti);
            }
        }
        projectRepository.delete(projectRepository.findById(id));
    }

    @Override
    @Transactional
    public void addMailAddressToProject(int mId, int pId) {
        MailAddress mailAddress = mailAddressRepo.findById(mId);
        Project project = projectRepository.findById(pId);
        if (mailAddress != null && project != null) {
            project.getMailAddresses().add(mailAddress);
            projectRepository.save(project);
        }
    }

    @Override
    @Transactional
    public boolean IsExistsMailAddress(MailAddress mailAddress, Project project) {
        if (projectRepository.isExistsMailAddress(mailAddress, project) != null) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<MailAddress> findMailAddressesByID(int projectId) {
        Project proj = projectRepository.findById(projectId);
        return proj.getMailAddresses();
    }

    @Override
    @Transactional
    public void deleteMailAddress(int pid, int mid) {
        Project proj = projectRepository.findById(pid);
        for (int i = 0; i < proj.getMailAddresses().size(); i++) {
            if (proj.getMailAddresses().get(i).getId().equals(mid)) {
                proj.getMailAddresses().remove(i);
            }
        }
    }

}

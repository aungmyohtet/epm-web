package com.zipc.epm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.entity.AlertWordCount;
import com.zipc.epm.entity.AlertWordCountListener;
import com.zipc.epm.entity.Mail;
import com.zipc.epm.entity.MailAddress;
import com.zipc.epm.entity.MailCountListener;
import com.zipc.epm.entity.MailPropertySetting;
import com.zipc.epm.entity.MailRawDataPath;
import com.zipc.epm.entity.Project;
import com.zipc.epm.repository.AlertWordCountListenerRepository;
import com.zipc.epm.repository.AlertWordCountRepository;
import com.zipc.epm.repository.MailAddressRepository;
import com.zipc.epm.repository.MailCountListenerRepository;
import com.zipc.epm.repository.MailPropertySettingRepository;
import com.zipc.epm.repository.MailRawDataPathRepository;
import com.zipc.epm.repository.MailRepository;
import com.zipc.epm.repository.ProjectRepository;

@Service("mailAddressService")
public class MailAddressServiceImpl implements MailAddressService {

    @Autowired
    private MailAddressRepository mailAddressRepo;

    @Autowired
    private ProjectRepository projRepo;

    @Autowired
    private MailRepository mailRepo;

    @Autowired
    private AlertWordCountRepository alertWordCountRepo;

    @Autowired
    private MailRawDataPathRepository mailPathRepo;

    @Autowired
    private MailPropertySettingRepository mailSettingRepo;

    @Autowired
    private MailCountListenerRepository mailCountListnerRepo;

    @Autowired
    private AlertWordCountListenerRepository alertlistenerRepo;

    public void setMailAddressRepo(MailAddressRepository mailAddressRepo) {
        this.mailAddressRepo = mailAddressRepo;
    }

    public void setProjRepo(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }

    public void setMailRepo(MailRepository mailRepo) {
        this.mailRepo = mailRepo;
    }

    public void setAlertWordCountRepo(AlertWordCountRepository alertWordCountRepo) {
        this.alertWordCountRepo = alertWordCountRepo;
    }

    public void setMailPathRepo(MailRawDataPathRepository mailPathRepo) {
        this.mailPathRepo = mailPathRepo;
    }

    public void setMailSettingRepo(MailPropertySettingRepository mailSettingRepo) {
        this.mailSettingRepo = mailSettingRepo;
    }

    public void setMailCountListnerRepo(MailCountListenerRepository mailCountListnerRepo) {
        this.mailCountListnerRepo = mailCountListnerRepo;
    }

    public void setAlertlistenerrepo(AlertWordCountListenerRepository alertlistenerRepo) {
        this.alertlistenerRepo = alertlistenerRepo;
    }

    @Override
    @Transactional
    public void save(MailAddress mailAddress) {
        mailAddressRepo.save(mailAddress);
    }

    @Override
    @Transactional
    public List<MailAddress> findAll() {
        return mailAddressRepo.findAll();
    }

    @Override
    @Transactional
    public MailAddress findById(int id) {
        return mailAddressRepo.findById(id);
    }

    @Override
    @Transactional
    public MailAddress findByAddress(String address) {
        return mailAddressRepo.findByAddress(address);
    }

    @Override
    @Transactional
    public MailAddress findByName(String name) {
        return mailAddressRepo.findByName(name);
    }

    @Override
    @Transactional
    public void update(MailAddress mailAddress) {
        mailAddressRepo.update(mailAddress);
    }

    @Override
    @Transactional
    public void delete(int id) {
        MailAddress mailAddress = mailAddressRepo.findById(id);
        for (Project proj : projRepo.findAll()) {
            proj.getMailAddresses().remove(mailAddress);
        }
        for (Mail mail : mailRepo.findAll()) {
            for (AlertWordCount alert : alertWordCountRepo.findAll()) {
                if (alert.getMail().equals(mail)) {
                    alertWordCountRepo.delete(alert);
                }
            }
            for (MailRawDataPath path : mailPathRepo.findAll()) {
                if (path.getMail().equals(mail)) {
                    mailPathRepo.delete(path);
                }
            }
            if (mail.getMailAddress().equals(mailAddress)) {
                mailRepo.delete(mail);
            }
        }
        for (MailPropertySetting sett : mailSettingRepo.findAll()) {
            if (sett.getMailAddress().getAddress().equals(mailAddress.getAddress())) {
                mailSettingRepo.delete(sett);
            }
        }
        for (MailCountListener listener : mailCountListnerRepo.findAll()) {
            if (listener.getMailAddress().equals(mailAddress)) {
                mailCountListnerRepo.delete(listener);
            }
        }
        for (AlertWordCountListener listener : alertlistenerRepo.findAll()) {
            if (listener.getMailAddress().equals(mailAddress)) {
                alertlistenerRepo.delete(listener);
            }
        }
        mailAddressRepo.delete(mailAddressRepo.findById(id));
    }
}

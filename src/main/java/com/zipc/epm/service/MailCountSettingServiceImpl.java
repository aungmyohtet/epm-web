package com.zipc.epm.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.entity.MailCountSetting;
import com.zipc.epm.repository.MailCountSettingRepository;

@Service("mailCountSettingService")
public class MailCountSettingServiceImpl implements MailCountSettingService {

    @Autowired
    private MailCountSettingRepository mailCountSettingRepo;

    public void setMailCountSettingRepo(MailCountSettingRepository mailCountSettingRepo) {
        this.mailCountSettingRepo = mailCountSettingRepo;
    }

    @Override
    @Transactional
    public void save(MailCountSetting mailCountSetting) {
        mailCountSettingRepo.save(mailCountSetting);
    }

    @Override
    @Transactional
    public List<MailCountSetting> findAll() {
        return mailCountSettingRepo.findAll();
    }

    @Override
    @Transactional
    public MailCountSetting findById(int id) {
        return mailCountSettingRepo.findById(id);
    }

    @Override
    @Transactional
    public MailCountSetting findByName(String name) {
        return mailCountSettingRepo.findByName(name);
    }

    @Override
    @Transactional
    public void delete(int id) {
        mailCountSettingRepo.delete(mailCountSettingRepo.findById(id));
    }

    @Override
    @Transactional
    public void update(MailCountSetting mailCountSetting) {
        mailCountSettingRepo.update(mailCountSetting);
    }

    @Override
    @Transactional
    public ArrayList<String> getMailCountSettingNames() {
        String[] mailCountSettingNames = { "notification_title", "notification_content", "sender_mail", "last_analyzed_date" };
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < mailCountSettingNames.length; i++) {
            String name = mailCountSettingNames[i];
            if (this.findByName(name) == null) {
                names.add(name);
            }
        }
        return names;
    }
}

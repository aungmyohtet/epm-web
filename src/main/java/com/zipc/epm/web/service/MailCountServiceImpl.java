package com.zipc.epm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.MailCount;
import com.zipc.epm.web.repository.MailCountRepository;

@Service("mailCountService")
public class MailCountServiceImpl implements MailCountService {

    @Autowired
    private MailCountRepository mailCountRepo;

    public void setMailCountRepo(MailCountRepository mailCountRepo) {
        this.mailCountRepo = mailCountRepo;
    }

    @Override
    @Transactional
    public List<MailCount> findAll() {
        return mailCountRepo.findAll();
    }

}

package com.zipc.epm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.entity.MailCount;
import com.zipc.epm.repository.MailCountRepository;

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

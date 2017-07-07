package com.zipc.epm.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.MailCountListener;
import com.zipc.epm.web.repository.MailCountListenerRepository;

@Service("mailCountListenerService")
public class MailCountListenerServiceImpl implements MailCountListenerService {

    @Autowired
    private MailCountListenerRepository mailCountListenerRepository;

    public void setMailCountListenerRepository(MailCountListenerRepository mailCountListenerRepository) {
        this.mailCountListenerRepository = mailCountListenerRepository;
    }

    @Override
    @Transactional
    public void add(MailCountListener mailCountListener) {
        mailCountListenerRepository.save(mailCountListener);
    }

    @Override
    @Transactional
    public List<MailCountListener> findAll() {
        return mailCountListenerRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(int id) {
        mailCountListenerRepository.delete(id);
    }
}

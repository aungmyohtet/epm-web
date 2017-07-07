package com.zipc.epm.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.MailPropertyKey;
import com.zipc.epm.web.repository.MailPropertyKeyRepository;

@Service("mailPropertyKeyService")
public class MailPropertyKeyServiceImpl implements MailPropertyKeyService {

    @Autowired
    private MailPropertyKeyRepository mailPropertyKeyRepository;

    public void setMailPropertyKeyRepository(MailPropertyKeyRepository mailPropertyKeyRepository) {
        this.mailPropertyKeyRepository = mailPropertyKeyRepository;
    }

    @Override
    @Transactional
    public void add(MailPropertyKey mailPropertyKey) {
        mailPropertyKeyRepository.save(mailPropertyKey);
    }

    @Override
    @Transactional
    public List<MailPropertyKey> findAll() {
        return mailPropertyKeyRepository.findAll();
    }

    @Override
    @Transactional
    public MailPropertyKey findById(int id) {

        return mailPropertyKeyRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(MailPropertyKey mailPropertyKey) {
        mailPropertyKeyRepository.update(mailPropertyKey);
    }

    @Override
    @Transactional
    public void delete(int id) {
        mailPropertyKeyRepository.delete(id);
    }

}

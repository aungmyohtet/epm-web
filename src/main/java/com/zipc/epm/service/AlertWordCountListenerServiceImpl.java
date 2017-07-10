package com.zipc.epm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.entity.AlertWordCountListener;
import com.zipc.epm.entity.MailAddress;
import com.zipc.epm.repository.AlertWordCountListenerRepository;
import com.zipc.epm.repository.MailAddressRepository;

@Service("alertWordCountListenerService")
public class AlertWordCountListenerServiceImpl implements AlertWordCountListenerService{

    @Autowired
    private AlertWordCountListenerRepository alertWordCountListenerRepository;

    @Autowired
    private MailAddressRepository mailAddressRepository;

    public void setAlertWordCountListenerRepository(AlertWordCountListenerRepository alertWordCountListenerRepository) {
        this.alertWordCountListenerRepository = alertWordCountListenerRepository;
    }

    public void setMailAddressRepository(MailAddressRepository mailAddressRepository) {
        this.mailAddressRepository = mailAddressRepository;
    }


    @Override
    @Transactional
    public void add(AlertWordCountListener alertWordCountListener) {
        alertWordCountListenerRepository.add(alertWordCountListener);
    }

    @Override
    @Transactional
    public List<AlertWordCountListener> findAll() {
        return alertWordCountListenerRepository.findAll();
    }

    @Override
    @Transactional
    public AlertWordCountListener findById(int id) {
        return alertWordCountListenerRepository.findById(id);
    }

    @Override
    @Transactional
    public void add(int mailAddressId) {
        MailAddress foundMailAddress = null;
        foundMailAddress = mailAddressRepository.findById(mailAddressId);
        System.out.println("id : " + foundMailAddress.getId());
        if (foundMailAddress != null) {
            AlertWordCountListener alertWordCountListener = new AlertWordCountListener();
            alertWordCountListener.setMailAddress(foundMailAddress);
            alertWordCountListenerRepository.add(alertWordCountListener);
        }
    }

    @Override
    @Transactional
    public AlertWordCountListener findByMailAddress(MailAddress mailAddress) {
        return alertWordCountListenerRepository.findByMailAddress(mailAddress);
    }

    @Override
    @Transactional
    public void remove(int id) {
        alertWordCountListenerRepository.delete(alertWordCountListenerRepository.findById(id));
    }

}

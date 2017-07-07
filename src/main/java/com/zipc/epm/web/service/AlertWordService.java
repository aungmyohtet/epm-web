package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.AlertWord;
import com.zipc.epm.web.entity.AlertWord.Language;

public interface AlertWordService {

    void save(AlertWord alertWord);

    List<AlertWord> findAll();

    AlertWord findByWordAndLanguage(String word, Language language);

    AlertWord findById(int id);

    void update(AlertWord alertWord);

    void delete(int id);
}

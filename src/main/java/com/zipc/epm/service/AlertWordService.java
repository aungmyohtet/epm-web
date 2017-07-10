package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.AlertWord;
import com.zipc.epm.entity.AlertWord.Language;

public interface AlertWordService {

    void save(AlertWord alertWord);

    List<AlertWord> findAll();

    AlertWord findByWordAndLanguage(String word, Language language);

    AlertWord findById(int id);

    void update(AlertWord alertWord);

    void delete(int id);
}

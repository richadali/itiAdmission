package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Languages;
import com.dect.itiAdmission.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Languages> getLanguages() {
        return languageRepository.findAll();
    }
}

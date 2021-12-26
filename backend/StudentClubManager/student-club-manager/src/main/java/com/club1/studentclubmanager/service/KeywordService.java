package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.model.Keyword;
import com.club1.studentclubmanager.repo.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public List<Keyword> findAllKeywords(){
        return keywordRepository.findAll();
    }

    public Keyword updateKeyword(Keyword keyword, Long id){
        // Check if the keyword exists
        Keyword existingKeyword = keywordRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Keyword by id "+ id + " was not found"));

        existingKeyword.setKeyword(keyword.getKeyword());

        return keywordRepository.save(existingKeyword);
    }

    public Keyword addKeyword(Keyword keyword){
        return keywordRepository.save(keyword);
    }

    public Keyword findKeywordById(Long id){
        return keywordRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("keyword by id "+ id + " was not found"));
    }
    public void deleteKeywordById(Long id){
        boolean exists = keywordRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("keyword by id " + id + " was not found");
        }
        keywordRepository.deleteById(id);
    }
}

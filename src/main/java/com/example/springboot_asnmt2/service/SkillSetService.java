package com.example.springboot_asnmt2.service;

import com.example.springboot_asnmt2.model.SkillSet;
import com.example.springboot_asnmt2.repository.SkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillSetService {

    @Autowired
    private SkillSetRepository skillSetRepository;

    public SkillSet createSkill(SkillSet skillSet) {
        return skillSetRepository.save(skillSet);
    }

    public List<SkillSet> getAllSkills() {
        return skillSetRepository.findAll();
    }
}

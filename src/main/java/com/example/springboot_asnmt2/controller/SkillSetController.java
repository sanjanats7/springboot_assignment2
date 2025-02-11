package com.example.springboot_asnmt2.controller;

import com.example.springboot_asnmt2.model.SkillSet;
import com.example.springboot_asnmt2.service.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillsets")
public class SkillSetController {

    @Autowired
    private SkillSetService skillSetService;

    @PostMapping
    public SkillSet createSkill(@RequestBody SkillSet skillSet) {
        return skillSetService.createSkill(skillSet);
    }

    @GetMapping
    public List<SkillSet> getAllSkills() {
        return skillSetService.getAllSkills();
    }
}

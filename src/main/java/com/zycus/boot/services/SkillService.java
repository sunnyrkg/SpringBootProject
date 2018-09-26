package com.zycus.boot.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.boot.entities.Skill;
import com.zycus.boot.repositories.SkillRepository;

@Service
public class SkillService {
	@Autowired
	SkillRepository skillRepository;
	
	public Iterable<Skill> findAllSkills()
	{
		return skillRepository.findAll();
	}
	public Iterable<Skill> findByName(String skillName)
	{
		return skillRepository.findByName(skillName);
	}
	public Skill findByNameIfNotExistCreatItAndReturnInstanceOfIt(String skillName)
	{
		Iterator<Skill> skillIterator = this.findByName(skillName).iterator();
		Skill inputSkill = skillIterator.hasNext() ? skillIterator.next() : new Skill(skillName);
		return skillRepository.save(inputSkill);
	}
	public Set<Skill> findByNamesIfNotExistCreateItAndReturnIterableOfIt(String...skillNames)
	{
		Set<Skill> skills = new HashSet<>();
		for(String skillName : skillNames)
		{
			skills.add(this.findByNameIfNotExistCreatItAndReturnInstanceOfIt(skillName));
		}
		return skills;
	}
}

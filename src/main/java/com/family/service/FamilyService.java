package com.family.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.Repository.FamilyMemberRepository;
import com.family.model.Family_Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FamilyService {

	@Autowired
	FamilyMemberRepository familyMemberRepo;
	
	public Family_Member getMemberById(int id) {
		log.info("getMemberById in service calling repo....");
		Optional<Family_Member> obj1 =familyMemberRepo.findById(id);
		log.info("Got res from repo....");
		return obj1.get();
	}
	
	public void addMember(Family_Member member) {
		log.info("addMember in Service!....");
		familyMemberRepo.save(member);
		log.info("addMember in Got res from repo!....");
	}
}

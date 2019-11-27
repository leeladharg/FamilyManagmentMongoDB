package com.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.model.Family_Member;
import com.family.service.FamilyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FamilyController {
	
	@Autowired
	FamilyService familyService;

	
	@GetMapping("/getMemberById/{MID}")
	public ResponseEntity<Family_Member> getMemberById(@PathVariable("MID") int mid) {
		log.info("getMemberById in Controller!....");
		Family_Member res = familyService.getMemberById(mid);
		
		return new ResponseEntity<Family_Member>(res, HttpStatus.OK);
	}
	
	@PostMapping("/addMember")
	public ResponseEntity<Family_Member> addMember(@RequestBody Family_Member req ) throws JsonProcessingException {
		log.info("addMember in Controller!....");
		ObjectMapper mapper = new ObjectMapper();
		final String json = mapper.writeValueAsString(req);
		log.info("Request json for addMember...."+ json);
		familyService.addMember(req);
		log.info("Response...addMember in Controller!....");
		return new ResponseEntity<Family_Member>(HttpStatus.OK);
	}

	@RequestMapping("/")
	public String ping() {
		String status = "Service is Up";

		return status;
	}

}

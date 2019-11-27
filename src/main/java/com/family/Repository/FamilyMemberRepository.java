package com.family.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.family.model.Family_Member;

@Repository
public interface FamilyMemberRepository extends MongoRepository<Family_Member,Integer> {


}
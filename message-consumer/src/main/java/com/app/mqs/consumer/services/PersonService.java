package com.app.mqs.consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mqs.consumer.model.Person;
import com.app.mqs.consumer.repositories.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo repo;
	
	public void saveMessage(String message) {
		Person dto = new Person();
		String[] rec = message.split(",");
		int sno =  Integer.parseInt(rec[0]);
		dto.setSno(sno);
		dto.setName(rec[1]);
		dto.setCity(rec[2]);
		repo.save(dto);
	}

}

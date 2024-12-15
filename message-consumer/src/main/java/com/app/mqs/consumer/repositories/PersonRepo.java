package com.app.mqs.consumer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mqs.consumer.model.Person;
@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{

}

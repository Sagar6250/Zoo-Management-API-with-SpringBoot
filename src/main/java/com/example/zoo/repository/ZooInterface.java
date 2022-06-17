package com.example.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zoo.entity.Zoo;

@Repository
public interface ZooInterface extends JpaRepository<Zoo, Integer>{

	List<Zoo> findByName(String name);

	//List<Zoo> findByType(String type);

}

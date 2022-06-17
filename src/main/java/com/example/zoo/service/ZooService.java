package com.example.zoo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.zoo.entity.Zoo;
import com.example.zoo.repository.ZooInterface;

@Service
public class ZooService {

	@Autowired
	private ZooInterface zooI;

	public Zoo admitAnimals(Zoo animals) {
		return zooI.save(animals);
	}

	public String dischargeAnimals(int id) {
		zooI.deleteById(id);
		return "The Animal " + id + " was discharged succesfull";
	}

	public List<Zoo> getAnimal() {
		return zooI.findAll();
	}

	public Zoo getAnimalById(int id) {
		return zooI.findById(id).orElse(null);
	}

	public List<Zoo> getAnimalByName(String name) {
		return zooI.findByName(name);
	}

	public List<Zoo> getAnimalByType(String type) {
		List<Zoo> allAnimals = zooI.findAll();
		ArrayList<Zoo> animals = (ArrayList<Zoo>) allAnimals.stream()
			.filter(animal -> animal.getType().equals(type))
			.collect(Collectors.toList());
		return animals;
	}

	public Zoo updateAnimalById(Zoo animal) {
		Zoo existingAnimal = zooI.findById(animal.getAnimalID()).orElse(null);
		existingAnimal.setName(animal.getName());
		existingAnimal.setType(animal.getType());
		existingAnimal.setHabitat(animal.getHabitat());
		existingAnimal.setNumber(animal.getNumber());
		return zooI.save(animal);
	}
	
	public List<Zoo> sortAnimalByNumber(String dir){
			return zooI.findAll(Sort.by(Sort.Direction.fromString(dir), "number"));
	}
}

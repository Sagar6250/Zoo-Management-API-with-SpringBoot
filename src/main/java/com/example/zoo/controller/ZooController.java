package com.example.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zoo.entity.Zoo;
import com.example.zoo.service.ZooService;

@RestController
public class ZooController {
	
	@Autowired
	private ZooService zooS;
	
	@PostMapping("/addNewAnimal")
	public Zoo getAnimals(@RequestBody Zoo animals) {
		return zooS.admitAnimals(animals);
	}
	
	@DeleteMapping("/dischargeAnimal/{id}")
	public String levAnimals(@PathVariable int id) {
		return zooS.dischargeAnimals(id);
	}
	
	@GetMapping("/getAllAnimals")
	public List<Zoo> petAllAnimals() {
		return zooS.getAnimal();
	}
	
	@GetMapping("/getAnimalByID/{id}")
	public Zoo petAnimal(@PathVariable int id) {
		return zooS.getAnimalById(id);
	}
	
	@GetMapping("/getAnimalByName/{name}")
	public List<Zoo> petAnimal(@PathVariable String name){
		return zooS.getAnimalByName(name);
	}
	
	@GetMapping("/getAnimalByType/{type}")
	public List<Zoo> getByType(@PathVariable String type){
		return zooS.getAnimalByType(type);
	}
	
	@PutMapping("/updateAnimal")
	public Zoo updateAnimalList(@RequestBody Zoo animal) {
		return zooS.updateAnimalById(animal);
	}
	
	@GetMapping("/sortByNumber/{dir}")
	public List<Zoo> getSortedByNumber(@PathVariable String dir){
		return zooS.sortAnimalByNumber(dir);
	}
}

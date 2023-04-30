package com.gft.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.reposotories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	public Person createPerson() {
		
		Person person = new Person();
		person.setName("Vanessa");
		person.setAge(21);
		person.setStatus(Boolean.TRUE);
		
		//String status = person.getStatus() ? "Ativo" : "Inativo";
		// a ? POSITIVO : NEGATIVO; é um operador ternário - pesquisar sobre isso pode se usar dentro das chaves do html com
		//aspas SIMPLES
		
		/*String status;
		
		if (person.getStatus() == true) {
			status = "Ativo";
		}else {
			status = "Inativo";
		}*/
		
		//System.out.println(status);
		
		return person;
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(Long id)  throws Exception{
		
		Optional<Person> person = personRepository.findById(id);
		
		if (person.isEmpty()) {
			/*Person newPerson = new Person();
			newPerson.setName("Não encontrado");
			newPerson.setStatus(Boolean.FALSE);
			return newPerson;*/
			throw new Exception("Cadastro não encontrado");
			
		}
		return person.get();
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	public List<Person> listPerson(){
		return personRepository.findAll(); //vai retornar todas as pessoas dessa lista
	}
}

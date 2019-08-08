package kr.ac.hansung.spring.di;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.RequiredArgsConstructor;

public class PetOwner {

	@Autowired 					//writing by type
	@Qualifier(value="qf_dog")
	//@Resource(name="id_dog")			//writing by name
	private AnimalType animal;

	public void play() {
		animal.sound();
	}

}

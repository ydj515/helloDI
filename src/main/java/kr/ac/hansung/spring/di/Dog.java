package kr.ac.hansung.spring.di;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class Dog implements AnimalType {

	private final String myName;

	@Override
	public void sound() {
		System.out.println("Dong name : " + myName + ":" + "Bow Wow");
	}

}

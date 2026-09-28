package com.akshay.model;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {
	private Integer id = new Random().nextInt(10000);
	
	@NonNull
	private String name;
	
	@NonNull
	private Map<String,Integer> marks;
	
	@NonNull
	private Set<Long> phoneNumbers;
	
	@NonNull
	private List<String> nickNames;
	
	@NonNull
	private Address address;

}

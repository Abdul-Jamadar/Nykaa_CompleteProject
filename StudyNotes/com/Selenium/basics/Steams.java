package com.Selenium.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Steams {
	
	@Test
	public void Streams() {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("Abdul");
		list.add("Sana");
		list.add("Tasnim");
		list.add("Lalesa");
		list.add("Alfaaz");
		//list.stream().filter(s->s.contains("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Map method should be used to modify the content inside the stream.
		List<String> li=list.stream().map(s->s.toUpperCase()).distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
	}
}

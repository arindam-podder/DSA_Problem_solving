package com.example.demo.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch.qos.logback.core.filter.Filter;

public class StreamAPI {
	
	public static void main(String[] args) {
		method();
		
		operationOnEmp();
	}
	
	public static void method() {
		
		int[] arr1 = {12, 4, 77, 6, 37};
		
		//find sum 
		int sum1 = IntStream.of(arr1).sum();
		int sum2 = Arrays.stream(arr1).sum();
		int sum3 = Arrays.stream(arr1).reduce( (a,b) -> a+b).getAsInt();
		
		System.out.println( sum1 + "  -- "+ sum2 + " -- "+ sum3 );
		
		
		//find lowest
		int asInt = Arrays.stream(arr1)
			.reduce((a, b) -> a<b? a:b)
			.getAsInt();
		System.out.println( asInt );
		
		//find 2nd largest 
		Integer val = Arrays.stream(arr1)
			.boxed()
			.sorted()
			.skip(1)
			.findFirst()
			.orElseThrow();
		System.out.println( val );
			
		
		
		String s="ilovemycountry"; 
		
		//find each character occurrence
		Map<String,Long> collect1 = Arrays.stream(s.split(""))
			.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		
		System.out.println( collect1 );
		
		
		//find all unique chars 
		List<String> collect2 = Arrays.stream(s.split(""))
			.collect( Collectors.toMap(c -> c, e-> 1L, Long::sum))
			.entrySet().stream()
			.filter(entry -> entry.getValue()==1)
			.map(entry -> entry.getKey())
			.collect(Collectors.toList());
		System.out.println( collect2 );
		
		
		
		List<Integer> list = Arrays.asList(12, 4, 77, 6, 37);
		
	}
	
	
	public static void operationOnEmp() {
		List<Emp> list = List.of(new Emp(1, "A", 20000, "SALE"),
				new Emp(2, "B", 10000, "HR"),
				new Emp(3, "C", 15000, "HR"),
				new Emp(4, "D", 25000, "SALE"),
				new Emp(5, "E", 30000, "SALE"),
				new Emp(6, "F", 27000, "HR"));
	
		 
		Map<String,List<Emp>> collect1 = list.stream()
			.collect(Collectors.groupingBy(emp -> emp.dept));
		System.out.println( collect1 );
		
		Map<String, Long> collect2 = list.stream()
			.collect( Collectors.groupingBy(emp -> emp.dept, Collectors.counting()) );
		System.out.println( collect2 );
		
		
		//employee with the second highest salary in each department
		Map<String,Integer> collect3 = list.stream()
			.collect( Collectors.groupingBy(emp -> emp.dept) )
			.entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey, 
					entry -> entry.getValue().stream()
								.sorted( (e1, e2) -> e2.sal - e1.sal )
								.skip(1)
								.findFirst()
								.get().sal
					));
		System.out.println( collect3 );
		
		
		//Increase each employee salary by hr=10%  and sale=20%
		List<Emp> collect4 = list.stream()
			.map(emp ->  
					{
						Emp e1 = new Emp(emp.id, emp.name, emp.sal, emp.dept);
						if(e1.dept.equals("HR")) {
							e1.sal += (e1.sal * 10)/100;
						}else {
							e1.sal += (e1.sal * 20)/100;
						}
						return e1;
					})
			.collect(Collectors.toList());
		System.out.println(  collect4 );
		
	}
	
}

















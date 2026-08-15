package com.example.demo;

import java.util.List;
import java.util.TreeSet;

public class Test2 {
	public static void main(String[] args) {
		TreeSet<Double> ts = new TreeSet<>( (o1, o2) -> (int)(o2-o1) );
		
		List<Integer> data = List.of(2, 4, 6, 9 ); 
		
		data.stream().mapToInt(null);
		
		
	}
}

//id name salary dpt 
//
//list.stream().map()


@FunctionalInterface
interface Func {
	int add(int a, int b) throws RuntimeException;

}


class Abc implements Func{
	@Override
	public int add(int a, int b)  {
		// TODO Auto-generated method stub
		return 0;
	}
}


//http://localohost:8080/api/101?name=arindam
//
//getMapping("/api/v1/{id}"
//public ResposeEntity<>  mthd(@Patvariable Integer id, @RequaestParam String name){
//	
//}
//	






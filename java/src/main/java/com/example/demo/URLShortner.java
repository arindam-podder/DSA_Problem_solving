package com.example.demo;

import java.util.Arrays;
import java.util.Base64;

public class URLShortner {
	public static void main(String[] args) {
		
		String url = "https://stm.com/api/v1/getdata";
					
		String urlShort = urlShort(url);
		System.out.println( urlShort );
		
		String urlDecode = urlDecode(urlShort);
		System.out.println( urlDecode );
	}
	
	
	public static String urlShort(String url) {
		String encodeToString = Base64.getUrlEncoder()
			.encodeToString(url.getBytes());
		//System.out.println( encodeToString );
		return encodeToString;
	}
	
	public static String urlDecode(String shortUrl) {
		 byte[] decode = Base64.getDecoder()
		 	.decode(shortUrl);
		 return new String(decode);		  
	}
	
	
}

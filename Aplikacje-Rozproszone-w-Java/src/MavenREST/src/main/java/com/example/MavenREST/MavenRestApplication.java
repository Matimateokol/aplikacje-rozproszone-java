package com.example.MavenREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MavenRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenRestApplication.class, args);
	}

}
@RestController
@RequestMapping("/api")
class Controller {

	@GetMapping("/file")
	String getData(){
		String strLine="";
		try (BufferedReader br = new BufferedReader(new FileReader("DocTekst.txt")))
		{
			strLine= br.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> strList = new ArrayList<String>(Arrays.asList(strLine.split(" ")));
		Collections.sort(strList);
		String result=encrypt(strList.get(1).toString())+strList.toString();
		return result;// strList.toString();
	}
	public static StringBuffer encrypt(String text)
	{
		int s=13;
		StringBuffer result= new StringBuffer();

		for (int i=0; i<text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) +
						s - 65) % 26 + 65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i) +
						s - 97) % 26 + 97);
				result.append(ch);
			}
		}
		return result;
	}


}


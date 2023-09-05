package com.greatlearning.email.service;

import java.util.Random;

import com.greatlearning.email.model.Employee;

public class CredentialService implements ICredentialService{
	
	private String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	private String specialCharacters = "!@#$%^&*()_+=?:";
	private String numbers = "1234567890";
	private String passwordChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	private Random random = new Random();

	@Override
	public void generateEmail(Employee employee) {
		// TODO Auto-generated method stub
		String emailAddress = employee.getFirstName().toLowerCase()+employee.getLastName().toLowerCase()+"@"+employee.getDepartment()+".gl.in";
							
		employee.setEmailAddress(emailAddress);
	}

	@Override
	public void generatePassword(Employee employee) {
		String password = "";
		for(int i=0;i<8;i++) {
			password = password +passwordChars.charAt(random.nextInt(passwordChars.length()));
		}
		employee.setPassword(password);
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Dear "+employee.getFirstName() +"your generated credentials are as follows");
		System.out.println("Email : "+employee.getEmailAddress());
		System.out.println("password : "+employee.getPassword());
		
		
		
	}

}

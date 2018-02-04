package org.tdm.service;

public interface Encryption {
	public String encrypt(String clearTxt,String passCode);
	public String decrypt(String encryptTxt,String passCode);
	
}

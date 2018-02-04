package com.acc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.acc.bean.MaskedColumn;
import com.acc.bean.TestDataBean;
import com.acc.encryption.CaesarCipher;

@Component(value="maskData")
public class MaskDataImp implements MaskData {

	@Override
	public TestDataBean maskData(TestDataBean sampleBean) throws Exception {
		
		TestDataBean testBean = new TestDataBean();
		testBean.setAppId(sampleBean.getAppId());
		testBean.setAppName(sampleBean.getAppName());
		testBean.setDataFormat(sampleBean.getDataFormat());
		
		MaskedColumn maskedColumn = new MaskedColumn();
		maskedColumn.setDataBean(sampleBean.getMasked());
		
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>(); 
				dataList = sampleBean.getData();
		
		HashMap<String,String> testData = new HashMap<String,String>();
		
		for(String maskedkey: maskedColumn.getDataBean().keySet()) {
			if(maskedColumn.getDataBean().get(maskedkey).equalsIgnoreCase("Y")) {
				for (HashMap<String, String> data : dataList) {
					//Mask Data
					if(data.keySet().contains(maskedkey) && maskedkey.contains("password")) {
						data.put(maskedkey, hideData(data.get(maskedkey)));
					}
					else if(data.keySet().contains(maskedkey) && maskedkey.contains("date")) {
						data.put(maskedkey, maskDateData(data.get(maskedkey)));
					}
					else if(data.keySet().contains(maskedkey) && (maskedkey.contains("designation"))) {
						data.put(maskedkey, shuffleData(data.get(maskedkey)));
					}
					//If Data is password
					else if(data.keySet().contains(maskedkey)) {
						data.put(maskedkey, maskValue(data.get(maskedkey)));
					}
					else {
						throw new Exception("We are excpecting correct form of json. Thanks");
					}
				}
			}
		}
			
		testBean.setData(dataList);
		testBean.setMasked(sampleBean.getMasked());			
		return testBean;
	}

	private String maskDateData(String date) {
		if(date.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$")) {
			return "2018-02-05";
		}
		return "1995-02-05";
	}

	private String maskValue(String valueToBeMasked) {
		String maskedValue=null;
		int random = (int) (Math.random()*15+1);
		
		if(StringUtils.isNumeric(valueToBeMasked)) {
			int value = Integer.parseInt(valueToBeMasked);
			value = value*random+random*15-random*40;
			maskedValue=value+"";
		}
		
		else if(StringUtils.isAlpha(valueToBeMasked)) {
			maskedValue = CaesarCipher.encrypt(valueToBeMasked, random);
		}
		
		else if(StringUtils.isAlphanumeric(valueToBeMasked)) {
			maskedValue = CaesarCipher.encrypt(valueToBeMasked, random);
		}
		
		else {
			maskedValue = CaesarCipher.encrypt(valueToBeMasked, random);
		}
		
		return maskedValue;
		
	}
	
	private String hideData(String valueToBeMasked) {
		String maskedValue="";
		for (char c : valueToBeMasked.toCharArray()) {
			maskedValue += "#";
		}
		return maskedValue;
	}
	
	public String shuffleData(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }
	
	
	
}

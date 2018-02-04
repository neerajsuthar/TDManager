package org.tdm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.tdm.bean.TestDataBean;

@Component(value="prepareData")
public class PrepareDataImp implements PrepareData{
	
	
	@Override
	public TestDataBean createData(TestDataBean sampleBean) {
		TestDataBean testBean = new TestDataBean();
		testBean.setAppId(sampleBean.getAppId());
		testBean.setAppName(sampleBean.getAppName());
		testBean.setDataFormat(sampleBean.getDataFormat());
		HashMap<String,String> testData = new HashMap<String,String>();
		int marker = 0;
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>(); 
		for(int i=0;i<3;i++) {
			for(HashMap<String, String> dataMap : sampleBean.getData()) {
				HashMap<String,String> testMap = new HashMap<String,String>();
				marker++;
				for(Entry<String,String> entryMap : dataMap.entrySet()) {
					testMap.put(entryMap+"-"+marker, entryMap.getValue()+"-"+marker);
				}
				dataList.add(testMap);
			}
		}
		testBean.setData(dataList);
		testBean.setMasked(sampleBean.getMasked());			
		return testBean;
	}
	

}

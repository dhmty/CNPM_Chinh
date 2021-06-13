/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.Properties;

/**
 *
 * @author MinhTo
 */
public class PropertiseUtil {
private static Properties properties;
	static{
		try {
		    //Get the curre nt classPath path
			String url =  PropertiseUtil.class.getResource("/").toString().replace("file:/", "");
			File file=new File(url);
			//Get all *.properties files under the project
			File[] files = file.listFiles(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					if(name.endsWith(".properties")){
						return true;
					}
					return false;
				}
				
			});
			properties=new Properties();
			for(File f:files){ // retrive all .properties files  
				Properties p=new Properties();
				FileInputStream in=new FileInputStream(f);
				p.load(in);
				properties.putAll(p);
                                
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Get the configured value according to the key
	*/
	public String getValue(String key,String defaultValue){
		String value = properties.getProperty(key, defaultValue);
		return value;
	}
    
//        public static void main(String[] args) {
//            new PropertiseUtil().getValue("name","minhto");
//            
//    }
}

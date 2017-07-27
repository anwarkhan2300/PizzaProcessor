package com.pizza.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PizzaLexicalShortHelper implements PizzaShort{
	
	@Override
	public Map<String, LocalDateTime> pizzaShort(MultipartFile file){
    	BufferedReader br;
    	Map<String, LocalDateTime> shortedMap = new TreeMap<String, LocalDateTime>();
        try{
              InputStream is = file.getInputStream();
              br = new BufferedReader(new InputStreamReader(is));
              String line;
              while ((line = br.readLine()) != null) {
            	  String [] st =line.split("\\s{1,}");
         	       if((!"Order".equals(st[0].trim())) && (!"".equals(st[0].trim()))){
         	    	 shortedMap.put(st[0], LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(st[1].trim())), ZoneId.systemDefault()));
         	      }
         	    }
            br.close();
            }catch(IOException e){
    		e.printStackTrace();
           }
		return shortedMap;
    }

}

package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ofranca
 *
 */
public class FindManager {

	/**
	 * Padrao para busca de url
	 * */
	private static final Pattern urlPattern = Pattern.compile(
	        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
	                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
	                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
	        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	
	
	public List<Url> findAllUrls(String url){
		List <Url> ret = new ArrayList<Url>();
        URL inputUrl;
        
		try {
			inputUrl = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(inputUrl.openStream()));

	        String inputLine;
	        while ((inputLine = in.readLine()) != null){        	
	        	ret.addAll(findUrl(inputLine));
	        	System.out.println("teste");
	        }            
	        in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        
        return ret;
	}
	
	
	private List <Url> findUrl(String line){				
		List <Url> urlResultList = new ArrayList<Url>(); 
		Matcher matcher = urlPattern.matcher(line);
		while (matcher.find()) {
		    int matchStart = matcher.start(1);
		    int matchEnd = matcher.end();
		    
		    Url url = new Url(line.substring(matchStart, matchEnd));
		    
		    urlResultList.add(url);
		    
		}		
		return urlResultList;
		
	}
}

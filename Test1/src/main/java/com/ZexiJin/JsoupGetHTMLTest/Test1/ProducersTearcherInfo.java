package com.ZexiJin.JsoupGetHTMLTest.Test1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ProducersTearcherInfo {
	private Document document;
    protected ArrayList<String> Results;
    protected String inputURL;
    org.jsoup.nodes.Element content;
    Elements list;
    
    public ProducersTearcherInfo(String URL) {
		this.inputURL = URL;
		this.Results = new ArrayList<String>();
		CalcResult();
	}
    
    public ArrayList<String> getResult() {
        return Results;
    }

    public String getInput() {
        return inputURL;
    }
    
    private String convertSimpleString(String keyWord, int numTmp){
        content = document.getElementById(keyWord);
        if(content != null){
        	if(content.text().length() > numTmp)
        		return content.text().substring(numTmp) + "\n";
        	else {
				return content.text();
			}
        }
        else
        	return "no information about " + keyWord + " found\n";
    }
    
    private String convertStringList(String keyWord, String tagName, int numTmp){
        content = document.getElementById(keyWord);
        if(content != null){
            list = content.getElementsByTag(tagName);
            String tmpString = "";
            for (org.jsoup.nodes.Element tmpNode : list){
            	tmpString = tmpString + tmpNode.text() + "\n";
            }
        	return tmpString.substring(numTmp);
        } else
        	return "no information about " + keyWord + " found\n";
    }
    
    private String convertTeacherName(String keyWord, String tagName){
        content = document.getElementById(keyWord);
        if(content != null){
	        list = content.getElementsByTag(tagName);
	        org.jsoup.nodes.Element node = list.get(0);
	        return node.text() + "\n";
        }
        else
        	return "no information about " + keyWord + " found\n";
    }
    
    private String convertTeacherImage(String keyWord) {
    	content = document.getElementById(keyWord);
    	if(content != null){
    		String tmpString = content.html();
    		if(tmpString.contains("jpg")){
    			int tmpNum = tmpString.indexOf("jpg");
    			tmpString = tmpString.substring(0, tmpNum + 3);
    		}
    		if(tmpString.contains("<img src=\"")){
    			tmpString = tmpString.replace("<img src=\"", "");
    		}
    		return tmpString;
    	} else 
    		return "";
    }
    
    public void CalcResult(){
		try {
			this.document = Jsoup.connect(inputURL).get();
			Results.add(convertTeacherImage("photo"));
			Results.add(convertTeacherName("content", "a"));
	        Results.add(convertStringList("depts", "a", 0));
	        Results.add(convertSimpleString("degrees", 8));
	        Results.add(convertSimpleString("expertise", 10));
	        Results.add(convertSimpleString("profile", 8));
	        Results.add(convertStringList("courses", "tr", 0));
	        Results.add(convertStringList("awards", "p", 18));
	        Results.add(convertStringList("scholarship", "p", 15));
		} catch (UnknownHostException e) {
			System.err.println("invalid URL");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Construction failed");
		}
    }
}

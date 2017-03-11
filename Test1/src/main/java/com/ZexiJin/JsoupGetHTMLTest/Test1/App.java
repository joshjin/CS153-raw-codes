package com.ZexiJin.JsoupGetHTMLTest.Test1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String url = "http://www.brandeis.edu/facultyguide/person.html?emplid=0386df497f9649cec6a7b97cda2f1e857dd38316";
    	String url1 = "http://registrar-prod.unet.brandeis.edu/registrar/schedule/course?acad_year=2017&crse_id=009531&strm=1171&class_section=1";
    	String url2 = "http://www.bkstr.com/webapp/wcs/stores/servlet/booklookServlet?bookstore_id-1=1391&term_id-1=1163&div-1=&dept-1=IGS&course-1=8A&sect-1=1";
    	String url3 = "http://www.brandeis.edu/facultyguide/person.html?emplid=8d536d3f4bfdeca764f0daff6f93a8bcbf742393";
    	ProducersTearcherInfo tearcherInfo = new ProducersTearcherInfo(url3);
    	ArrayList<String> tmp = tearcherInfo.getResult();
    	for(String tmpStr : tmp){
    		System.out.println(tmpStr);
    	}
    	//ProducersClassDescription course = new ProducersClassDescription(url1);
    	//tmp = course.getResult();
    	/*
    	for(String tmpStr : tmp){
    		System.out.println(tmpStr);
    	}
    	*/
    	//ProducersBooksInfo booksInfo = new ProducersBooksInfo(url2);
    	
    	
        //System.out.println( "Hello World!" );
        //String url = "http://www.brandeis.edu/facultyguide/person.html?emplid=0386df497f9649cec6a7b97cda2f1e857dd38316";
        //Document doc = Jsoup.connect(url).get();
        //String title = doc.title();
        //System.out.println(doc.toString());
        //System.out.println();
        //System.out.println();
        //System.out.println();
        //org.jsoup.nodes.Element content = doc.getElementById("scholarship");
        //Elements scho = content.getElementsByTag("p");
        //for (org.jsoup.nodes.Element nod : scho){
        //	System.out.println(nod.text());
        //}
        //String tmp = content.text();
        //System.out.println(tmp);
        //Professor prof = new Professor("http://www.brandeis.edu/facultyguide/person.html?emplid=0386df497f9649cec6a7b97cda2f1e857dd38316");
        //System.out.println(prof.getDepts());
        //System.out.println(prof.getExpertise());
        //ystem.out.println(prof.getProfile());
       // System.out.println("@" + prof.getDeptURL() + "@");
    }
}

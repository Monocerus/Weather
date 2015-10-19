package com.weather.tianle;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class SaxParseServices{
	
	public static Weather getDataFromXML(InputStream in)
	{
		
		try {
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();

			SAXParser saxParser = null;
			SaxParseHandler handler = null;
			saxParser = saxFactory.newSAXParser();
			
			handler = new SaxParseHandler();
			
			saxParser.parse(in, handler);
			
			return handler.getWeather();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}

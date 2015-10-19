package com.weather.tianle;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseHandler extends DefaultHandler {

	private Weather weather = null;

	private Forecast_information forecast_information;

	private Conditions condition = null; //

	private String preTag = null;

	public Weather getWeather() {
		return this.weather;
	}

	public void startDocument() throws SAXException {
		weather = new Weather();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if ("forecast_information".equals(qName)) {

			
			forecast_information = new Forecast_information();
			

		} else if ("today_conditions".equals(qName)) {

			condition = new Conditions();

		} else if ("secondday_conditions".equals(qName)) {

			condition = new Conditions();

		} else if ("thirdday_conditions".equals(qName)) {

			condition = new Conditions();

		} else if ("fourthday_conditions".equals(qName)) {

			condition = new Conditions();

		} else if ("fifthday_conditions".equals(qName)) {

			condition = new Conditions();
		}

		preTag = qName;

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if ("forecast_information".equals(qName)) {

			weather.setForecast_information(forecast_information);
			
			forecast_information = null;

		} else if ("today_conditions".equals(qName)) {

			weather.getConditions()[0] = condition;
			
			condition = null;

		} else if ("secondday_conditions".equals(qName)) {
			weather.getConditions()[1] = condition;
			condition = null;

		} else if ("thirdday_conditions".equals(qName)) {
			weather.getConditions()[2] = condition;
			condition = null;

		} else if ("fourthday_conditions".equals(qName)) {
			weather.getConditions()[3] = condition;
			condition = null;

		} else if ("fifthday_conditions".equals(qName)) {
			weather.getConditions()[4] = condition;
			condition = null;

		}

		preTag = null;
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (preTag != null) {
			String data = new String(ch, start, length);
			
			if ("city".equals(preTag)) {
				
				forecast_information.setCity(data);
			} else if ("current_date".equals(preTag)) {
				forecast_information.setCurrent_date(data);
			} else if ("update_time".equals(preTag)) {
				forecast_information.setUpdate_time(data);
			} else if ("current_weather".equals(preTag)) {
				forecast_information.setCurrent_weather(data);
			} else if ("date".equals(preTag)) {
				condition.setDate(data);
			} else if ("week".equals(preTag)) {
				condition.setWeek(data);
			} else if ("condition".equals(preTag)) {
				condition.setCondition(data);
			} else if ("direction".equals(preTag)) {
				condition.setDirection(data);
			} else if ("wind".equals(preTag)) {
				condition.setWind(data);
			} else if ("humidity".equals(preTag)) {
				condition.setHumidity(Integer.parseInt(data));
			} else if ("low".equals(preTag)) {
				condition.setLow(Integer.parseInt(data));
			} else if ("high".equals(preTag)) {
				condition.setHigh(Integer.parseInt(data));
			} else if ("body_temp1".equals(preTag)) {
				condition.setBody_temp1(Integer.parseInt(data));
			} else if ("body_temp2".equals(preTag)) {
				condition.setBody_temp2(Integer.parseInt(data));
			} else if ("contamination".equals(preTag)) {
				condition.setContamination(Integer.parseInt(data));
			} else if ("cont_msg".equals(preTag)) {
				condition.setCont_msg(data);
			} else if ("air_condition".equals(preTag)) {
				condition.setAir_condition(data);
			} else if ("air_condition_msg".equals(preTag)) {
				condition.setAir_condition_msg(data);
			} else if ("carwash".equals(preTag)) {
				condition.setCarwash(Integer.parseInt(data));
			} else if ("carwash_msg".equals(preTag)) {
				condition.setCarwash_msg(data);
			} else if ("dress".equals(preTag)) {
				condition.setDress(Integer.parseInt(data));
			} else if ("dress_msg".equals(preTag)) {
				condition.setDress_msg(data);
			} else if ("rays".equals(preTag)) {
				condition.setRays(data);
			} else if ("rays_msg".equals(preTag)) {
				condition.setRays_msg(data);
			} 
		}

	}
}

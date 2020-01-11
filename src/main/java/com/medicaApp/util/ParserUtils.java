package com.medicaapp.util;

public class ParserUtils {

	private ParserUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String checkEmpty(String param) {
		if(param == null) {
			return null;
		}else if ( param.length() == 0) {
			return null;
		}
		return param;
	}

}

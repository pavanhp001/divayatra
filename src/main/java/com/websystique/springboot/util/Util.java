package com.websystique.springboot.util;

import java.util.Collection;

public class Util {
	
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Collection col) {
		return col == null || col.isEmpty() == true;
	}

}

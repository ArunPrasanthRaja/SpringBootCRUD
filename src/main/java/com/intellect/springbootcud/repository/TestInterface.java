package com.intellect.springbootcud.repository;

public interface TestInterface {
	
	default String print(String str) {
		if (!isNullj(str))
			System.out.println("MyData Print::" + str);
		return str;
	}

	static boolean isNullj(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
}

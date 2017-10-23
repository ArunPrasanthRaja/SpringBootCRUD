package com.intellect.springbootcud.repository;

public class Testing implements TestInterface{

	
	/*public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}*/
	
	public static void main(String args[]){
		System.out.println(TestInterface.isNullj("Developer1"));
		//Testing obj = new Testing();
		//String s =obj.print("ddd");
		//Boolean b=obj.isNull("abc");
		System.out.println(TestInterface.isNullj("ddd"));
		//System.out.println(" boolean b == "+b);
	}
}

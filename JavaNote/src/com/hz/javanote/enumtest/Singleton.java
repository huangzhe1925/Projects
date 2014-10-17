package com.hz.javanote.enumtest;

public class Singleton {

	private static Singleton instance;
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(instance){
				if(instance==null){
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
	
	public static void main(String args[]){
	}
}

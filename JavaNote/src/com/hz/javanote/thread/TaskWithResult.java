package com.hz.javanote.thread;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String>{

	private int id;
	public TaskWithResult(int id){
		
	}
	@Override
	public String call() throws Exception {
		return "Result of TaskWithResult "+id;
	}
}

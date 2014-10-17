package com.hz.javanote.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String args[]) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0;i<10;i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		try {
			for (Future<String> fs : results) {
				System.out.println(fs.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e);
			return;
		}finally{
			exec.shutdown();
		}
	}
}

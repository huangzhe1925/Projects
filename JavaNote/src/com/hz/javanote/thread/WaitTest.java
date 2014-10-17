package com.hz.javanote.thread;

public class WaitTest implements Runnable{

	public WaitTest(){
	}
	public static void main(String args[]) {
		WaitTest wt=new WaitTest();
		NotifierTest nt=new NotifierTest(wt);
		new Thread(wt).start();
		new Thread(nt).start();
	}

	@Override
	public void run() {
		System.out.println("Waiter waits");
		try {
			synchronized (this) {
				System.out.println("Waiter get key");
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiter start");
	}
}

class NotifierTest implements Runnable{

	Object toBeAwake;
	NotifierTest(Object obj){
		this.toBeAwake=obj;
	}
	
	@Override
	public void run() {
		System.out.println("Notifier start");
		synchronized (toBeAwake) {
			System.out.println("Notifier get key");
			toBeAwake.notify();
		}
	}
	
}

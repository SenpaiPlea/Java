package syncSum;

import java.util.ArrayList;
import java.util.List;


public class MySum {

	
	public static class WorkerThread extends Thread {
		private MySum shared;
		public WorkerThread(MySum shared) {
			this.shared = shared;
		}
		
		@Override
		public void run() {
//			System.out.println("Thread running");
//			System.out.println("Thread finished");
			shared.increaseSum();
		}
	}

	private static MySum shared = new MySum();
	static int sum = 0;
	
//	public synchronized void increaseSum() {
////		TODO: sleep for 100ms, increment sum by 1, print out current thread name and sum value
//		try {
//			Thread.sleep(100); //100ms
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//			sum += 1;
//			System.out.println("Thread-" + Thread.currentThread().getName() + ": " + sum);
//	}
	
	public void increaseSum() {
//		TODO: sleep for 100ms, increment sum by 1, print out current thread name and sum value
		try {
			Thread.sleep(100); //100ms
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			
			sum += 1;
			System.out.println("Thread-" + Thread.currentThread().getName() + ": " + sum);
		}


	}
	
	
	
	public static void main(String[] args) {
		
//		TODO: Write a program that launches 100 threads. Each thread should share the same instance of the MySum class and invoke the “increaseSum” method.
		List<Thread> threads = new ArrayList<Thread>();
		MySum shared = new MySum();
		
		for(int i = 0; i < 100; i++) {

			WorkerThread thread = new WorkerThread(shared);
			thread.setName(String.valueOf(i));
			threads.add(thread);
			thread.start();

		}
		
//        int running = 0;
//        do {
//            running = 0;
//            for (Thread thread : threads) {
//                if (thread.isAlive()) {
//                    running++;
//                }
//            }
//            System.out.println("We have " + running + " running threads. ");
//        } while (running > 0);

	}
	
	
}

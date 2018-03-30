/**
 * A class for test thread each solution.
 * @author Thanaphon Keawjam
 */
public class ThreadSum {
	
	public static void main(String[] args) {
		final int LIMIT = 10000000;
		//Counter counter = new Counter();
		//Counter counter = new CounterWithLock();
		Counter counter = new SynchronousCounter();
		//Counter counter = new AtomicCounter();
		
		runThreads(counter, LIMIT);
	}
	
	/**
	 * Run thread and print runtime and counter total.
	 * @param counter is object of counter.
	 * @param limit is limit number.
	 */
	public static void runThreads(Counter counter, final int limit) {
		AddTask addtask = new AddTask(counter, limit);
		SubtractTask subtask = new SubtractTask(counter, limit);
		
		Thread thread1 = new Thread(addtask);
		Thread thread2 = new Thread(subtask);
		
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}catch(InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		
		double elapsed = 1.0E-9*(System.nanoTime() - startTime);
		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
		
		System.out.printf("Counter total is %d\n", counter.get());
		
	}

}

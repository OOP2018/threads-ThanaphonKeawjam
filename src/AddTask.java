/**
 * AddTask adds number 1 ... limit to the counter, then exit.
 * @author Thanaphon Keawjam
 */
public class AddTask implements Runnable{

	private Counter counter;
	private int limit;
	
	/**
	 * Constructor for set counter and limit.
	 * @param counter is object of Counter.
	 * @param limit is limit number.
	 */
	public AddTask(Counter counter, int limit) {
		this.counter = counter;
		this.limit = limit;
	}

	/**
	 * Add positive value to counter.
	 */
	@Override
	public void run() {
		for(int k = 1; k <= limit; k++) counter.add(k);
		System.out.println("Done " + Thread.currentThread().getName());
	}
	
}

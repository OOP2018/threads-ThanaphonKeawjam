import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class for add value by ReentrantLock.
 * @author Thanaphon Keawjam
 */
public class CounterWithLock extends Counter{
	
	private Lock lock = new ReentrantLock();
	
	/**
	 * Add amount to counter.
	 */
	public void add(int amount) {
		try {
			lock.lock();
			super.add(amount);
		}finally {
			lock.unlock();
		}
	}

}

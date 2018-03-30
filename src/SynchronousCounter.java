/**
 * A class for add value by Syschronized.
 * @author Thanaphon Keawjam
 */
public class SynchronousCounter extends Counter{

	/**
	 * Add amount to counter.
	 */
	@Override
	public synchronized void add(int amount) {
		total += amount;
	}
}

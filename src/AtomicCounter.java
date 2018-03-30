import java.util.concurrent.atomic.AtomicLong;

/**
 * A class for 
 * @author Thanaphon Keawjam
 */
public class AtomicCounter extends Counter{
	
	private AtomicLong total;
	
	/**
	 * Constructor for set object.
	 */
	public AtomicCounter() {
		total = new AtomicLong();
	}
	
	/**
	 * Add amount to AtomicLong.
	 */
	public void add(int amount) {
		total.getAndAdd(amount);
	}
	
	/**
	 * Get total from AtomicLong.
	 */
	public long get() {
		return total.longValue();
	}
	
}

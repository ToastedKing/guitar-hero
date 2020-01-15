
public class RingBuffer {

	public double[] stack;
	public int cap;
	public int last;
	public int first;
	public int size;

	/**
	 * @param capacity
	 * 
	 *            create an empty ring buffer, with given max capacity
	 */
	public RingBuffer(int capacity) {
		stack = new double[capacity];
		cap = capacity;
		last = 0;
		first = 0;
		size = 0;
	}

	public static void main(String[] args) {
		RingBuffer obj1 = new RingBuffer(2);
		obj1.enQueue(4);
		obj1.enQueue(5);
		obj1.deQueue();
		obj1.enQueue(6);
		obj1.deQueue();
		System.out.println(obj1);

	}

	/**
	 * creates a toString for testing purpose
	 */
	public String toString() {
		return ("the size = " + size + " the first value is: " + first);
	}

	/**
	 * @return a double
	 * 
	 *         return number of items currently in the buffer
	 */
	public double size() {
		return size;
	}

	/**
	 * @return a boolean
	 * 
	 *         checks to see if the buffer is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @returns a boolean checks to see if the buffer is full
	 */
	public boolean isFull() {
		return size == cap;
	}

	/**
	 * @param x
	 * 
	 *            add item x to the end
	 */
	public void enQueue(double x) {
		if (isFull()) {
			throw new RuntimeException("Array is full");
		} else {
			stack[(first + size) % cap] = x;
			size++;
		}
	}

	/**
	 * @return a double
	 * 
	 *         delete and return item from the front
	 */
	public double deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Array is empty");
		}
		if (first == cap - 1) {
			first = 0;
			size--;
			return stack[cap - 1];
		} else {
			first++;
			size--;
			return stack[first - 1];
		}
	}

	/**
	 * @return a double
	 * 
	 *         return (but do not delete) item from the front
	 * 
	 */
	public double peek() {

		if (isEmpty()) {
			throw new RuntimeException("Array is empty");
		}
		return stack[first];
	}
}

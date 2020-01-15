
public class GuitarString {
	double freq;
	int N;
	RingBuffer buff;
	int tic = 0;

	/**
	 * @param frequency
	 *            a non-null Double
	 * 
	 *            create a constructor that takes in a frequency and uses
	 *            RingBuffers constructor to make a array of frequencies
	 */
	public GuitarString(double frequency) {
		N = (int) (44100 / frequency);
		buff = new RingBuffer(N);
		for (int i = 0; i < N; i++) {
			buff.enQueue(0);
		}

	}

	/**
	 * @param init
	 * 
	 *            Creates a RingBuffer of capacity equal to the size of the array,
	 *            and initializes the contents of the buffer to the values in the
	 *            array.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public GuitarString(double[] init) {
		N = init.length;
		buff = new RingBuffer(N);
		for (int i = 0; i < init.length; i++) {
			buff.enQueue(init[i]);
		}

	}

	public static void main(String[] args) {
		GuitarString obj1 = new GuitarString(440);

		obj1.pluck();
		obj1.tic();
		obj1.sample();
		obj1.time();
		System.out.println(obj1);

		double[] array = new double[5];
		GuitarString obj2 = new GuitarString(array);
		obj2.pluck();
		obj2.sample();
		System.out.println(obj2);
	}

	/**
	 * creates a toString for testing purpose
	 */
	public String toString() {
		return ("the sample = " + sample() + " int has been called: " + tic);
	}

	/**
	 * Replace the N items in the ring buffer with N random values between -0.5 and
	 * +0.5.
	 */
	public void pluck() {

		for (int i = 0; i < N; i++) {
			buff.deQueue();
			double value = Math.random() - .5;
			buff.enQueue(value);
		}
	}

	/**
	 * Apply the Karplus-Strong formula
	 */
	public void tic() {
		buff.enQueue(((buff.peek() + buff.deQueue()) / 2) * .994);
		tic++;

	}

	/**
	 * @return a double
	 * 
	 *         Return the value of the item at the front of the ring buffer.
	 */
	public double sample() {
		return buff.peek();

	}

	/**
	 * @return an int
	 * 
	 *         Return the total number of times tic() was called.
	 * 
	 */
	public int time() {
		return tic;

	}
}

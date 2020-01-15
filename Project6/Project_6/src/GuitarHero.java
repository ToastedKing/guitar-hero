
public class GuitarHero {

	public static void main(String[] args) {
		// creates a keyboard string.

		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		GuitarString[] gString = new GuitarString[keyboard.length()];
		// initialize GuitarStrings corresponding to the keys.

		for (int i = 0; i < keyboard.length(); i++) {
			gString[i] = new GuitarString(440.0 * Math.pow(1.05956, i - 24));
		}

		while (true) {

			// check if the user has typed a key; if so, process it
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				// the user types this character
				// pluck the corresponding string
				if (keyboard.indexOf(key) != -1) {
					gString[keyboard.indexOf(key)].pluck();

				}
			}

			// compute the superposition of samples

			double value = 0.0;
			for (int i = 0; i < keyboard.length(); i++) {
				value += gString[i].sample();
			}
			// play the sample on standard audio
			StdAudio.play(value);

			// advance the simulation of each guitar string by one step
			for (int j = 0; j < keyboard.length(); j++) {
				gString[j].tic();
			}
		} // end start if
	}
}

package com.chrisom.scalablepress;

public class PseudoRandomSimple {
	private long seed;

	public static void main(String[] args) {
		int value = Integer.parseInt(args[0]);
		if(value <= 1000000) {
			System.out.println(randomNumber(value));
		} else {
			System.out.println("ERROR: Your number is out of boundaries");
		}
	}

	static public boolean flip() {
		PseudoRandomSimple prs = new PseudoRandomSimple();
		return prs.random() == 1 ? true : false;
	}

	static public String convertBinary(int num){
		int binary = 0;
	    StringBuffer bin = new StringBuffer();

	    while(num > 0){
	      binary = num % 2;
	      bin.append(binary);
	      num = num/2;
	    }

	    return bin.reverse().toString();
	}

	static public int randomNumber(int n) {
		int random = 0;
		String converted = convertBinary(n);
		StringBuffer flipped = new StringBuffer();
		for(int i = 0; i < converted.length(); i++) {
			flipped.append(flip() ? converted.charAt(i) : (converted.charAt(i) == '1' ? '0' : '1'));
		}

		do {
			random = Integer.valueOf(flipped.toString(), 2);
		} while(random > n);

		return random;
	}

	//Constructor simple of the class
	public PseudoRandomSimple() {
		//Passing current time in milliseconds
	    this(System.currentTimeMillis());
	}

	//Constructor with parameter - passing seed to the global variable
	public PseudoRandomSimple(long seed) {
	    this.seed = seed;
	}

	//Creating random based in xorshift 32 number generator
	public int random() {
	    seed ^= (seed << 13);
	    seed ^= (seed >>> 17);
	    seed ^= (seed << 5);

	    int x = (int) seed % 2;
	    return (x < 0) ? -x : x;
	}

}

package com.chrisom.scalablepress;


public class PseudoRandomSimple {
	private long seed;
	
	public static void main(String[] args) {
		PseudoRandomSimple prs = new PseudoRandomSimple();
		int value = Integer.parseInt(args[0]);
		if(value <= 1000000) {
			int random  = prs.random(value + 1);
			System.out.println(random);
		} else {
			System.out.println("ERROR: Your number is out of boundaries");
		}
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
	public int random(int max) {
	    seed ^= (seed << 13);
	    seed ^= (seed >>> 17);
	    seed ^= (seed << 5);
	    
	    int x = (int) seed % max;     
	    return (x < 0) ? -x : x;
	}
	

}

package algorithms;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	// create n-by-n grid, with all sites blocked
	// site number given by : i*n + j, so (2,3) will be 2*20 +3 = 43 in a 20X20
	// grid
	WeightedQuickUnionUF weightedQuickUnion;
	
	public Percolation(int n) {
		// create a set union find data structure of size XN
		this.weightedQuickUnion = new WeightedQuickUnionUF(n*n);
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		boolean isOpen = false;
		return isOpen;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {

		boolean isFull = false;
		return isFull;
	}

	// number of open sites
	public int numberOfOpenSites() {

		int numberOfOpenSites = 0;
		return numberOfOpenSites;
	}

	// does the system percolate?
	public boolean percolates(){
		boolean percolates = false;

		return percolates;
	}

	// test client (optional)
	public static void main(String[] args) {

		// size of square grid nXn

		int n = 20;
	}

}
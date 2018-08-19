package part1;

import java.util.Arrays;

public class KnightsTourNode {
	
	private boolean[][] b;
	private int i;
	private int j;
	private int n;
	private int k;
	private KnightsTourNode parent;
	
	public KnightsTourNode(boolean[][] b, int i, int j, int n, int k, KnightsTourNode parent){
		this.b = new boolean[n][n];
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				this.b[row][col] = b[row][col];
			}
		}
		this.i = i;
		this.j = j;

		if(parent != null){
			this.b[i][j] = true;
		}
		
		this.n = n;
		this.k = k;
		this.parent = parent;
	}
	
	public boolean complete(){
		if(k == n*n){
			return true;
		}
		else{
			return false;
		}
		
	}

	public KnightsTourNode getParent() {
		return parent;
	}

	public void setParent(KnightsTourNode parent) {
		this.parent = parent;
	}

	public boolean[][] getB() {
		return b;
	}

	public void setB(boolean[][] b) {
		this.b = b;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	
}

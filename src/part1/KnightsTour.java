package part1;

import java.awt.Color;
import java.util.Arrays;

import ecs100.UI;

/**
 * Calculates and displays an open knights tour of an nxn board where n>=5
 * @author James Sutton
 *
 */
public class KnightsTour {
	
	private static int n;
	private static int[][] moves = new int[][] { {2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1} };
	private static int size = 50;
	private static KnightsTourNode goal = null;
	
	public static void main(String[] args){
		
		n = Integer.parseInt(args[0]);
		
		if(n < 5){
			throw new Error("n must be at least 5");
		}
		
		UI.println("Knights Tour of a "+n+"x"+n+" Board");
		
		final long startTime = System.currentTimeMillis();
		
		boolean kt = Knight();
		System.out.println(kt);
		
		final long endTime = System.currentTimeMillis();
		UI.println("\nTotal execution time: " + (endTime - startTime) + "ms");
		
		if(kt == true){
			drawBoard();
		}else{
			UI.println("\nNo Knights Tour found");
		}
	}
	

	private static boolean Knight() {
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){

				boolean[][] b = new boolean[n][n];
				
				KnightsTourNode root = new KnightsTourNode(b,i,j,n,1,null);
				boolean kt = KnightBT(root);
				if(kt == true){
					return true;
				}
			}
		}
		return false;
	}


	private static boolean KnightBT(KnightsTourNode node) {

		if(node.complete()){
			goal = node;
			return true;
		}
		if(goal == null){
			for(int d = 0; d < 8; d++){
				int di = moves[d][0];
				int dj = moves[d][1];
				int idi = node.getI()+di;
				int jdj = node.getJ()+dj;
				if(0 <= idi && idi < n && 0 <= jdj && jdj < n && node.getB()[idi][jdj] == false){
					boolean kt = KnightBT(new KnightsTourNode(node.getB(),idi,jdj,n,node.getK()+1,node));
					if(kt == true){
						return true;
					}
				}
			}
		}
		return false;
	}


	private static void drawBoard() {
		
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				UI.drawRect(size*col,size*row,size,size);
			}
		}
		double[] xp = new double[n*n];
		double[] yp = new double[n*n];
		
		KnightsTourNode ktn = goal;
		for(int i = (n*n)-1; i >= 0; i--){
			xp[i] = ktn.getI()*size + size/2;
			yp[i] = ktn.getJ()*size + size/2;
			ktn = ktn.getParent();
		}
		
		UI.setColor(Color.RED);
		for(int j = 0; j < (n*n); j++){
			UI.drawString(Integer.toString(j+1), xp[j], yp[j]);
		}
		
		UI.setColor(Color.BLUE);
		for(int k = 0; k < (n*n)-1; k++){
			UI.drawLine(xp[k], yp[k], xp[k+1], yp[k+1]);
		}
		
	}

}

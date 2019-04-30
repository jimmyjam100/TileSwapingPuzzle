import java.util.Random;

public class Puzzle {
	int[][] board;
	int selectX;
	int selectY;
	public Puzzle() {
		board = new int[5][5];
		selectX = -1;
		selectY = -1;
		for (int i = 0; i<5; i++) {
			for (int j=0; j<5; j++) {
				board[i][j] = i*5 + j + 1;
			}
		}
		Random rand = new Random();
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				swap(i, j, rand.nextInt(5), rand.nextInt(5));
			}
		}
	}
	public void select(int x, int y) {
		for (int i = 0; i<5; i++) {
			if(i*100 < x && (i+1)*100 > x) {
				for (int j = 0; j<5; j++) {
					if(j*100 < y && (j+1)*100 > y) {
						if(selectX == -1) {
							selectX = i;
							selectY = j;
						}
						else {
							swap(selectY, selectX, j, i);
						}
					}
				}
			}
		}
	}
	
	public void swap(int x1, int y1, int x2, int y2) {
		int save = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = save;
		selectX = -1;
		selectY = -1;
	}

}

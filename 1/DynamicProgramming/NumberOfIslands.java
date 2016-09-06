public class NumberOfIslands{
	final static int[] offsets = {-1, 0, +1};
	
	public static void main(String[] args) {
		int[][] map = {//0 1 2 3 4
						{0,1,0,0,0}, // i = 0
						{0,1,0,0,1}, // i = 1
						{1,0,0,1,1}, // i = 2
						{0,0,0,0,0}, // i = 3
						{1,0,1,0,1}  // i = 4
					  };
		int[][] matrix = {
                            {1, 0, 1, 0, 1},
                            {1, 1, 0, 0, 0},
                            {0, 1, 0, 1, 1},
                         };
 
        NumberOfIslands solution = new NumberOfIslands();
 
        System.out.println(solution.findNumberofClusters(matrix));
        System.out.println(solution.findNumberofClusters(map));
	}

	public int findNumberofClusters(int[][] matrix){
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count = 0;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if ((matrix[i][j] == 1) && (!visited[i][j])) {
					count +=1;
					explore(matrix, i, j, visited);
				}
			}
		}
		return count;
	}
	
	private void explore(int[][] matrix, int i, int j, boolean[][] visited){
		if (visited[i][j]) {
			return;
		}
		visited[i][j]=true;

		int xDir, yDir;

		for (int x=0; x<offsets.length; x++) {
			xDir=offsets[x];
			for (int y=0; y<offsets.length; y++) {
				yDir=offsets[y];
				if (xDir==0 && yDir==0) {
					continue;
				}
				if (neighborExists(matrix, i+xDir,j+yDir)) {
					explore(matrix, i+xDir,j+yDir,visited);
				}
			}
		}
	}

	private boolean neighborExists(int[][] matrix, int i, int j){
		if (i >=0 && (i<matrix.length) && (j>=0) && (j<matrix[0].length)) {
			if (matrix[i][j]==1) {
				return true;
			}
		}
		return false;
	}
}
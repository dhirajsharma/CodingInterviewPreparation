public class MaximumSizeSquareSubmatrixWithAllOnes {
	
	public static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxSize = 0;
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] table = new int [row][col];

		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (i==0 || j==0) {
					table[i][j] = matrix[i][j];
					maxSize = table[i][j] > maxSize ? table[i][j]:maxSize;
				} else if (matrix[i][j] == 0) {
					table[i][j] = 0;
				} else {
					table[i][j] = Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j-1]))+1;
					//table[i][j] = min(table[i-1][j-1], table[i][j-1], table[i-1][j])+1;
					maxSize = table[i][j] > maxSize ? table[i][j]:maxSize;
				}
			}
		}
		return maxSize;
	}

	public static int min(int a, int b, int c) {
		return a<=b && a<=c ? a : (b<=a && b<=c ? b : c);
	}

	public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 1, 0, 1, 1 },
                           { 1, 1, 0, 1, 1, 1 },
                           { 0, 1, 1, 1, 0, 0 },
                           { 1, 1, 1, 1, 0, 0 },
                           { 1, 1, 1, 1, 1, 0 },
                           { 0, 1, 1, 1, 0, 1 }
                         };
        System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
    }
}
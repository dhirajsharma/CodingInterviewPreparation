public class MaximumSizeSquareSubmatrixWithAllOnes{
	public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 1, 0, 1, 1 },
                           { 1, 1, 1, 1, 1, 1 },
                           { 0, 1, 1, 1, 1, 1 },
                           { 1, 1, 1, 1, 1, 1 },
                           { 1, 1, 1, 1, 1, 1 },
                           { 0, 1, 1, 1, 1, 1 }
                         };
        System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
    }

    public static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix){
    	if (matrix == null || matrix.length == 0) {
    		return 0;
    	}

    	int i, j, iEnd = matrix.length-1, jEnd = matrix[0].length-1, size = 0;
    	
    	int helper[][] = new int[iEnd+1][jEnd+1];

    	for (i = 0; i <= iEnd; i++) {
    		for (j = 0; j <= jEnd; j++) {
    			if (i == 0 && j == 0 && matrix[i][j] == 1) {
    				helper[i][j] = 1;
    			}else if (i == 0 && j > 0 && matrix[i][j] == 1) {
    				helper[i][j] = 1;
    			}else if (i > 0 && j == 0 && matrix[i][j] == 1) {
    				helper[i][j] = 1;
    			}else if (matrix[i][j] == 1) {
	    			helper[i][j] = Math.min(helper[i-1][j-1], Math.min(helper[i-1][j], helper[i][j-1])+1)+1;
    			}
    		}
    	}
    	for (i = 0; i <= iEnd; i++) {
    		for (j = 0; j <= jEnd; j++) {
    			System.out.print(helper[i][j]);
    			size = Math.max(size, helper[i][j]);
    		}
    		System.out.println();
    	}
    	return size;
    }
}
import java.util.*;

public class PrintMatrixDiagonally{
	public static void main(String[] args) {
		int row = 5, col = 5;
        int k = 1;
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = k++;
            }
        }

        System.out.println("Input Matrix");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        printMatrixDiagonally(matrix);
	}

	public static void printMatrixDiagonally(int[][] matrix){
		int row, col, rowCount = matrix.length, columnCount = matrix[0].length;

		for (int k=0; k<rowCount; k++) {
			for (row=k, col=0; row>=0 && col<columnCount; row--, col++) {
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}

		for (int k=1; k<rowCount; k++) {
			for (row=rowCount-1, col=k; row>=0 && col<columnCount; row--,col++) {
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
	}
}
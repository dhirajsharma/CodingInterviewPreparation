public class RotateMatrix{

	public static void main(String[] args) {
		int matrix[][] = new int[][]{{11,12,13,14},
									 {21,22,23,24},
									 {31,32,33,34},
									 {41,42,43,44}};
		
		System.out.println(rotate(matrix));
		System.out.println(matrix[0][0]);
	}
	static boolean rotate(int[][]matrix){
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		int length = matrix.length;
		for (int line = 0; line < length/2; line++) {
			int first = line;
			int last = length-1-line;
			for(int i = first; i< last; i++){
				int offset = i-first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][first];
				matrix[i][last] =top;
			}
		}
		return true;
	}
}
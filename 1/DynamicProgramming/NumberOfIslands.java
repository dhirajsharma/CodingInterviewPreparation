public class NumberOfIslands{

	public static void main(String[] args) {
		int[][] map = new int[][]{// 0 1 2 3 4
									{0,1,0,0,0}, // i = 0
									{0,1,0,0,1}, // i = 1
									{1,0,0,1,1}, // i = 2
									{0,0,0,0,0}, // i = 3
									{1,0,1,0,1}  // i = 4
								};
		//boolean[][]visited = new int[map.length][map.length];
		int islands = 0;
		System.out.println(map.length);
		NumberOfIslands num = new NumberOfIslands();
		System.out.println(num.count(map, islands));
	}

	static int count(int[][] map, int islands){
		for(int i =0; i< map.length-1; i++){
			for (int j = 0; j< map[0].length-1; j++) {
				if (map[i][j]==1) {
					if (i==0 && j==0) {
						System.out.println("i: "+i+" j: "+j);
						islands++;
					}else if (i == 0 && j<= map[0].length-1) {
						if (map[i][j-1] != 1) {
							System.out.println("i: "+i+" j: "+j);
							islands++;
						}
					}else if (j == 0 && i<= map.length-1) {
						if (map[i-1][j] != 1 && map[i-1][j+1] != 0) {
							System.out.println("i: "+i+" j: "+j);
							islands++;
						}
					}else if (i <= map.length-1) {
						if (i+1 <= map[0].length-1 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1 && map[i-1][j+1] != 0) {
							System.out.println("i: "+i+" j: "+j);
							islands++;
						}
					}else if (j <= map[0].length-1) {
						if (j+1 <= map[0].length-1 && map[i][j-1] != 1 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i-1][j+1] != 0) {
							System.out.println("i: "+i+" j: "+j);
							islands++;
						}
					}
				}
			}
		}
		return islands;
	}
}
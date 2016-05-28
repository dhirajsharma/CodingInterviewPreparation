class Dp{
	char array1[] = new char[10];
	char array2[] = new char[10];
	//char seq[] = new char[10];
	

	public int lcs(char array1[],char array2[]){
		int maxVal = 0;
		int temp[][] = new int[array1.length+1][array2.length+1];
		for (int i=1; i<=array1.length; i++) {
			for (int j=1; j<=array2.length; j++) {
				if(array1[i-1] == array2[j-1]){
					//System.out.println("temp " + temp[i-1][j-1]);
					temp[i][j] = temp[i-1][j-1]+1;
					maxVal = temp[i][j];
					System.out.println("in " + array1[i-1] + " : " + array2[j-1] +" : "+i+":"+j+" : "+ temp[i][j-1] +":"+temp[i-1][j]+" : "+maxVal);
				}else{
					temp[i][j] = max(temp[i][j-1], temp[i-1][j]);
					maxVal = temp[i][j];
					System.out.println("out " +array1[i-1] + " : " + array2[j-1] +" : "+i+":"+j+" : "+temp[i][j-1]+":"+temp[i-1][j]+" : "+maxVal);
				}
			}
			System.out.println("-----------------");
		}
		return maxVal;
	}

	public int max(int a, int b){
		if (a<b) {
			return b;
		}else if(b<a){
			return a;
		}else{
			return b;
		}
	}

	public static void main(String[] args) {
		Dp dp = new Dp();
		
		char array2[] = "BDCABA".toCharArray();
		char array1[] = "ABCBDAB".toCharArray();
		int result = dp.lcs(array1,array2);
		System.out.println("Result : "+result);
		
		/*char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdemf".toCharArray();
        System.out.println(dp.lcs(str1, str2));*/

		
	}
}
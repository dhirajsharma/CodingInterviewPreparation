class Fact{
	int facto[] = new int[10];
	public int fact(int n){
		if(n==0) return 1;
		else if(n==1) return 1;
		else if(facto[n]!=0) return facto[n];
		else return facto[n]=n*fact(n-1);
	}	
	public static void main(String[] args){
		Fact fc = new Fact();
		System.out.println(fc.fact(8));	
	}
}

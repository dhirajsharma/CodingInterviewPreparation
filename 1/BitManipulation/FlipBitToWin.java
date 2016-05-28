public class FlipBitToWin{

	public static void main(String[] args) {
		int[] bits = {1,1,0,1,1,1,0,1,1,1,1};
		System.out.println(java.util.Arrays.toString(bits));

		System.out.println(check(bits, 0));		
	}

	static char[] check(int[] bits, int start){
		int onesCount = 0, zeroCount = 0;

		StringBuilder onesArray = new StringBuilder();

		for (int i=start; i<bits.length; i++) {
			if (bits[i] == 1 && onesCount == 0 && zeroCount < 2) {
				onesCount++;
				onesArray.append(1);
			}else if (bits[i] == 0 && zeroCount < 2) {
				zeroCount++;
				onesArray.append(1);
			}
		}
		return onesArray.toString().toCharArray();
	}
}
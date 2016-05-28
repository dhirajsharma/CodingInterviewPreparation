public class PowerOfNumber {
	public static void main(String[] args) {
		System.out.println(power(2,4));
	}

	public static int power(int a, int b) {

		if (b==0) {
			return 1;
		}
		if (a==0) {
			return 0;
		}
		if (b<0) {
			return 1/power(a,b);
		}
		if (b%2 == 0) {
			return power(a, b/2)*power(a,b/2);
		}else {
			return a*power(a,(b-1)/2)*power(a,(b-1)/2);
		}
	}
}
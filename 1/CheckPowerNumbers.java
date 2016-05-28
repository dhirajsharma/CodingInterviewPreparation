public class CheckPowerNumbers {

	CheckPowerNumbers(int number){
		System.out.println(isPower(number));
	}

	public boolean isPower(int number){
		int factor = 2;
		while(factor <= Math.sqrt(number)){
			while(number%factor == 0){
				number = number/factor;
			}
			if (number == 1) {
				return true;
			}else{
				factor++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int number = 626;
		CheckPowerNumbers check = new CheckPowerNumbers(number);
	}
}
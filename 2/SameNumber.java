public class SameNumber{

	public static void main(String[] args) {
		int []numbers = {4,4,5,5,4};

		SameNumber sm = new SameNumber();
		System.out.println(sm.check(numbers));
	}

	public boolean check(int numbers[]){
		int ele1 = 0, ele2 = 0;
		int count1 = 0;
		int count2 = 0;

		for(int i = 0; i < numbers.length; i++){
			if (i == 0) {
				ele1 = numbers[i];
				count1++;
			}else if(i == 1){
				if (numbers[i] == ele1) {
					count1++;
				}else{
					ele2 = numbers[i];
					count2++;
				}
			}else if (numbers[i] == ele1) {
				count1++;
			}else{
				if (ele2 == 0) {
					ele2 = numbers[i];
					count2++;
				}else if(numbers[i] == ele2){
						count2++;
				}else{
					return false;
				}
			}
			System.out.println(i);
		}

		System.out.println(count1 + " "+ count2);
		if ((count1 == 3 && count2 == 2) || (count1 == 2 && count2 == 3)) {
			return true;
		}else{
			return false;
		}
	}
}
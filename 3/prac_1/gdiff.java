import java.io.*;
class gdiff{
	public static void main(String agrs[]){
		int array[] = {5,8,5,6,1};
		int gd = 0;

		for(int ele : array){
			for(int eles: array){
				int d = (eles-ele);
				if(d > gd){
					gd = d;
				}
			}
		}
		System.out.println("GD 1 : "+gd);

		for(int i=0; i<array.length; i++){
			for(int j=1; j<array.length;j++){
				int d = array[i]-array[j];
				if(d > gd){
					gd = d;
				}
			}
		}
		System.out.println("GD 2 : "+gd);

		for (int needle=0; needle < 10; needle++) {
			boolean hasBeenSeen = false;
			for (int number : array) {
			    if (number == needle) {
				if (hasBeenSeen) {
				    System.out.println(number);
				} else {
				    hasBeenSeen = true;
				}
			    }
			}
		}

		String name = "Dhiraj Kumar Sharma";
		char[] newname = name.toCharArray();
		outerloop:{
			for(int i=0;i<newname.length;i++){
				for(int j=i+1;j<newname.length;j++){
					if(newname[j]==newname[i]){
						System.out.println("Not unique");
						break outerloop;
					}
				}
			}
			System.out.println("Unique");
		}
		
		boolean[] char_set = new boolean[256];
		for(int i=0; i<name.length();i++){
			int val = name.charAt(i);
			if(char_set[val]){
				System.out.println("Match Found");					
				break;
			}else{
				char_set[val]=true;
				
			}
		}

		for(int i=newname.length-1; i>=0; i--){
			System.out.print(newname[i]); 
		}
		System.out.println("");

		"Tea" "Eat" "Ate"

	}
}

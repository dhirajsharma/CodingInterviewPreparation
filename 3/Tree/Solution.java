// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X) {
        // write your code in Java
        String strNum = Integer.toString(num);
        List<Integer> sumList = new ArrayList<Integer>();
        char[] charNum = strNum.toCharArray();

        String charStr = "";
        String addingStr = "";
        for (int i =0; i<charNum.lenght; i++) {
        	charStr ="";
        	for (int j=0;j<charNum.lenght ;j++ ) {
        		if(i==j){
        			addingStr = String.valueOf(charNum[j]);
        			charStr += addingStr + addingStr;
        		}else{
        			
        		}
        	}
        }

    }
}
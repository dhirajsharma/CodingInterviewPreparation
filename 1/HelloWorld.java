import java.util.*;

public class HelloWorld{
    //public static String[] array = 

     public static void main(String []args){
        //System.out.println("Hello World");
        
        HelloWorld hw = new HelloWorld();
        
        //System.out.println(hw.areMergeable("sharmadhpraj", "dhiraj", "sharma"));

        //System.out.println(hw.lengthOfTheShortestPath(99, 144));

        System.out.println(hw.test("abcdabcdeababcdef"));
     }
     
     static int areMergeable(String input, String part1, String part2){
         part1 = part1 + part2;

         
         if(input.length() != part1.length()){
             return 0;
         }else{
            char[] a = part1.toCharArray();
            char[] b = input.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a,b)) {
                return 1;
            }
            return 0;
         }
     }

     static int test(String str){

        char[] ch = str.toCharArray();
//        System.out.println(ch.toString());
        int i =0;
        int j =1;

        List<String> list = new ArrayList<String>();
        String t="";
        while(i<ch.length-1){
            if (ch[i]<ch[j]) {
                if (t=="") {
                    t += String.valueOf(ch[i])+String.valueOf(ch[j]);                    
                }else{
                    t +=String.valueOf(ch[j]);
                }

                i++;
                j++;
            }else{
                
                if(!t.equals(null)){
                   list.add(t);
                }
                t="";
                i++;
                j++;
            }
        }
        list.removeAll(Collections.singleton(""));
        System.out.println(list.toString());
        return list.size();
     }

     static int lengthOfTheShortestPath(int number1, int number2){
        int num = number2 - number1;
        int diff = Math.abs(num);

        char[] num1 = Integer.toString(number1).toCharArray();
        char[] num2 = Integer.toString(number2).toCharArray();

        Arrays.sort(num1);
        Arrays.sort(num2);

        int i = diff/5;

        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        System.out.println(i);

        return sum(number1, number2, i);
     }

     static int sum(int number1, int number2, int i){
        int count = 0;
        if ((number1 == number2) || (i == 0)) {
            return count;
        }else{
            number1 += i;
            //i -= i;
            count++;
            sum(number1, number2, i);
            return count;
        }
     }
     
}
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		int[] array = {1, 101, 2, 3, 100, 4, 5};
		int len = array.length;
		System.out.println(smss(array, len));
	}
	
	static int smss(int[] array, int len){
	    
	    int i,j,max=0;
	    int maxArr[] = new int[len];
	    
	    for(i = 0;i<len;i++){
	        maxArr[i]=array[i];
	    }
	    
	    for(i = 1; i< len; i++){
	        for(j = 0; j < i; j++){
	            if((array[i]>array[j])&&(maxArr[i]<maxArr[j]+array[i])){
	                maxArr[i] = maxArr[j]+array[i];
	            }
	        }
	    }
	    for(i = 0; i < len; i++){
	        if(max < maxArr[i]){
	            max = maxArr[i];
	        }
	    }
	    return max;
	}
}
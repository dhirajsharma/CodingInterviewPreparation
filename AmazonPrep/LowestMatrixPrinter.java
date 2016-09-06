import java.util.Scanner;
import java.util.regex.Pattern;


public class LowestMatrixPrinter {

    public static void main(String[] args) {
        
        
        /*int cityWidth=5;
        int cityLength=7;
        int[] xCordinates ={2,4};
        int[] yCordinates={3,7};*/
    
        int cityWidth=3;
        int cityLength=5;
        int[] xCordinates ={1};
        int[] yCordinates={1};

        printMatrix(cityWidth,cityLength,xCordinates,yCordinates);
        
        
    }

    private static void printMatrix(int cityWidth, int cityLength,
            int[] xCordinates, int[] yCordinates) {
        
        for(int i=0;i<cityLength;i++){
            for(int j=0;j<cityWidth;j++){
                int lockDistance=findNearestLocker(i,j,xCordinates,yCordinates);
                System.out.print(lockDistance +" ");
            }
            System.out.println();
        }
        
        
    }

    private static int findNearestLocker(int i, int j, int[] xCordinates,
            int[] yCordinates) {
        int totalLocker= xCordinates.length;
        int distance=Integer.MAX_VALUE;
        for(int l=0;l<totalLocker;l++){
            int x=xCordinates[l];
            int y =yCordinates[l];
            int tempDistance=Math.abs(x-j-1)+Math.abs(y-i-1);
            if(distance>tempDistance){
                distance=tempDistance;
            }
        }
        return distance;
    }

}
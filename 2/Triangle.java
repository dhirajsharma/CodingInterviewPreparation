import java.util.*;
import java.io.*;

public class Triangle{

	private float sideA, sideB, sideC;

	private void draw() throws IOException{
		System.out.print("Enter sides of Triangle: ");

		DataInputStream stdIn = new DataInputStream(System.in);

		String user_response = "y";
		while(!user_response.equals("n")){
			System.out.print("\nEnter Side A: ");
			sideA = Integer.parseInt(stdIn.readLine());
			System.out.print("\nEnter Side B: ");
			sideB = Integer.parseInt(stdIn.readLine());
			System.out.print("\nEnter Side C: ");
			sideC = Integer.parseInt(stdIn.readLine());

			if (isPossible(sideA,sideB,sideC)) {
				System.out.print("\n"+triangleType(sideA, sideB,sideC));
			}else{
				System.out.print("\nGiven sides cannot form a Triangle");
			}

			System.out.print("\nDo you want to continue? y/n: ");
			user_response = stdIn.readLine();
		}
/*		this.sideA = scn.nextFloat();
		this.sideB = scn.nextFloat();
		this.sideC = scn.nextFloat();
*/
/*		if (isPossible(sideA,sideB,sideC)) {
			System.out.println(triangleType(sideA, sideB,sideC));
		}else{
			System.out.println("Given sides cannot form a Triangle");
		}*/
	}

	private String triangleType(float sideA, float sideB, float sideC){
		if (equilateral(sideA,sideB,sideC)) {
			return "Equilateral Triangle";
		}else if (rightAngle(sideA,sideB,sideC)) {
			if (issoceles(sideA,sideB,sideC)) {
				return "Issoceles Right Triangle";
			}else{
				return "Scalar Right Triangle";
			}
		}else if (issoceles(sideA,sideB, sideC)) {
			return "Issoceles Triangle";
		}else{
			return "Scalar Triangle";
		}
//		return null;
	}

	private boolean equilateral(float sideA, float sideB, float sideC){
		if (sideA == sideB && sideB == sideC) {
			return true;
		}else{
			return false;
		}
//			return false;
	}

	private boolean rightAngle(float sideA, float sideB, float sideC){
		float sumAB = (sideA*sideA) + (sideB*sideB);
		float sumAC = (sideA*sideA) + (sideC*sideC);
		float sumBC = (sideB*sideB) + (sideC*sideC);
		float sqrA = sideA*sideA;
		float sqrB = sideB*sideB;
		float sqrC = sideC*sideC;

		if (sumAB == sqrC) {
			return true;
		}else if (sumBC == sqrA) {
			return true;
		}else if (sumAC == sqrB) {
			return true;
		}else{
			return false;
		}
//		return null;
	}

	private boolean issoceles(float sideA, float sideB, float sideC){
		if (sideA == sideB || sideA == sideC || sideB == sideC) {
			return true;
		}else{
			return false;
		}
//		return null;
	}

	private boolean isPossible(float sideA, float sideB, float sideC){
		if (((sideA + sideB) > sideC) || ((sideA + sideC) > sideB) || ((sideA + sideC) > sideA)) {
			return true;
		}else{
			return false;
		}
//		return null;
	}

	public static void main(String []args) throws IOException{
		Triangle triangle = new Triangle();
		triangle.draw();
	}
}
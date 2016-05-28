import java.util.*;
import java.util.ArrayList;

public class Heapp{

	private List<Integer> heapData = new ArrayList<Integer>();
	private int maxSize;
	private int items = 0;
	Iterator heapIter = heapData.iterator();
		
	public void insert(int num){
		heapData.add(num);
		printHeap();
		setupHeap();
	}

	public void setupHeap(){
			for (int i = 0, j = 1; i <= ((heapData.size()/2-1)) && j <= (heapData.size()); i++, j+=2) {
				if (heapData.get(i) < heapData.get(j)) {
					int temp = heapData.get(i);
					heapData.set(i, heapData.get(j));
					heapData.set(j,temp);
				}
				if ((i < heapData.size()/2 -1) && (heapData.get(i) < heapData.get(j+1))) {
					int temp = heapData.get(i);
					heapData.set(i, heapData.get(j+1));
					heapData.set(j+1,temp);
				}
			}
	}

	public void printHeap(){
		System.out.println(heapData.toString());
	}

	public void remove(int ele){
		if(findElement(ele)){
			heapData.remove(heapData.indexOf(ele));
			setupHeap();
		}else{
			System.out.println("Element not in heap");
		}
	}

	public boolean findElement(int ele){
		if(heapData.contains(ele)){
			return true;
		}else{
			return false;
		}
	}

	public int findMinElement(){
		List<Integer> tempHeap = new ArrayList<>(heapData);
		Collections.sort(tempHeap);
		return tempHeap.get(0);
	}

	public int findMax(){
		return heapData.get(0);
	}

	/*public int findMin(){
		
	}*/

	public static void main(String[] args) {
		Heapp heapp = new Heapp();
		heapp.insert(20);
		heapp.insert(80);
		heapp.insert(37);
		heapp.insert(35);
		heapp.insert(58);
		heapp.insert(49);
		heapp.insert(32);
		heapp.insert(14);
		heapp.insert(30);
		heapp.insert(28);
		heapp.insert(45);
		heapp.insert(22);
		
		System.out.println("-------Final Heap-------");
		heapp.printHeap();
		System.out.println("-------Final after removing 49 -------");
		heapp.remove(49);
		System.out.println("-------Final after Heap-------");
		heapp.printHeap();
		System.out.println("-------Max of Heap-------"+heapp.findMax());
		System.out.println("-------Max of Heap-------"+heapp.findMinElement());
		System.out.println("-------Final after Heap-------");
		heapp.printHeap();
	}
}
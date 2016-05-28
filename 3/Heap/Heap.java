import java.util.*;
public class Heap {

	// Formula

	/*leftChild = 2*pos + 1 
	rightChild = 2*pos + 2

	0 -> 1,2
	1 -> 3,4

	9 -> 19, 20

	parent = (pos-1)/2

	2 -> 0
	19 -> 9
	20 -> 9*/

	List<Integer> heapData = new ArrayList<Integer>();

	Map<Integer, ArrayList<Integer>> tasksPool = new HashMap<Integer, ArrayList<Integer>>();
	
	public void addElement(int num){
		heapData.add(num);
		int child = heapData.size() - 1;
		
		setHeap(child);
	}

	public  void setHeap(int child){
		if (child != 0) {
			int parent = (child - 1)/2;

			if (heapData.get(child) < heapData.get(parent)) {
				int bufferValue = 	heapData.get(child);
				heapData.set(child, heapData.get(parent));
				heapData.set(parent, bufferValue);	
			}
			child = parent;
			setHeap(child);
		}
	}

	public void removeHeap(){
		int parent = 0;
		heapData.set(parent, heapData.get(heapData.size()-1));
		heapData.remove(heapData.size()-1);
		setRemove(parent);

	}

	public void setRemove(int parent){
		int leftChild = 2*parent+1;
		int rightChild = 2*parent+2;
		if (leftChild < heapData.size()-1) {
			boolean goLeft = (heapData.get(leftChild) < heapData.get(parent));
			boolean goRight = (heapData.get(rightChild) < heapData.get(parent));
			
			if (goLeft) {
				int bufferValue = heapData.get(parent);
				heapData.set(parent,heapData.get(leftChild));
				heapData.set(leftChild, bufferValue);
				parent = leftChild;
				setRemove(parent);
			}else if (goRight) {
				int bufferValue = heapData.get(parent);
				heapData.set(parent,heapData.get(rightChild));
				heapData.set(rightChild, bufferValue);
				parent = rightChild;
				setRemove(parent);		
			}
		}else if (parent > heapData.size()-1) {
			parent = (parent-1)/2;
			setRemove(parent);
		}else if (leftChild > (heapData.size()-1)) {
			parent = (parent-3)/4;
			setRemove(parent);
		}else{
			parent = 0;
			setRemove(parent);
		}
	}

	public void showHeap(){
		System.out.println(heapData.toString());
	}

	public int peekHeap(){
		int peekValue = heapData.get(0);
		return peekValue;
	}

	public void addInQueue(int priority, int task){
		ArrayList<Integer> taskList = new ArrayList<Integer>();			
		if (tasksPool.isEmpty()) {
			taskList.add(task);
			tasksPool.put(priority, taskList);
			addElement(priority);
		}else{
			if (tasksPool.get(priority) != null) {
				taskList = tasksPool.get(priority);
				taskList.add(task);
				tasksPool.put(priority, taskList);
				addElement(priority);
			}else{
				taskList.add(task);
				tasksPool.put(priority,taskList);
				addElement(priority);
			}
		}
	}

	public void showQueue(){
		System.out.println(tasksPool);
	}

	public int getPeekTask(int priority){
		ArrayList<Integer> tasks = tasksPool.get(priority);
		int peekTask = tasks.get(0);
		return peekTask;
	}

	/*public Array peek(){
		int peek = peekHeap();
		int task = getPeekTask(peek);
		Array peekTask = new Array(2);
		System.out.println("Task: "+ task +" | Priority: "+peek);
	}*/

	public int getPeekPriority(){
		int peek = peekHeap();
		return peek;
	}

	public void peek(){
		int peek = getPeekPriority();
		int task = getPeekTask(peek);
		System.out.println("Task: "+ task +" | Priority: "+peek);
	}

	public void removePriorityTask(){
		int peek = getPeekPriority();
		int task = getPeekTask(peek);
		ArrayList<Integer> tasks = tasksPool.get(peek);
		tasks.remove(0);
		if (tasks.size()==0) {
			tasksPool.remove(peek);
		}
		removeHeap();
	}

	public static void main(String[] args) {
		Heap heap = new Heap();
		
		heap.addInQueue(10, 50);
		heap.addInQueue(8, 70);
		heap.addInQueue(10, 40);
		heap.addInQueue(8, 20);
		heap.addInQueue(3, 50);
		heap.addInQueue(2, 70);
		heap.addInQueue(1, 50);
		heap.addInQueue(4, 70);
		heap.addInQueue(1, 50);
		heap.addInQueue(3, 70);
		heap.addInQueue(17, 50);
		heap.addInQueue(8, 20);

		
		System.out.println("---------------------------------------------------------------------------------------");
		heap.showQueue();
		heap.showHeap();
		System.out.println("---------------------------------------------------------------------------------------");
		heap.peek();
		heap.removePriorityTask();
		System.out.println("---------------------------------------------------------------------------------------");
		heap.showQueue();
		heap.showHeap();
		System.out.println("---------------------------------------------------------------------------------------");
		
		heap.peek();
		heap.removePriorityTask();
		
		System.out.println("---------------------------------------------------------------------------------------");
		heap.showQueue();
		heap.showHeap();
		System.out.println("---------------------------------------------------------------------------------------");
		heap.peek();
		heap.removePriorityTask();
		System.out.println("---------------------------------------------------------------------------------------");
		heap.showQueue();
		heap.showHeap();
		System.out.println("---------------------------------------------------------------------------------------");		

		
		/*heap.addElement(10);
		heap.addElement(8);
		heap.addElement(10);
		heap.addElement(8);
		heap.addElement(3);
		heap.addElement(2);
		heap.addElement(1);
		heap.addElement(4);
		heap.addElement(1);
		heap.addElement(3);
		heap.addElement(17);
		heap.addElement(8);
		
		heap.showHeap();
/*		heap.removeHeap();
		heap.showHeap();
		heap.removeHeap();
		heap.showHeap();*/
		/*
		heap.removeHeap();
		
		heap.showHeap();*/	
	}

}

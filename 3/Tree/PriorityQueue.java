import java.util.*;
public class PriorityQueue{

	List<Integer> priorityQueue = new ArrayList<Integer>();
	
	LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>(Integer, Integer);

	public void addElement(int ele, int priority){
		PQueue pqueue = new PQueue(ele, priority);
		lhm.put(ele,priority);		
		if (priorityQueue == null) {
			priorityQueue.add(ele);
		}else{
			Iterator it = lhm.entrySet().iterator();
			while(it.hasNext){
				LinkedHashMap.Entry pair = (Map.Entry)it.next();
				if (pair.getValue > priority) {
					priorityQueue.add(ele);
				}else{
					int tempKey = pair.getKey();
					

					lhm.put();


				}
			}
		}
		//lhm.put(ele, priority);
		


		if (priorityQueue == null) {
			priorityQueue.add(ele);
		}else{
			for (int i =0; i<lhm.size()-1; i++) {
				if () {
					int temp = 
				}
			}
		}
		
	}
	
/*	public void printPriorityQueue(){
		pqueue
	}*/

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.addElement(10, 1);
		pq.addElement(15, 2);
		pq.addElement(11, 1);
		pq.addElement(5, 0);
		pq.addElement(4, 0);
		pq.addElement(12, 2);
		pq.addElement(4, 3);
		pq.addElement(0, 1);
		
		//	pq.printPriorityQueue();	
	}
}

class PQueue{
	int element;
	int priority;

	PQueue(int element, int priority){
		this.element = element;
		this.priority = priority;
	}

	public String toString(){
		return element+" : "+priority;
	}
}
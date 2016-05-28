import java.util.*;
public class NthMostFrequentNumber {
	public static void main(String[] args) {
		int[] numberArray = {1,5,2,2,2,2,3,3,4,4,4,5,6,6,6};
		int n = 3;
		System.out.println(findNumber(numberArray, n));
	}

	public static int findNumber(int[] numberArray, int n) {
		Map<Integer, Integer> unSortedMap = new HashMap<Integer, Integer>();
		if (numberArray == null || numberArray.length == 0 || numberArray.length < n) {
			System.out.println("Invalid input");
			return -1;
		}
		for (int value : numberArray) {
			if (unSortedMap.isEmpty()) {
				unSortedMap.put(value, 1);
			}else if (unSortedMap.containsKey(value)) {
				unSortedMap.put(value, unSortedMap.get(value)+1);
			}else{
				unSortedMap.put(value, 1);
			}
		}
		
		System.out.println(unSortedMap.toString());
		System.out.println(sortByValue(unSortedMap).toString());
		return Integer.MAX_VALUE;
	}

	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
}
class ValueComparator implements Comparator {
	Map map;

	public ValueComparator(Map map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}
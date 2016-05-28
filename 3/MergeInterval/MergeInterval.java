public class MergeInterval{
	public ArrayList<Interval> merge(ArrayList<Interval> intervals){
		if (intervals.size() == 0) {
			return intervals;
		}
		if (intervals.size() == 1) {
			return intervals;
		}

		Collections.sort(intervals, new IntervalComparator());

		Interval first = intervals.get(0);
	}
}

class IntervalComparator implements Comparator{
	public int compare(Object obj1, Object obj2){
		Interval i1 = (Interval)obj1;
		Interval i2 = (Interval)obj2;

		return i1.start - i2.start;
	}
}
import java.util.*;
import java.lang.*;
public class Array{
	public static String firstNode(String str){
		HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
		Object seenOnce = new Object();
		Object seenMultiple = new Object();
		Object seen;
		int i;
		final int length = str.length();
		for (i=0; i<length; ) {
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);			
			seen = charHash.get(cp);
			if (seen == null) {
				charHash.put(cp, seenOnce);
			}else{
				if (seen == seenOnce) {
					charHash.put(cp, seenMultiple);
				}
			}
		}

		for (i=0; i<length; ) {
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			if (charHash.get(cp) == seenOnce) {
				//System.out.println(Character.toChars(cp));
				String st = new String(Character.toChars(cp));
				System.out.println(st);
				break;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		Array array = new Array();
		array.firstNode("title");
	}
}
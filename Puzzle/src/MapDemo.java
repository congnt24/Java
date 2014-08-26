//import java.awt.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
//
//public class MapDemo {
//
//	public static void main(String[] args) {
//		HashMap<String, Integer> h = new HashMap<String, Integer>();
//		h.put("z",30);
//		h.put("e",10);
//		h.put("b",20);
//		h.put("c",20);
//		ArrayList<Entry> a = new ArrayList<Map.Entry>(h.entrySet());
//		Collections.sort(a,
//		         new Comparator() {
//		             public int compare(Object o1, Object o2) {
//		                 Map.Entry e1 = (Map.Entry) o1;
//		                 Map.Entry e2 = (Map.Entry) o2;
//		                 return ((Comparable) e1.getValue()).compareTo(e2.getValue());
//		             }
//		         });
//
//		for (Map.Entry e : a) {
//		        System.out.println(e.getKey() + " " + e.getValue());
//		}
//	}
//
//}

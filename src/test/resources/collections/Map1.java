package collections;

public class Map1 {
	static void test() {
		java.util.Map map = new java.util.HashMap();
		if (map.containsKey("foo")) {
			Object value = map.get("foo");
		}
		for (Object value : map.values()) {
		}
		for (Object key : map.keySet()) {
		}
		Object removed = map.remove("foo");
		map.put("foo", "bar");
	}
	
	static java.util.Map genericSortedMap() {
		return new java.util.TreeMap<String, String>();
	}
	
	static java.util.Map sortedMap() {
		return new java.util.TreeMap();
	}
}
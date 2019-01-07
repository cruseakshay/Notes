import java.util.SortedMap;
import java.util.TreeMap;

public class WTreeMap{
    public static void main(String[] args) {
      // Which line will throw exception at runtime ?
      TreeMap<String, String> map = new TreeMap<String, String>(); 
      map.put("a", "apple");
      map.put("e", "eggs");
      map.put("g", "gear");
     
      SortedMap<String, String> smap = map.subMap("a", "e"); // Find out more about subMap().
      smap.put("b", "ball");
      smap.put("f", "fish");
      map.put("c", "cat");
      map.remove("a");
      System.out.println(smap);
      System.out.println(map);
    }
}
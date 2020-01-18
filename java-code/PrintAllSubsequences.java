import java.util.*;
class PrintAllSubsequences {


  public static void main(String [] args) {

    String s = "abcd";

    Set<String> set = new HashSet<String>();

    String b ="";

    set.add(b);

    Set<String> tset = new HashSet<>();
    for(int i=0;i<s.length();i++) {
      for(String str: set) {
         tset.add(str+s.charAt(i));


      }
      set.addAll(tset);

    }

    for(String str: set) {
      System.out.print(str+ " ");
    }
    System.out.print(set.size());

  }


}

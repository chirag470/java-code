
import java.util.*;
class SubstringWithAllVowels {
    public static void main(String[] args) {


        String s;

        int i=0;
        int count=0;
        Scanner sc = new Scanner(System.in);

              s  = sc.nextLine();

        Set<Character> set  ;//new HashSet<Character>();
        while(i < s.length()) {


          if(isCons(s.charAt(i))) {
            i++;
          } else {

            set = new HashSet<Character>();

            System.out.println(i);
            char ci =  s.charAt(i);
            while(i<s.length() && !isCons(ci)) {

              System.out.println(s.charAt(i));
              set.add(s.charAt(i));

              i++;
              if(i<s.length()) {
                ci = s.charAt(i);
              }

            }
            set.stream().forEach( cl -> {
              System.out.print(cl+" ");

            });
            System.out.println();
            if(set.size() == 5) {
              count++;
            }
          }
        }

        System.out.println(count);



    }

    static boolean isCons(char c) {

      if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u' ) {

        return false;
      }
      return true;
    }

}

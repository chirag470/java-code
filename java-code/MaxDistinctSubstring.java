// string "abcdeagh"
// find longest substring with unique characters
// bcdeagh

//abcdbdefb -> abcd   defb
import java.util.*;

class MaxDistinctSubstring {

    public static void main(String []args) {

Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(getMaxDist(s));

    }


static void initialize(int [] map) {
    //initialize map to 0;
    for(int i=0;i<26;i++) {
        map[i] = 0;
    }
}

 static void printMap(int[] map) {
   for(int i=0;i<26;i++) {
     System.out.print((char)(i+'a'));
     System.out.print(" ");
     System.out.print(map[i]+", ");




   }
 }
static int getMaxDist(String str) {


    int[] map = new int[26];
    initialize(map);

    int win =0;
    int i=0,j=0;

  //  while(i<=j&&j<str.length()) {


        while(j<str.length()) {
            System.out.println(i+" "+j);

            char c = str.charAt(j);
            int ind = c-'a';
            if(map[ind] ==0) {
                map[ind] = 1;
                j++;
            } else{


               if(j-i>win) {
                   win = j-i;

               }

               int k=i;

               while(str.charAt(k)  != c&& k<=j) {
                   char cur = str.charAt(k);
                   map[cur-'a'] = 0;
                   k++;
               }
               char cur = str.charAt(k);
               map[cur-'a'] = 0;
               i=k+1;

               printMap(map);



                //initialize(map);
            }

        }



    //}

    if(j-i>win) {
        win = j-i;
    }
               return win;



}
}

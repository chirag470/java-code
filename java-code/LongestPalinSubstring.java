class LongestPalinSubstring {

public static void main (String[] args) {

String s = "babab";

System.out.println(longestPalindrome(s));
}

    public static String longestPalindrome(String s) {



        int [][]a = new int[s.length()][s.length()];
        //String max = s.substring(0,1);
        int x=0;
        int y =1;
        int max=1;
        for(int j=0;j<a.length;j++) {

          for(int i=j;i>=0;i--) {
System.out.println(i+ ","+j);
System.out.println(max);
                if(i ==j) {
                    a[i][j] = 1;

                } else if (s.charAt(i)==s.charAt(j)&& i==j-1) {
                    a[i][j]=1;
                    if(2 >max){
                          System.out.println(i+ ","+j);
                    x=i;
                    y=j+1;
                    max=2;
                    }
                } else if(s.charAt(i)==s.charAt(j) && a[i+1][j-1]==1){
                    a[i][j] = 1;
                    if(j-i+1 >max){
                        System.out.println(i+ ","+j);
                    x=i;
                    y=j+1;
                    max=j-i+1;
                    }
                }

                else {
                    a[i][j]=0;
                }

               }

            }
        return s.substring(x,y);

        }

}

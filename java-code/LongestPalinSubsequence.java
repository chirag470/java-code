class LongestPalinSubsequence {


public static void main (String[] args) {

String s = "bbbab";

System.out.println(longestPalindromeSubseq(s));
}
    public static int longestPalindromeSubseq(String s) {

        int [][]a = new int[s.length()][s.length()];
        //String max = s.substring(0,1);

        int max=1;
        for(int j=0;j<a.length;j++) {

          for(int i=j;i>=0;i--) {

                if(i ==j) {
                    a[i][j] = 1;

                } else if ( i==j-1 ) {

                    if(s.charAt(i)==s.charAt(j)) {
                         a[i][j]=2;
                        if(max<2) { max=2;}
                    } else {
                        a[i][j]=1;
                    }


                } else if(s.charAt(i)==s.charAt(j)){
                    a[i][j] = a[i+1][j-1]+2;
                    if(a[i][j] >max){

                    max = a[i][j];
                    }
                }

                else {
                    int m = a[i+1][j];
                    if(a[i][j-1] >m) {
                        m = a[i][j-1];
                    }
                    a[i][j]=m;
                    max = m;
                }

               }

            }



        return max;
    }
}

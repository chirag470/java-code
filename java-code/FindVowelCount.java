import java.util.*;
class FindVowelCount {


public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

String str;

str = sc.nextLine();
int q = Integer.parseInt(sc.nextLine());

int[] counts=new int[str.length()+1];
counts [0] = 0;
for (int i=0;i<str.length();i++){
if(str.charAt(i) == 'a'||str.charAt(i) == 'e'||str.charAt(i) == 'i'||str.charAt(i) == 'o'||str.charAt(i) == 'u' ) {

counts[i+1] = counts[i]+1;
} else {
  counts[i+1] = counts[i];
}
}


while(q>0){
q--;

String[] query = sc.nextLine().split(" ");
int a= Integer.parseInt(query[0]);
int b= Integer.parseInt(query[1]);

System.out.println(counts[b+1]-counts[a]);
}
}
}

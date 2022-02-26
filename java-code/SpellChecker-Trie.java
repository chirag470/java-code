public class SpellChecker-Trie {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {

        Trie trie = new Trie();
        for(String inp: A) {
               trie.insert( inp);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<B.size();i++) {
            if(trie.isPresent(B.get(i)))
                res.add( 1);
            else
                res.add( 0);
        }
        return res;
    }


}
class Trie {
    TrieNode root;
    char start = '#';
    Trie() {
 root=       new TrieNode(false, start);
    }

      void insert( String word) {

        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            TrieNode child = curr.a[c-'a'];
            if(child == null) {
                TrieNode newChild  = new TrieNode(false,c);
                curr.a[c-'a'] = newChild;
                curr = newChild;
            } else
                curr = child;
        }
        curr.isValid = true;
    }

    boolean isPresent(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            TrieNode child = curr.a[c - 'a'];
            if(child == null)
                return false;
            else {
                curr = child;
            }

        }
        return curr.isValid;
    }
}
class TrieNode {
    boolean isValid;
    char c;
    TrieNode[] a ;

   TrieNode(boolean isValid, char c) {
        this.isValid = isValid;
        this.c =c ;
        a = new TrieNode[26];
   }

}

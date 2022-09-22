package Tries;

import java.util.ArrayList;

public class TrieUse {

    public static void main(String args[]){
        Trie t = new Trie();

    /*    t.add("NOTE");
        t.add("AND");
        t.add("NOT");

        System.out.println(t.count);
        System.out.println(t.search("NOTE"));
        t.remove("NOTE");
        System.out.println(t.count);
        System.out.println(t.search("NOTE"));
        System.out.println(t.search("NOT"));
    */

        ArrayList<String> arr = new ArrayList<>();

    /*    arr.add("ABC");
        arr.add("DEF");
        arr.add("GHI");
        arr.add("HI");
        System.out.println(t.patternMatching(arr,"DE"));
    */

    /*    arr.add("DO");
        arr.add("DONT");
        arr.add("NO");
        arr.add("NOT");
        arr.add("NODE");
        arr.add("NOTE");
        arr.add("NOTED");
        arr.add("NOTES");
        t.autoComplete(arr,"NO");
     */

     arr.add("ABC");
     arr.add("DEF");
     arr.add("GHI");
     arr.add("CBA");
     System.out.println(t.isPalindromePair(arr));
    }
}

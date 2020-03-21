package com.sample;

import java.util.*;

public class AnagramTest {

    public static void main(String[] args) {
        //findAnagramString ();
        findAnagramStringUsingAPI();
    }

    private static void findAnagramStringUsingAPI() {
        String[] anagrams  = {"act", "cat", "tac", "pot", "top", "aim"};
        Map<Integer, String > result = new HashMap<> (  );
        int i = 0;
        Set<String> foundAnagrams = new HashSet<> (  );
        for (String anagram : anagrams) {
            char[] c = anagram.toCharArray ();
            Arrays.sort ( c );
            String s = new String ( c );
            Optional<Map.Entry<Integer, String>> key = result.entrySet ().stream ().filter ( e -> e.getValue ().equalsIgnoreCase (s)).findAny ();
            if (key.isPresent ()) {
                foundAnagrams.add ( anagrams[key.get ().getKey ()] );
                System.out.println ( "The key and its value is "+i + " Value " + anagrams[i] );
                foundAnagrams.add ( anagrams[i] );
            } else {
                System.out.println ( "The value not there so added to MAP "+s + " index "+i);
                result.put ( i, s );
            }
            i++;
        }
        foundAnagrams.stream ().forEach ( System.out::println );
        //result.entrySet ().stream ().forEach ( e -> System.out.println ( "The key is - "+e.getKey ()+ " And its value -"+e.getValue () ) );
    }

    private static void findAnagramString() {
        String[] anagrams  = {"act", "cat", "tac", "pot", "top", "aim"};
        Map<String, String> res = new LinkedHashMap<> (  );
        String[] anagramBinary = new String[anagrams.length];
        //int i = 0;
        for (String anagram : anagrams) {
            StringBuilder sb = new StringBuilder (  );
            int[] test = new int[26];
            for (char c : anagram.toCharArray ()) {
                test[c - 'a'] = 1;
            }
            Arrays.stream ( test ).forEach ( i -> sb.append ( i ) );
            res.put (anagram, sb.toString () );
            //anagramBinary[i++] = sb.toString ();
        }
        res.keySet ().stream ().forEach ( System.out::println );
        for (String anagram : anagrams) {
            //List<Map.Entry<String,String>> keys =
            //List<String> keys = new ArrayList<> (  );
            Optional<Map.Entry<String,String>> keys = res.entrySet ().stream ().filter ( k -> !k.getKey ().equals (anagram) && k.getValue().equals ( res.get ( anagram ) ) ).findAny ();
            //keys.stream ().forEach (System.out::println);
            if (keys.isPresent ())
                System.out.println ( anagram + " AND its value "+ keys.get ().getValue ());
        }
    }
}

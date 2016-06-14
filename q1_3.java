/**
 * "Design an algorithm and write code to remove the duplicate characters in a string without using
 * any additional buffer NOTE: One or two additional variables are fine. An extra copy of the array
 * is not FOLLOW UP. Write the test cases for this method."
 */

import java.util.Collection;
import java.util.HashSet;
import java.lang.Character;

public class q1_3
{
    /*
     * My original way O(n) --- Use HashSet (additional memory)
     */
    public static String removeDuplicates1(String str){
        Collection<Character> chars = new HashSet<>();
        for(int i = 0; i < str.length(); ++i){
            Character ch = str.charAt(i);
            if(chars.contains(ch)){
                //Not recommend "substring" coz it belongs to addition buffer
                str = str.substring(0, i) + str.substring(i+1);
                i -= 1;
            } else{
                chars.add(ch);
            }
        }
        return str;
    }

    /*
     * Standard answer in the book O(n^2) --- (No additional memory)
     */
    public static void removeDuplicates2(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break; //has dup
            }
            if (j == tail) {  //no dup
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    /*
     * Solution from "http://stackoverflow.com" O(n) --- (No additional memory)
     */
    public static void removeDuplicates3(char[] str) {
        int map = 0;
        for (int i = 0; i < str.length; i++) {
            if ((map & (1 << (str[i] - 'a'))) > 0) // duplicate detected
                str[i] = 0;
            else // add unique char as a bit '1' to the map
                map |= 1 << (str[i] - 'a');
        }
    }

    /*
     * Solution from "http://stackoverflow.com" O(n^2) --- Use StringBuilder (additional memory)
     */
    public static String removeDuplicates4(String s) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

    public static void main(String[] args) {
        String str = "aabbcdggaahdkallcbd";
        System.out.println("Old String: " + str);
        System.out.println("New String: " + removeDuplicates1(str));

        char chars1[] = str.toCharArray();
        removeDuplicates2(chars1);
        System.out.println("New String: " + new String(chars1));

        char chars2[] = str.toCharArray();
        removeDuplicates3(chars2);
        System.out.println("New String: " + new String(chars2));

        System.out.println("New String: " + removeDuplicates4(str));

    }
}

/*
Test:

Old String: aabbcdggaahdkallcbd
New String: abcdghkl
New String: abcdghkl ahdkallcbd
New String: a b cdg   h k l
New String: abcdghkl
 */
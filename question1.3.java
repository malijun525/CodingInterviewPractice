/*
 * "Design an algorithm and write code to remove the duplicate characters in a string without using 
 * any additional buffer NOTE: One or two additional variables are fine. An extra copy of the array 
 * is not FOLLOW UP. Write the test cases for this method."
 */

import java.util.Collection;
import java.util.HashSet;
import java.lang.Character;

public class question1 {
	
	public static String getNewString(String str){
		
		//Using HashSet to check duplicate char
		Collection<Character> chars = new HashSet<>();
		//Using for loop to check all chars
		for(int i = 0; i < str.length(); ++i){
			Character ch = str.charAt(i);
			//If HashSet includes this char, move out from original string, else add to HashSet.
			if(chars.contains(ch)){
				str = str.substring(0, i) + str.substring(i+1);
				i -= 1;
			} else{
				chars.add(ch);
			}
		}
		//Return updated string
		return str;
		
	}

	public static void main(String[] args) {
		String str = "aabbcdggaahdkallcbd";
		System.out.println("Old String: " + str);
		System.out.println("New String: " + getNewString(str));
	}

}

/*
 * Test:
 * Old String: aabbcdggaahdkallcbd
 * New String: abcdghkl
 */

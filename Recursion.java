// Larissa Lemere
// 29/04/16
// Recursive Algorithms
public class Recursion {
	public static void main(String[] args) {
		// main method
		System.out.println(fib(8));
	}
	public static int fib(int n){
		// this method returns the value of the 'n'th term in a fibinacci sequence
		if(n==0){ // if n is at the 0 index term in the sequence...
			return 0; // ...return 0
		}
		else if(n==1){ // otherwise, if it is the first term...
			return 1; //... return 1
		}
		else{ // if the term n is greater than the first term in the fibinacci sequence...
			return fib(n-1)+fib(n-2); // add the previous two digits of the fibinacci seqence to obtain the next in line
			// This recurses down the n terms, going back to 1, and essentially then goes back up the chain of pauses in the method, and adds up all terms until the 'n'th term
		}
	}
	public static String reverse(String s){
		// This method uses recursion to print a word backwards
		char a = s.charAt(s.length()-1); // set a variable equal to the last character in the string
        if(s.length() == 1){// if there is only one character in the string...
        	return Character.toString(a);   //...return the character as a string
        }
        return a + reverse(s.substring(0,s.length()-1)); // return the last character to the front of the string, plus the reverse of the rest of the string
        // this recurses down the string, revering all letters, bringing the last of to the front of the smaller sub string each time
	}
	public static boolean isPalindrome(String s){
		// This method uses recursion to see if a given string is a palindrome or not
		if(s.length()==0){ // if there are either 0  characters in the string (for an even set of numbers)...
			return true; //..return true
		}
		else if(s.length()==1){ // if there is one character in the word...
			return true;//...it technically reflects itself so its true 
		}
		else{
			if(s.charAt(0)==s.charAt(s.length()-1)){ // if the first letter is equal to the last letter (its satisfies palindrome properties)...
				s=s.substring(1, s.length()-1); // set the string equal to the interior(smaller version of itself)
				return isPalindrome(s); // return true if the smaller solution(s) return true
			}
		}
		return false; // if all else fails, return false
	}

}
// la fin

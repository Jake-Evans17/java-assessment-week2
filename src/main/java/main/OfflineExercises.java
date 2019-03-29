package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public static void main(String[] args) {
		OfflineExercises attempt = new OfflineExercises();
		attempt.largest("555 72 86 45 10");
		
		//given a string - return the number of times "am" appears in the String ignoring case -
		// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
		//
		//amISearch("Am I in Amsterdam") → 1
		//amISearch("I am in Amsterdam am I?") → 2
		//amISearch("I have been in Amsterdam") → 0
	}
	
	public String multChar(String input) {
		String y = "";
		for (int i=0; i < input.length(); i++) {
			String letter = input.substring(i,  i+1);
			String x = letter.concat(letter).concat(letter);
			y = y.concat(x);
		}
		return y;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		
		int x = input.toLowerCase().indexOf("bert");
		if (x == -1) {return "";}
		
		String first = input.substring(x + 4);
		
		int y = first.toLowerCase().indexOf("bert");
		if (y == -1) {return "";}
		
		String sec = first.substring(0, y);
		
		int length = sec.length();
		
		String a="";
		for (int i = 0; i < length; i++) {
			String b = sec.substring(length-(i+1), length-i);
			a = a.concat(b);
		}
		
		System.out.println(a);
		return a;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		
		int small = 0;
		int med = 0;
		int big = 0;
		
		if ((a<b)&&(b<c)) {small = a; med = b; big = c;}
		else if ((a<c)&&(c<b)) {small = a; med = c; big = b;}
		else if ((b<c)&&(c<a)) {small = b; med = c; big = a;}
		else if ((b<a)&&(a<c)) {small = b; med = a; big = c;}
		else if ((c<a)&&(a<b)) {small = c; med = a; big = b;}
		else if ((c<b)&&(b<a)) {small = c; med = b; big = a;}
		
		int dif1 = Math.abs(small - med);
		int dif2 = Math.abs(med - big);
		
		if ((dif1 == dif2)) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		
		int len = input.length();
		int halflen = len/2;
		System.out.println(halflen);
		
		if (a % 2 == 0) {
			int b = a/2;
			String first = input.substring(0, halflen - b);
			
			System.out.println(first);
			
			String sec = input.substring(b + halflen);
			
			System.out.println(sec);
			
			String x = first.concat(sec);
			
			System.out.println(x);
			return x;
		} else {
			int b = a/2;
			String first = input.substring(0, halflen-(b));
			
			System.out.println(first);
			
			String sec = input.substring((b+1) + halflen);
			
			System.out.println(sec);
			
			String x = first.concat(sec);
			
			System.out.println(x);
			return x;
		}

	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		
		int length = input.length();
		
		if (length < 3) {return false;}
		
		input = input.substring(length-3, length);
		String x = input.toLowerCase();
		System.out.println(x);
		
		boolean w = false;
		
		if (x.compareTo("dev") == 0) {
			w = true;
			System.out.println(w);
			return true;
		}
		else {
			w = false;
			System.out.println(w);
			return false;
		}

	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int count = 1;
		int x = 0;
		for (int i = 0; i < input.length() - 2; i++) {
			if ((input.substring(i, i+1)).compareTo(input.substring(i+1, i+2)) == 0) {
				count++;
				System.out.println("count: " + count);
				if (count > x) {x=count;}
				
			} else if (count > x) {
				x = count;
				count = 1;
				System.out.println(x);
			} else {
				count = 1;
			}
		}
		System.out.println(x);
		return x;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		
		String beg = arg1.substring(0, 3).toLowerCase();
		int count = 0;
		
		if ((beg.compareTo("am ") == 0) || (beg.compareTo("am,") == 0) || (beg.compareTo("am.") == 0)) {
			count = 1;
		} else {
			count = 0;
		}

		for (int i = 0; i < arg1.length()-4; i++) {
			String x = (arg1.substring(i, i+4)).toLowerCase();
			if (x.compareTo(" am ") == 0) {
				count++;
			}
		}
		
		int len = arg1.length();
		String end1 = arg1.substring(len-3, len).toLowerCase();
		String end2 = arg1.substring(len-4, len).toLowerCase();
		
		if (end1.compareTo(" am") == 0) {
			count++;
		} else if (end2.compareTo(" am.") == 0) {
			count++;
		}
		
		
		
		System.out.println(count);
		return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		if ((arg1 % 3 == 0) && (arg1 % 5 == 0)) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0) {
			return "fizz";
		} else if (arg1 % 5 == 0) {
			return "buzz";
		}
		return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		int len = arg1.length();
		int y = 0;
		String arg2 = "";
		
		for (int i = 0; i < len; i++) {
			String space = arg1.substring(i, i+1);
			if (space.compareTo(" ") == 0) {
				
				String x = arg1.substring(y,i);
				
				//System.out.println(x);
				
				int z = Integer.parseInt(x);
				nums.add(z);
				y = i+1;
				
				arg2 = arg1.substring(y);
			}
		}
		int w = Integer.parseInt(arg2);
		nums.add(w);
		
		int biggest=0;
		
		for (Integer num : nums) {
			int newnum100 = (num/100);
			int newnum10 = (num - newnum100*100)/10;
			int newnum1 = (num - newnum100*100 - newnum10*10);
			int newnum = newnum1 + newnum10 + newnum100;
			System.out.println(newnum);
			if (newnum > biggest) {
				biggest = newnum;
				System.out.println(biggest);
			}
		}
		return biggest;
	}
	
	
}

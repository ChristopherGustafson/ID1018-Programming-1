import java.util.Scanner;

public class OperationsWithStrings {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Mata in två naturliga tal");
		
		String n1 = in.nextLine();
		String n2 = in.nextLine();
		
		System.out.println("Summan av talen är " + add(n1, n2));
		System.out.println("Differansen av talen är " + sub(n1, n2));
		
	}
	
	public static String add(String a, String b) {
		
		int lengthDiff;
		int length = a.length();
		int sum;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		boolean addOne = false;
		
		if(a.length() > b.length()) {
			lengthDiff = a.length() - b.length();
			b = addLength(b, lengthDiff);
			
		}
		else if(a.length() < b.length()) {
			lengthDiff = b.length() - a.length();
			a = addLength(a, lengthDiff);
			length = b.length();
		}
		
		char[] n1 = a.toCharArray();
		char[] n2 = b.toCharArray();
		char[] sums = new char[n1.length];
		
		for(int i = length-1; i >= 0; i--) {
			int number1 = Character.getNumericValue(n1[i]);
			int number2 = Character.getNumericValue(n2[i]);
			
			sum = number1 + number2 + carry;
			
			if(sum > 9) {
				if(i == 0) {
					addOne = true;
				}
				carry = 1;
				sum -= 10;
			}
			else {
				carry = 0;	
			}
			
			sb.insert(0, sum);
			
			if(addOne == true)
				sb.insert(0, 1);
		}
		
		return sb.toString();
	}
	
	public static String sub(String a, String b) {

		StringBuilder sb = new StringBuilder();
		int lengthDiff;
		int length = a.length();
		int sum; 
		int carry = 0;
		
		if(a.length() > b.length()) {
			lengthDiff = a.length() - b.length();
			b = addLength(b, lengthDiff);
			
		}
		else if(a.length() < b.length()) {
			lengthDiff = b.length() - a.length();
			a = addLength(a, lengthDiff);
			length = b.length();
		}
		
		char[] n1 = a.toCharArray();
		char[] n2 = b.toCharArray();
		char[] sums = new char[n1.length];
		
		for(int i = length-1; i >= 0; i--) {
			int number1 = Character.getNumericValue(n1[i]);
			int number2 = Character.getNumericValue(n2[i]);
			
			sum = number1 - number2 - carry;
			
			if(sum < 0) {
				carry = 1;
				sum += 10;
			}
			else {
				carry = 0;	
			}
			
			sb.insert(0, sum);
		}
	
		if(carry == 1) {
			
			sb.insert(0, 1);
		}
		return sb.toString();
	}
	
	
	public static String addLength(String s, int length) {
		StringBuilder sb = new StringBuilder(s);
		
		for(int i = 0; i < length; i++) {
			sb.insert(0, "0");
		}
		
		return sb.toString();
		
	}
}

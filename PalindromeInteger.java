/*
* Class: CS1301/07
* Term: Fall 2017
* Name: Alex Manzer
* Instructor: Tejaswini Nalamothu
* Assignment: 8 program 3
*/

import java.util.Scanner;

public class PalindromeInteger {
	public static void main(String[] args) {
		//determines if a num is a palindrome
		boolean go = true;
		while(go) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int inputnum = input.nextInt();
		System.out.println("The number " + inputnum + " is " + (isPalindrome(inputnum) ? "" : "not ") +"a Palindrome" );
		
		System.out.print("Keep going (true/false)? ");
		go = input.nextBoolean();
		}
	}
	
	public static int reverse(int num) {
		int length = 0;
		int x = num;
		int output;
		while(x > 0) {
			x = x / 10;
			length++;
		}
		//System.out.println(length);
		
		x = num;
		output = 0;
		for (int i = 1; i <= length; i++) {
			output = output + (num / (int)Math.pow(10, i - 1) % 10) * (int)Math.pow(10, length - i);
			//System.out.println("output = " + output);
			
		}
		return output;
	}
	
	public static boolean isPalindrome(int number) {
		int rev = reverse(number);
			if (rev == number) {
				return true;
			}
			else if (rev != number) {
				return false;
			}
			else {
				return false;
			}
	}
}

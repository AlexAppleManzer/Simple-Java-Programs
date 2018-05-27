/*
* Class: CS 1301/11
* Term: Fall 2017
* Name: Alex Manzer
* Instructor: Tejaswini NALAMOTHU
* Lab 7 Program 2
*/

import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String:");
		String phrase = input.nextLine();
		System.out.println("Entered String: " + phrase);
		int word = 0;
		int c = 0;
		int c1 = 1;
		boolean stop = false;
		
		while (c < phrase.length()) {
			stop = true;
			
			while(stop) {
				if (phrase.length() <= c1)
					stop = false;
				else if(phrase.charAt(c1) == ' ') {
					stop = false;
				}
				else
					c1 = c1 + 1;
			}
			//System.out.println(c1);
			word = word + 1;
			System.out.println("Word #" + word + ": " + phrase.substring(c, c1));
			c = c1;
			c1 = c1 + 1;
		}
		
	}
}

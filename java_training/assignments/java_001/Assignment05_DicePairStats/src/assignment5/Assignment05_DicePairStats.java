package assignment5;

import java.util.*;

public class Assignment05_DicePairStats{


	public static void main(String[] args){

		//by default, java sets all uninitialized
		//variables to 0
		int tally[] = new int[21];
		int index;
		int first;
		int second;
		int max;
		int position;

		System.out.println("1000 Random 2 dice toss stats");
		
		for(int i=0; i < 1000; i++){

			first = rollDie();
			second = rollDie();
			index = countRoll(first, second);
			tally[index]++;

		}//end for loop

		for(int i=0; i < 21; i++){

			max = tally[i];
			position = i;
			for(int j = 0; j < 21; j++){

				if(max < tally[j]){
					max = tally[j];
					position = j;
				}

			}//end inner for loop

			display(tally, max, position);
			tally[position] = 0;

		}//end outer loop

	}//end main


	public static void display(int tally[], int max, int position){

		if(position == 0){
			System.out.println("Dice 1 and 1: " + max + " times.");
		}else if(position == 1){
			System.out.println("Dice 2 and 1: " + max + " times.");
		}else if(position == 2){
			System.out.println("Dice 3 and 1: " + max + " times.");			
		}else if(position == 3){
			System.out.println("Dice 4 and 1: " + max + " times.");			
		}else if(position == 4){
			System.out.println("Dice 5 and 1: " + max + " times.");			
		}else if(position == 5){
			System.out.println("Dice 6 and 1: " + max + " times.");			
		}else if(position == 6){
			System.out.println("Dice 2 and 2: " + max + " times.");			
		}else if(position == 7){
			System.out.println("Dice 3 and 2: " + max + " times.");			
		}else if(position == 8){
			System.out.println("Dice 4 and 2: " + max + " times.");			
		}else if(position == 9){
			System.out.println("Dice 5 and 2: " + max + " times.");			
		}else if(position == 10){
			System.out.println("Dice 6 and 2: " + max + " times.");			
		}else if(position == 11){
			System.out.println("Dice 3 and 3: " + max + " times.");			
		}else if(position == 12){
			System.out.println("Dice 4 and 3: " + max + " times.");			
		}else if(position == 13){
			System.out.println("Dice 5 and 3: " + max + " times.");			
		}else if(position == 14){
			System.out.println("Dice 6 and 3: " + max + " times.");			
		}else if(position == 15){
			System.out.println("Dice 4 and 4: " + max + " times.");			
		}else if(position == 16){
			System.out.println("Dice 5 and 4: " + max + " times.");			
		}else if(position == 17){
			System.out.println("Dice 6 and 4: " + max + " times.");			
		}else if(position == 18){
			System.out.println("Dice 5 and 5: " + max + " times.");			
		}else if(position == 19){
			System.out.println("Dice 6 and 5: " + max + " times.");			
		}else{
			System.out.println("Dice 6 and 6: " + max + " times.");			
		}

	}//end display


	public static int rollDie(){

		int num;
		Random rand = new Random();

		num = rand.nextInt(6) + 1;
		return num;

	}//end rollDie


	//returns an index to be incremented in the main method
	//it goes low from high. eg (1,1) is index 0,
	//(2,1) is index 1, (3,1) is index 3,
	//all the way to (6,6) which is index 21
	public static int countRoll(int die1, int die2){

		int count;
		int temp;
		//switches the numbers to ensure the larger
		//is always in die1 for the correct array index
		if(die2 > die1){
			temp = die1;
			die1 = die2;
			die2 = temp;
		}

		if(die1 == 1 && die2 == 1){
			count = 0;
		}else if(die1 == 2 && die2 == 1){
			count = 1;
		}else if(die1 == 3 && die2 == 1){
			count = 2;
		}else if(die1 == 4 && die2 == 1){
			count = 3;
		}else if(die1 == 5 && die2 == 1){
			count = 4;
		}else if(die1 == 6 && die2 == 1){
			count = 5;
		}else if(die1 == 2 && die2 == 2){
			count = 6;
		}else if(die1 == 3 && die2 == 2){
			count = 7;
		}else if(die1 == 4 && die2 == 2){
			count = 8;
		}else if(die1 == 5 && die2 == 2){
			count = 9;
		}else if(die1 == 6 && die2 == 2){
			count = 10;
		}else if(die1 == 3 && die2 == 3){
			count = 11;
		}else if(die1 == 4 && die2 == 3){
			count = 12;
		}else if(die1 == 5 && die2 == 3){
			count = 13;
		}else if(die1 == 6 && die2 == 3){
			count = 14;
		}else if(die1 == 4 && die2 == 4){
			count = 15;
		}else if(die1 == 5 && die2 == 4){
			count = 16;
		}else if(die1 == 6 && die2 == 4){
			count = 17;
		}else if(die1 == 5 && die2 == 5){
			count = 18;
		}else if(die1 == 6 && die2 == 5){
			count = 19;
		}else{
			count = 20;
		}

		return count;

	}//end countRolls



}//end class
//Bond Ragsdale 16081101

import java.util.Scanner;
//public class Panel {
	//public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String denomination;
		String transaction = "complete";
		int numCoins;
		String again = "yes";
		//Line 12 initializes a new machine
		Machine test = new Machine();
		//Lines 14-16 greet the user
		System.out.println("Welcome to BondStar! Please deposit your coins by providing the number you would like to deposit, followed");
		System.out.println("by the denomination. When you are done, please type complete to end your transaction. Fees will");
		System.out.println("be taken automatically from your deposit, and you will receive your voucher. Thank you.");
		//this do loop repeats for every transaction
		do{
			Boolean done = false;
			System.out.println("Please make your deposits.");
			//This do loop repeats until the user types complete, and also rejects invalid input
			do{ 
				if(sc.hasNextInt()){
					numCoins = sc.nextInt(); 
					denomination = sc.nextLine();
					denomination = (denomination.toLowerCase());
					//These loops add to the balance according to the coins that the user deposits
					if(denomination.equals(" quarters")){
						test.insertQuarters(numCoins);
					} else if(denomination.equals(" quarter" )){
						test.insertQuarters(numCoins);
					} else if (denomination.equals(" dimes")){
						test.insertDimes(numCoins);
					} else if (denomination.equals(" dime")){
						test.insertDimes(numCoins);
					} else if (denomination.equals(" nickels")){
						test.insertNickels(numCoins);
					} else if (denomination.equals(" nickel")){
						test.insertNickels(numCoins);
					} else if (denomination.equals(" pennies")){
						test.insertPennies(numCoins);
					} else if (denomination.equals(" penny")){
						test.insertPennies(numCoins);
					} else {
						System.out.println("Invalid denomination, please try again!");
					}
					//This loop makes it so that if the user types complete, the loop ends
				} else if(sc.hasNextLine()){
					if(sc.nextLine().equals("complete")){
						done = true;
					} else {
						System.out.println("Invalid input, please try again!");
					}
				}
				//This is the end of the transaction do loop
			}while(!done);
			test.getVoucher();
			System.out.println();
			System.out.println("Thank you for your business.");
			System.out.println("Please take your voucher below the coin deposit slot.");
			System.out.println("Would you like to begin another transaction? Type Yes or No.");
			again = sc.nextLine();
			if(again.equals("yes")){
				test.reset();
			} 
			//This while statement makes it so that when the user doesn't say yes to continuing, the collected fees are displayed
		}while(again.equals("yes"));
	System.out.println(test.getCollectedFees());
		}
	}
//Bond Ragsdale 16081101

public class Machine {
	double balance;
	double fees;
	double totalFees;
	double feeRate = 0.089;
	int numTwenties = 0;
	int numTens = 0;
	int numFives= 0;
	int numOnes = 0;
	int numQuarters = 0;
	int numDimes = 0;
	int numNickels = 0;
	int numPennies = 0;
	int twenties = 0;
	int tens = 0;
	int fives = 0;
	int ones = 0;
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	int pennies = 0;
	double valTwenty = 20;
	double valTen = 10;
	double valFive = 5;
	double valOne = 1;
	double valQuarter = 0.25;
	double valDime = 0.10;
	double valnickels = 0.05;
	double valPenny = 0.01;

	public void reset(){
		balance = 0;
		fees = 0;
	}
	//These methods adjust the balance depending on the number of coins deposited
	public double insertQuarters(int numQuarters){
		balance += (numQuarters * 0.25);
		return balance;
	}
	public double insertDimes(int numDimes){
		balance += (numDimes * 0.10);
		return balance;
	}
	public double insertNickels(int numNickels){
		balance += (numNickels * 0.05);
		return balance;
	}
	public double insertPennies(int numPennies){
		balance += (numPennies * 0.01);
		return balance;
	}
	//getVoucher calculates the fees and the balance
	public String getVoucher(){
		fees = (balance * feeRate);
		totalFees = totalFees + fees;
		balance = (balance - fees);
		//These lines find the numbers of certain denominations by dividing the remainder of the previous denomination by the lower one
		int numTwenties = (int) (balance/valTwenty);
		int numTens = (int) ((balance % valTwenty) / valTen);
		int numFives = (int) (((balance % valTwenty) % valTen) / valFive);
		int numOnes = (int) ((((balance % valTwenty) % valTen) % valFive) / valOne);
		int numQuarters = (int) (((((balance % valTwenty) % valTen) % valFive) % valOne) / valQuarter);
		int numDimes = (int) ((((((balance % valTwenty) % valTen) % valFive) % valOne) % valQuarter) / valDime);
		int numnickels = (int) (((((((balance % valTwenty) % valTen) % valFive) % valOne) % valQuarter) % valDime) / valnickels);
		int numPennies = (int) (((((((((balance % valTwenty) % valTen) % valFive) % valOne) % valQuarter) % valDime) % valDime) % valnickels) / valPenny);
		//These loops make it so if there are over 1 of a denomination, the value is stored
		if (numTwenties > 0){
			twenties = numTwenties;
			}
		if (numTens > 0){
			tens = numTens;
			}
		if (numFives > 0){
			fives = numFives;}
		if (numOnes > 0){
			ones = numOnes;
			}
		if (numQuarters > 0){
			quarters = numQuarters;
			}
		if (numDimes > 0){
			dimes = numDimes;
			}
		if (numnickels > 0){
			nickels = numnickels;
			}
		if (numPennies > 0){
			pennies = numPennies;
			}
		//The math.floor here rounds the balance to the nearest hundredth
		String voucher = ("Your voucher is $" + Math.floor((balance)*100)/100 + " after fees, in the following denominations. ");
		System.out.print(voucher); 
		//These loops make it so if there are certain denominations being used, it prints the number, but if not, prints nothing
		if (twenties > 0){
			System.out.print(twenties + " Twenties ");
		}else{
			System.out.print("");}
		if (tens > 0){
			System.out.print(tens + " Tens ");
		}else{
			System.out.print("");}
		if (fives > 0){
			System.out.print(fives + " Fives ");
		}else{
			System.out.print("");}
		if (ones > 0){
			System.out.print(ones + " Ones ");
		}else{
			System.out.print("");
		}
		if (quarters > 0){
			System.out.print(quarters + " Quarters ");
		}else{
			System.out.print("");}
		if (dimes > 0){
			System.out.print(dimes + " Dimes ");
		}else{
			System.out.print("");}
		if (nickels > 0){
			System.out.print(nickels + " Nickels ");
		}else{
			System.out.print("");
		}
		if (pennies > 0){
			System.out.print(pennies + " Pennies ");
		}else{
			System.out.print("");}
		return voucher;
	}
	//this method rounds the total fees to the hundredth and prints them to the user
	public String getCollectedFees(){
		String collectedFees = "Your total fees were: $" + Math.ceil(totalFees*100)/(100) + ". Thank you for choosing BondStar. Enjoy"
				+ " your converted money.";
		return collectedFees;
	}
}
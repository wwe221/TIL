package bank;

import java.util.Random;

public class AccApp {

	public static void main(String[] args) {
		Account myAc =new Account();
		System.out.println(myAc.toString());
		myAc.setName("이경헌");
		int ran = (int)(Math.random() *100000000)+ 100000000;
		myAc.setNumber(ran);
		myAc.setAccountType("주택청약");
		myAc.setPassword(1234);
		myAc.setLimit(2000000);
		myAc.setInternetBanking(true);
		myAc.setCardCount(1);
		myAc.plusBalance(50000);
		System.out.println(myAc.toString());
	}

}

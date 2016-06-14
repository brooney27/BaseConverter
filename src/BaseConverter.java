import java.util.Scanner;

public class BaseConverter {

	public static void main(String[] args) {
		while(1==1){
		Scanner in = new Scanner(System.in);
		
		String num;
		int base;
		int target;
		
		System.out.println("Input Number base: ");
		base = in.nextInt();
		System.out.println("Input base to convert to: ");
		target = in.nextInt();
		System.out.println("Input Number: ");
		num = in.next();
		
		int dec = toDecimal(num, base);
		
		System.out.println("Base 10: " + dec);
		
		int length = powerBase(dec, target);
		
		System.out.println("length: " + length);
		
		char[] out = intToString(dec, target, length);
		String finalNum = new String(out);
			
		
		System.out.println("Answer: " + finalNum);
		}
	}
	
	public static int toDecimal(String num, int base){
		//System.out.println("calling to decimal");
		int dec = 0;
		int pow = 1;
		char[] hex = num.toCharArray();
		for(int i = hex.length -1; i >= 0; i--){
			dec += charToInt(hex[i]) * pow;
			pow = pow * base;
		}
		
		return dec;
	}
	
	public static int powerBase(int num, int base){
		//System.out.println("calling");
		int length = 1;
		
		while(num > 0){
			length++;
			num = num/base;
		}
		
		return length;
	}
	
	public static int charToInt(char num){
		if(num == 'A')return 10;
		if(num == 10)return 11;
		if(num == 11)return 12;
		if(num == 12)return 13;
		if(num == 13)return 14;
		if(num == 14)return 15;
		return Character.getNumericValue(num);
	}
	
	public static char intToChar(int num){
		System.out.println(num);
		if(num < 10)return (char)(num+30);
		if(num == 10)return 'A';
		if(num == 11)return 'B';
		if(num == 12)return 'C';
		if(num == 13)return 'D';
		if(num == 14)return 'E';
		return 'F';
	}
	
	public static char[] intToString(int num, int base, int length){
		System.out.println("calling");
		
		char[] out = new char[length];
		int pow = 1;
		
		for(int i =1; i < length; i++){
			pow = pow*base;
		}
		
		String charInt = new String();
		
		for(int i = 0; i < length; i++){
			System.out.println("Power: " + pow);
			if(num/pow>9)charInt = charInt + intToChar(num/pow);
			else charInt = charInt + (num/pow);
			num = num%(pow);
			pow = pow/base;
		}
		
		return charInt.toCharArray();
	}
}

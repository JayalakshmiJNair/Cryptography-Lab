package hash;
import java.util.Scanner;
public class Hash {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String data=sc.nextLine();
		byte hash=0;
		for(byte b:data.getBytes()) {
			hash^=b;
		}
		System.out.println("XOR Hash(Decimal): "+(hash&0xFF));
		System.out.println("XOR Hash(Hexadecimal): 0x"+Integer.toHexString(hash&0xFF).toUpperCase());
		sc.close();
	}
}

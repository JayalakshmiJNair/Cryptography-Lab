package ceasercipher;
import java.util.*;
public class CeaserCipher {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a plaintext: ");
		String plaintext=sc.nextLine();
		for(int i=0;i<plaintext.length();i++) {
			char ch=plaintext.charAt(i);
			if(Character.isLetter(ch)) {
				char base=Character.isUpperCase(ch)?'A':'a';
				ch=(char)((ch-base+3)%26+base);
			}
			System.out.print(ch);
		}
		System.out.println();
		System.out.print("Enter a ciphertext: ");
		String ciphertext=sc.nextLine();
		for(int i=0;i<ciphertext.length();i++) {
			char ch=ciphertext.charAt(i);
			if(Character.isLetter(ch)) {
				char base=Character.isUpperCase(ch)?'A':'a';
				ch=(char)((ch-base-3+26)%26+base);
			}
			System.out.print(ch);
		}
		sc.close();
	}

}

package diffiehellman;
import java.util.Scanner;
public class DH {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a prime number: ");
		int p=sc.nextInt();
		System.out.print("Enter a primitive root: ");
		int g=sc.nextInt();
		System.out.print("Enter Alice's private key: ");
		int a=sc.nextInt();
		System.out.print("Enter Bob's private key: ");
		int b=sc.nextInt();
		//Calculate public key
		int A=(int)(Math.pow(g,a)%p);
		int B=(int)(Math.pow(g,b)%p);
		System.out.println("Publicly shared data:");
		System.out.println("Prime number: "+p);
		System.out.println("Primitive root: "+g);
		System.out.println("Alice's public key: "+A);
		System.out.println("Bob's public key: "+B);
		//shared secret key
		int SA=(int)(Math.pow(B,a)%p);
		int SB=(int)(Math.pow(A,b)%p);
		System.out.println("Alice's shared key: "+SA);
		System.out.println("Bob's shared key: "+SB);
		if(SA==SB) {
			System.out.println("Shared secret key successfully. ");
		} else {
			System.out.println("Error");
		}
		sc.close();
	}
}

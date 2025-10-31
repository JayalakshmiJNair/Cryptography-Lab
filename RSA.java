package rsa;
import javax.crypto.Cipher;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Scanner;
public class RSA {
	public static void main(String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a message: ");
		String message=sc.nextLine();
		KeyPairGenerator keyGen= KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair pair=keyGen.generateKeyPair();
		Cipher cipher= Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,pair.getPublic());
		byte[] encrypted=cipher.doFinal(message.getBytes("UTF-8"));
		String encryptedBase=Base64.getEncoder().encodeToString(encrypted);
		System.out.println("Encrypted text: "+encryptedBase);
		cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(encryptedBase));
		System.out.println("Decrypted text: "+ new String(decrypted,"UTF-8"));
		sc.close();
		
	}
}

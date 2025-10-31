package aesalgorithm;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class AES {
	public static void main(String args[]) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a message: ");
		String message=sc.nextLine();
		System.out.print("Enter a key: ");
		String key=sc.nextLine();
		SecretKeySpec secretKey=new SecretKeySpec(key.getBytes("UTF-8"),"AES");
		Cipher cipher=Cipher.getInstance("AES");
		//Encryption
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encrypted=cipher.doFinal(message.getBytes("UTF-8"));
		String encryptedBase=Base64.getEncoder().encodeToString(encrypted);
		System.out.println("Encrypted: "+encryptedBase);
		//Decryption
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(encryptedBase));
		System.out.println("Decrypted: "+new String(decrypted,"UTF-8"));
		sc.close();
	}

}

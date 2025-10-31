package rc4;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class RC4 {
	public static void main(String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a message: ");
		String message=sc.nextLine();
		System.out.print("Enter a key: ");
		String key=sc.nextLine();
		SecretKeySpec secertKey=new SecretKeySpec(key.getBytes("UTF-8"),"RC4");
		Cipher cipher=Cipher.getInstance("RC4");
		//Encryption
		cipher.init(Cipher.ENCRYPT_MODE, secertKey);
		byte[] encrypted=cipher.doFinal(message.getBytes("UTF-8"));
		String encryptedBase=Base64.getEncoder().encodeToString(encrypted);
		System.out.println("Encrypted text: "+ encryptedBase);
		//Decryption
		cipher.init(Cipher.DECRYPT_MODE, secertKey);
		byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(encryptedBase));
		System.out.println("Decrypted text: "+new String(decrypted,"UTF-8"));
		sc.close();
	}

}

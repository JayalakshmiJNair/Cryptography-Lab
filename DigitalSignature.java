package dss;
import java.security.*;
import java.util.*;
public class DigitalSignature {
	public static void main(String[]args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a message: ");
		String message=sc.nextLine();
		KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair pair=keyGen.generateKeyPair();
		Signature sign=Signature.getInstance("SHA256withRSA");
		sign.initSign(pair.getPrivate());
		sign.update(message.getBytes());
		byte[] signature=sign.sign();
		System.out.println("Signature: "+Base64.getEncoder().encodeToString(signature));
		sign.initVerify(pair.getPublic());
		sign.update(message.getBytes());
	    boolean verify=sign.verify(signature);
	    System.out.println("Verified: "+verify);
	    sc.close();
	}
}

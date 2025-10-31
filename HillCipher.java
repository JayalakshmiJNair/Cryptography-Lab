package hillcipher;
import java.util.*;
public class HillCipher {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a 2x2 matrix: ");
		int key[][]=new int[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				key[i][j]=sc.nextInt()%26;
				if (key[i][j] < 0) key[i][j] += 26;
			}
		}
		int det=((key[0][0]*key[1][1]-key[0][1]*key[1][0])%26);
		if(det<0) det+=26;
		int detinv=-1;
		
		for(int i=1;i<26;i++) if((det*i)%26==1) detinv=i;
        if(detinv==-1) {
        	System.out.println("Error");
        	return;
        }
		int keyinv[][]= {
				{(key[1][1]*detinv)%26,(-key[0][1]*detinv)%26},
				{(-key[1][0]*detinv)%26,(key[0][0]*detinv)%26}
		};
		for(int i=0;i<2;i++) for(int j=0;j<2;j++) if(keyinv[i][j]<0) keyinv[i][j]+=26;
		sc.nextLine();
		System.out.println("Enter a message: ");
		String msg=sc.nextLine().toUpperCase().replaceAll("[^A-z]","");
		if((msg.length())%26!=0) msg+='X';
		
		String enc=process(msg,key);
		String dec=process(enc,keyinv);
		System.out.println("Encrypted: "+enc);
		System.out.println("Decrypted: "+dec);
	}

		static String process(String text,int [][]k) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<text.length();i+=2) {
				int a=text.charAt(i)-'A',b=text.charAt(i+1)-'A';
				sb.append((char)(((k[0][0]*a+k[0][1]*b)%26)+'A'));
				sb.append((char)(((k[1][0]*a+k[1][1]*b)%26)+'A'));
				
			}
		 
		 return sb.toString();
		}
}
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64.*;
import java.nio.charset.Charset;

public class SEPMDB_Decrypt {

public static byte[] fromHexString(String str) {
   int len = str.length();
   byte[] data = new byte[len / 2];
   for (int i = 0; i < len; i += 2) {
    data[i / 2] =
    (byte)((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
  }
    return data;
   }

	public static String decrypt(String input) {
		byte[] output = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(new byte[] { -95, 18, 119, 66, 71, -6, 101, -87, -79, 19, 120, 82, 72, -22, 104, -71 }, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(2, skey);
			output = cipher.doFinal(fromHexString(input));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(output);
	}

	public static void main(String[] args) {
    try{
			String data = args[0];
			if (data.startsWith("{V01}"))
			{
				data = data.substring(5);
			}
  		System.out.println(SEPMDB_Decrypt.decrypt(data));
	}
  catch (Exception e1){
    System.out.println(e1.toString());
  }
}
}
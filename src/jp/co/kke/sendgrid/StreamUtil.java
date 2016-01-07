package jp.co.kke.sendgrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {
	/***
	 * InputStreamをStringに変換
	 * @param in
	 * @param enc
	 * @return
	 * @throws IOException
	 */
	public static final String inputStreamToString(InputStream in, String enc) throws IOException {
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(in, enc));
		StringBuffer buf = new StringBuffer();
		String str;
		while ((str = reader.readLine()) != null) {
			buf.append(str);
			buf.append("\n");
		}
		return buf.toString();
	}
}

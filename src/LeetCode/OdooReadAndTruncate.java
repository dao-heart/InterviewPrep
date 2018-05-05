/*
package LeetCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class OdooReadAndTruncate {
    public static void main(String[] args) throws Exception {
        fileStreamer();
    }

    public static void fileStreamer() throws Exception{
        FileInputStream inputStream = null;
        FileOutputStream outputStream =  null;
        OutputStreamWriter osw = null;
        Scanner sc = null;

        String path1 = "INPUT File";
        String path2 = "OUTPUT File";
        try {
            inputStream = new FileInputStream(path1);
            outputStream = new FileOutputStream(path2);

            osw = new OutputStreamWriter(outputStream);
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println();
                System.out.println(new BigInteger(line.getBytes()).toString(2));
                String prcessString  = new BigInteger(line.getBytes()).toString(2);

                StringBuffer out = new StringBuffer();
                int i=0;
                int j= 63;
                while(j<prcessString.length()){
                    out.append(prcessString.substring(i,j));
                    i+=72;
                    j+=72;
                }
                out.append(prcessString.substring(i,prcessString.length()));

                System.out.println(out.toString());
                osw.write(out.toString(),0,out.length());
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }

            osw.flush();
        }
    }
}
*/

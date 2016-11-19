
package server;

import java.io.BufferedReader;
import java.util.Vector;

public class Reader implements Runnable {
    public BufferedReader in;
    public Vector Data=new Vector();
    Reader(BufferedReader i) {
        in=i;
    }
    
    public void run() {
    try {
        while(true){
            String inputLine = in.readLine();
            String[] s = inputLine.split(" ");
            if(s.length==4){
                DataMas data_1=new DataMas();
                data_1.product_cost=Float.parseFloat(s[0]);
                data_1.aol=Float.parseFloat(s[1]);
                data_1.selling_price=Float.parseFloat(s[2]);
                data_1.income=Float.parseFloat(s[3]);
                Data.add(data_1);
            }
        }
	}
    catch (Exception e) {
	System.out.println("Второй поток прерван");
    }
    }
}

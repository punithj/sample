package sample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class mytest {
	
	FileWriter writer=null; 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File tsv = null;
		BufferedReader TSVFile = null;
		StringTokenizer st ;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		FileWriter writer=null;
		boolean check = new File("roi", "report.tsv").exists();
		tsv = new File("roi", "report.tsv");
		
		if(check==false){
			tsv.getParentFile().mkdirs();
			try {
				tsv.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			TSVFile = new BufferedReader(new FileReader(tsv));
			
			String dataRow = TSVFile.readLine(); // Read first line.

			while (dataRow != null){
				String key;
				Integer value;
				st = new StringTokenizer(dataRow,"\t");
	            List<String>dataArray = new ArrayList<String>() ;
	            while(st.hasMoreElements()){
	                dataArray.add(st.nextElement().toString());
	                
	                
	            }
	            key = dataArray.get(0);
	            value = Integer.parseInt(dataArray.get(1));
	            hm.put(key, value+1);
	            for (String item:dataArray) { 
	                System.out.print(item + "  "); 
	            }
	            System.out.println(); // Print the data line.
	            dataRow = TSVFile.readLine(); // Read next line of data.
			}
			hm.put("testcase"+ new Random().nextInt(1000000), 10);
			
			
			try {
				writer = (new FileWriter(tsv,false));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(hm!=null){
			 for (Map.Entry<String, Integer> entry : hm.entrySet()) {
				    System.out.println(entry.getKey() + " = " + entry.getValue());
				    try {
						writer.append(entry.getKey() + "\t" + entry.getValue() + "\r\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			 try {
				TSVFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

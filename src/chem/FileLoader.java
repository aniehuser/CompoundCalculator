package chem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;

/**
 * Intended to load any data needed for running the program
 * @author anthonyniehuser
 *
 */
public class FileLoader {

	/**
	 * Returns a hashtable of all elements in the periodic table with each elements symbol as a key
	 * @return Hashtable <String, Element>
	 */
	public static Hashtable<String, Element> LoadElements(){
		BufferedReader buff = null;
		String filepath = System.getProperty("user.dir") + "/files/" + "ElementSpreadSheet.csv";
		String line = null;
		String data[] = null;
		Hashtable<String,Element> temp = new Hashtable<String,Element>();
		try{
			buff = new BufferedReader(new FileReader(filepath));
			line = buff.readLine();
			while((line = buff.readLine())!=null){
				int x = 0;
				
				data = line.split(",");
				emptyToEmptySymbol(data);
				Element el = new Element(
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x++],
						data[x]);
				temp.put(data[1], el);
			}
		}catch(Exception e) {
			Prog.log.warning("File Loading Error: " + e.getStackTrace());
			System.out.println("Error: " + e.getMessage());
			
		}finally{
			try{
				if(buff!=null)	buff.close();
			}catch(Exception e) {
				Prog.log.warning("File Closing Error: ");
				System.out.println("Error: " + e.getMessage());
			}
		}
		return temp;
	}
	
	/**
	 * Converts all null or empty values of string array to "???"
	 * @param data string array input
	 */
	private static void emptyToEmptySymbol(String[] data){
		int l = data.length;
		for(int i=0; i<l; i++){
			data[i] = (data[i]!=null && !data[i].isEmpty()) ? data[i] : Prog.empty;
		}
	}
}

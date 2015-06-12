package madn_gui;
import java.util.*;

public class Board {
			
		public static void main(String args[]) {
	
	        ArrayList<String> felder = new ArrayList<String>();

	        for (int i=1;i<=76;i++){
	        felder.add("ID " + i);
	        }
	        
	        
	       String item = felder.get(54);
	       System.out.println("The item is the index 54 is: " + item);

	        for(String feld : felder){
	        	System.out.println(feld);
	        }

	     


		}
		}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * COP 3538: Project 5 - Hashtables
 * <P>
 * 	The program
 * and pushes them back onto a stack.
 * <P>
 *  @author <Steven Fernandez>  
 *  @version <4/4/2019>  
 */ 
public class Project5{
	static Hashtable table = new Hashtable();
	
	
	
	/**   
	 *  Reads file States2.csv and inserts the states onto a 
	 *  Hashtable
	 * @param  String file name
	 * @return line count
	 */
	public int read(String filename) //read file method
	{
	     String csvFile = filename;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	       int cnt=0;
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                //String[] data= line.split(cvsSplitBy);

	               cnt++;

	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	         }
	       
	        
	       int scnt=0;
	          try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	                if(scnt==0)
	                 {
	                   scnt++;
	                   continue;
	                }
	                // use new line as separator
	                String[] data= line.split(cvsSplitBy);

	                
	              table.insert(data[0],Integer.parseInt(data[3]));
	              
	               scnt++;
	               
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	      return scnt;
	       	  
	  }
	
	/**
    * This is the main method which uses a Hashtable
    * to structure the data.
    * @param args unused
    * @return Nothing.
    */
	public static void main (String[] args){
		
		//Project5 p5=new Project5();
		Project5 p5=new Project5();
		System.out.println("COP3538 Project 1");
		System.out.println("Instructor: Xudong Liu");
		System.out.println();
		System.out.println("Binary Search Trees");
		System.out.println("Enter the filename: ");
		Scanner in=new Scanner(System.in);
		String fname=in.nextLine();
		int nr=p5.read(fname);
		System.out.println();
		System.out.println("There were "+(nr-1)+ " states put on the Hashtable.");
		System.out.println();
		
		table.display();
		System.out.println("");
		
		String[] tobeDeleted = {"Vermont", "Kansas", "South Carolina"};
		for(int i=0; i<3; i++)
		{
			table.delete(tobeDeleted[i]);
			System.out.printf("%s has been deleted from hash table\n", tobeDeleted[i]);
		}
		
		
		
		System.out.println("");
		String[] tofind = {"Florida", "Rhode Island", "Kansas"};
		for(int i=0; i<3; i++)
		{
			int temp = table.find(tofind[i]);
			
			if(temp != -1)
			{
				System.out.printf("%s is found with a population of %d\n", tofind[i], temp);
			}
			
			else
			{
				System.out.printf("%s has not been found\n", tofind[i]);
			}
		}
		
		System.out.println("");
		String[] tobeDeleted2 = {"Kentucky", "Minnesota", "Puerto Rico", "Ohio"};
		for(int i=0; i<4; i++)
		{
			table.delete(tobeDeleted2[i]);
			System.out.printf("%s has been deleted from hash table\n", tobeDeleted2[i]);
		}
		
		System.out.println("");
		table.display();
		System.out.println("");
		table.printFreeAndCollisions();
		
		
		
	    
    
    
	  
	    
	}
}
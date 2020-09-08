/**
 * COP 3538: Project 5 - Hashtable
 * <P>
 * 	Hashtable thats implemented using an array that has an insert, 
 * 	delete, find, display, printfreeAndCollisions methods.
 * <P>
 *  @author <Steven Fernandez>  
 *  @version <4/4/2019>  
 */ 
public class Hashtable 
{
	private LinkedList[] table;
	int arraySize = 113;
	
	
/**   
* constructor for Hashtable
* @param  Nothing
* @return nothing
*/
public Hashtable()
{
	table = new LinkedList[arraySize];
	for(int i = 0; i < arraySize; i ++)
	{
		table[i] = new LinkedList();
	}
	
}
/**
 * inserts state and population onto the hashtable
 * @param String state and int population
 * @return Nothing.
 */
public void insert(String state, int population)
{
    char[] charName = state.toCharArray();
    int size = charName.length;
    int sum = 0;
    for(int i = 0; i < size; i++)
    {
      sum = sum + (int)charName[i];
    }
    sum = sum % arraySize;
   
    if(table[sum] == null)
    {
    	table[sum] = new LinkedList();
    }
    table[sum].insertLink(state,population);
}
/**
 * hashes the state name and searches the linked list
 * at the index
 * @param String state
 * @return false if Linked list is empty else returns population
 */
 public int find(String state)
 {
	 //Hash the state name to find the index in the table
	 char[] charName = state.toCharArray();
	 int size = charName.length;
	 int sum = 0;
	 int Population;
	 for(int i = 0; i < size; i++)
	 {
		 sum = sum + (int)charName[i];
	 }
	 
	 sum = sum % arraySize;

	 // Search the linked list at that index
      if(table[sum].isEmpty()) // Is the LL empty?
      {
    	return -1;  
    	  			
      }
      else     // If not, search it for the state
      {
    	Population = table[sum].find(state);
    	return Population;
      }        
 }
 /**
  * hashes the state name to find the index then 
  * searches the linked list at that index
  * @param String state
  * @return Nothing.
  */
 public void delete(String state)
 {
	 //Hash the state name to find the index in the table
	 char[] charName = state.toCharArray();
	 int size = charName.length;
	 int sum = 0;
	 for(int i = 0; i < size; i++)
	 {
		 sum = sum + (int)charName[i];
	 }
	 
	 sum = sum % arraySize;

	 // Search the linked list at that index
      if(!table[sum].isEmpty()) // Is the LL empty?
      {
    	table[sum].deleteLink(state);
    	  			
      }  
 }
 /**
  * prints the indexes
  * @param nothing
  * @return Nothing.
  */
 public void display()
 {	
	 System.out.println("Hash Table Content:\n");
	 for(int i =0; i < arraySize; i++)
	 {
		 System.out.printf("%d.\t", i);
		 table[i].printLinkedlist();
	 }
 }
 /**
  * Prints the amount of spaces available and collisions that happened
  * @param nothing
  * @return Nothing.
  */
 public void printFreeAndCollisions()
 {
	 int collision=0;
	 int free=0;
	 for(int i =0; i < arraySize; i++)
	 {
		 if(table[i].isCollision())
		 {
			 collision++;
		 }
		 else if(table[i].isEmpty())
		 {
			 free++;
		 }
	 }
	 System.out.printf("There are %d spaces available and %d collisions in the hash table", free, collision);
 }
}

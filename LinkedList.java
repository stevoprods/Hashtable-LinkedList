/**
 * COP 3538: Project5 - LinkedList
 * <P>
 * 	Doubly linked list that is only inserted from the end
 * <P>
 *  @author <Steven Fernandez>  
 *  @version <4/18/2019>  
 */ 
public class LinkedList 
{
	Node front, end;
	
	private class Node 
	{    
		String stateName;    
		int statePopulation;    
		Node nextNode; 
		/**
		  * defines stateName and StatePopulation
		  * @param String state and int population
		  * @return Nothing.
		  */
		public Node(String state, int population)    
		{       
			stateName = state;       
			statePopulation = population;    
		}    
		/**
		  * prints the state and population at that given node
		  * @param nothing
		  * @return Nothing.
		  */
		public void printNode()    
		{       
			System.out.printf("%-25s%,10d\n", stateName, statePopulation);    
    	
		} 
	}
	/**
	  * Constructor 
	  * @param nothing
	  * @return Nothing.
	  */
	public LinkedList()
	{
	front = null;
	end = null;
	}
	/**
	  * inserts state and population 
	  * @param String state and int population
	  * @return Nothing.
	  */
	public void insertLink(String state, int population)
	{
	Node newNode = new Node(state, population);
		
	if(isEmpty())
		{
			newNode.nextNode = null;
			end = newNode;
			front = newNode;
		}
		
		else
		{
			end.nextNode = newNode;
			end = newNode;
		}
	}
	/**
	  * deletes link after finding it
	  * @param String st
	  * @return Nothing.
	  */
	 public void deleteLink(String st) //finds the state name and deletes it
	 {   
		 //points to beginning
		 Node current = front; 
		 Node previous = null;
		 while(!current.stateName.equals(st)) //obtains state name from state class
		 {
			 if(current.nextNode == null)
			 {
				 break;
			 }
			 else
			 {
				 previous = current;
				 current = current.nextNode; //we found the node to be deleted
			 }
		 }
		 
		 if(current == front)
		 {
			 if(front == end)
			 {
				 end = null;
			 }
			 front = front.nextNode;
			
			 
		 }
		 else if(current == end)
		 {
			 end = previous;
			 end.nextNode = null;
		 }
		 
		 else
		 {
			 
			 previous.nextNode = current.nextNode;
		 }
	 }
	 /**
	  * finds state 
	  * @param String st
	  * @return returns false else returns the current state population
	  */
	 public int find(String st) //finds the state name
	 {   
		 //points to beginning
		 Node current = front; 
		 
		 while(!current.stateName.equals(st)) //obtains state name from state class
		 {
			 if(current.nextNode == null)
			 {
				return -1;
			 }
			 else
			 {
				 current = current.nextNode;
			 }
		 }
		 return current.statePopulation;  //found the node
	 }
	 /**
	  * Defines linked list as empty 
	  * @param nothing
	  * @return true or false
	  */
	 public boolean isEmpty()
	 {
		if(end == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	 }
	 /**
	  * prints link list
	  * @param nothing
	  * @return Nothing.
	  */
	 public void printLinkedlist()
	 {
		//points to beginning
		 Node current = front; 
		 if(isEmpty())
		 {
			 System.out.println("Empty");
		 }
		 else
		 {
			 while(true) //obtains state name from state class
			 {
				 if(current.nextNode == null)
				 {
					 if(current!=front)
					 {
					 System.out.printf("\t");
					 } 
					current.printNode();
					break;
				 }
				 else
				 {
					 if(current!=front)
					 {
					 System.out.printf("\t");
					 }
					 current.printNode();
					 
					 current = current.nextNode;
				 }
			 }
		 }
	 }
	 /**
	  * Constructor 
	  * @param nothing
	  * @return false or true
	  */
	 public boolean isCollision()
	 {
	     Node current = front;
	     if(isEmpty() || current.nextNode == null)
	     {
	          return false;
	     }
	     else
	     {
	          return true;
	     }
	 }
}	

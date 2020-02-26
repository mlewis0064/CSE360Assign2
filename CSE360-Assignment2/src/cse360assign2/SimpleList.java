package cse360assign2;

/*
 * This simple list class holds a starting array of 10 integers
 * which can be counted, searched, expanded, and inputed/altered. 
 * 
 * 
 * @author Madeline Lewis
 * @version 2.0
 * Class ID: 204
 * Assignment 2
 *  
 */


public class SimpleList {
	
	private int[] list;
	private int count;
	
	/*
	 * This is the class constructor which instantiates 
	 * the array list with 10 integers. It also sets the global
	 * count integer to zero.
	 */ 
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	
	/*
	 * This public method adds the integer to the front of the 
	 * array and pushes all the other integers in the array
	 * down an index. When the array is full, the size
	 * is increased by 50%. It also updates the counter global variable.
	 * 
	 * @param valueToBeAdded the integer value to be added to the array
	 *  
	 */
	public void add(int valueToBeAdded) {
		// when count = 9, the initial array is full
		if (count < list.length) {
			int farPlaceKeeper = count;
			
			for (int index = count - 1; index >= 0; index--) {
				list[farPlaceKeeper] = list[index];
				farPlaceKeeper--;
			}
			
			list[0] = valueToBeAdded;
			count++;
		} else {
			// if the array is full
			int oldSize = list.length;
			int newSize = oldSize/2 + oldSize;
			int[] newList = new int[newSize];
			
			for (int index = 0; index < oldSize; index++) {
				newList[index] = list[index];
			}
			
			list = newList;
			
			
			int farPlaceKeeper = count;
			
			for (int index = count - 1; index >= 0; index--) {
				list[farPlaceKeeper] = list[index];
				farPlaceKeeper--;
			}
			
			list[0] = valueToBeAdded;
			count++;
			
		}
	}
	
	
	/*
	 * This public method adds the integer to the end of the 
	 * list is the array is full, the size
	 * is increased by 50%. It also updates the counter global variable.
	 * 
	 * @param valueToBeAppened the integer value to be added to the array
	 *  
	 */
	public void append(int valueToBeAppened) {
		if (count < list.length) {
			list[count] = valueToBeAppened;
			count++;
		} else {
			// if the array is already full
			int oldSize = list.length;
			int newSize = oldSize/2 + oldSize;
			int[] newList = new int[newSize];
			
			for (int index = 0; index < oldSize; index++) {
				newList[index] = list[index];
			}
			
			list = newList;
			
			list[count] = valueToBeAppened;
			count++;
		}
		
	}
	
	
	/*
	 * This method removes an integer if it was found to 
	 * be in the array and moves the other integers down to 
	 * fill the gap. If the array is more than 25% empty,
	 * the size is decreased by 25%.
	 * 
	 * @param valueToBeRemoved the integer value to be removed from the array
	 * 
	 */
	public void remove(int valueToBeRemoved) {
		int removeSpot = search(valueToBeRemoved);
		while (removeSpot != -1) {
			if (removeSpot == count - 1) {
				list[count - 1] = 0;
			} else {
				int placeKeeper = removeSpot + 1;
				while (placeKeeper < count) {
					list[removeSpot] = list[placeKeeper];
					placeKeeper++;
					removeSpot++;
				}
				
			}
			
			list[count - 1] = 0;
			count--;
			
			removeSpot = search(valueToBeRemoved);
		}
		
		// check for decrease
		int emptyJudge = (int) (list.length * 0.75);
		if (count < emptyJudge) {
			int oldSize = list.length;
			int newSize = oldSize - oldSize/4;
			int[] newList = new int[newSize];
			
			for (int index = 0; index < newSize; index++) {
				newList[index] = list[index];
			}
			
			list = newList;
			System.out.println("list is now " + list.length);
		}
	}
	
	
	/*
	 * This getter method returns the private count variable
	 * of the SimpleList class.
	 * 
	 * @return int representing the total number of integers that have been added to the array
	 * 
	 */
	public int count() {
		return count;
	}
	
	/*
	 * This getter method returns the first element
	 * of the list.
	 * 
	 * @return int the first element of the list
	 * 
	 */
	public int first() {
		return list[0];
	}
	
	/*
	 * This method returns the overall size (possible locations)
	 * of the list.
	 * 
	 * @return int representing the total number of integers that can be in the list
	 * 
	 */
	public int size() {
		return list.length;
	}
	
	
	/*
	 * This standard method returns the integer array as a string with spaces.
	 * 
	 * @return String the string representation of the integer array list
	 * 
	 */
	public String toString() {
		String stringList = "";
		
		if (count > 0) {
			for(int index = 0; index < count - 1; index++) {
				stringList = stringList + list[index] + " ";
			}
		
			stringList = stringList + list[count - 1];
		}
		
		return stringList;
	}
	
	
	/*
	 * This method searches the array list for the given value to see if it exists. If it does, 
	 * its index in the array will be returned, otherwise -1 will be returned.
	 * 
	 * @return int returns the value position or -1 if it doesn't exist
	 * 
	 */
	public int search(int valueToFind) {
		int indexOfValue = -1;
		
		for (int index = 0; index < count; index++) {
			if (list[index] == valueToFind) {
				if (indexOfValue == -1)
					indexOfValue = index;
			}
		}
		
		return indexOfValue;
	}
	
	
}

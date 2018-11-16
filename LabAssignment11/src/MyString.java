public class MyString {
	public char [] charArray;
	//this class creates a new character array with the characters from the string
	public MyString(String s){
		charArray = new char[s.length()];
		for(int i = 0; i < charArray.length; i++){
			charArray[i] = s.charAt(i);
		}
	}
	//this constructor takes a character array and makes it a MyString object
	public MyString(char [] array ){
		charArray = array;
	}	
	//this class returns the length of the character array
	public int length(){
		int length = charArray.length;
		return length;
	}
	//this class checks if the position is valid, and throws an error if not
	/* if it is, then it gives the character at the position given
	 */
	public char charAt(int position){
		char charAt = 0;
		if(position > charArray.length){
			throw new ArrayIndexOutOfBoundsException();
		}else if(position <= charArray.length){
			charAt = charArray[position];
		}
		return charAt;
	}
	
	
	/**
	 * This method tests whether or not the array is empty by seeing if the length is 0 or not,
	 * and adjusts the boolean accordingly 
	 * @return
	 */
	public boolean isEmpty(){
		boolean empty = true;
		if (charArray.length > 0){
			empty = false;
		}
		return empty;
	}
	/**
	 * this substring class takes a start and an end point and outputs what is between them 
	 * as MyString
	 * @param start
	 * @param end
	 * @return
	 */
	public MyString substring(int start, int end){
		int newLength = end-start;
		char[] newCharArray = new char [newLength];
		if (start <= 0 || end > charArray.length || start > charArray.length || start >= end || start == end){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			MyString strng = new MyString(newCharArray);
			for(int i = 0; i < newLength; i++ ){
				newCharArray[i] = charArray[start + i];
			}
			return strng;
		}
	}
	/**
	 * this substring takes a starting point and outputs everything past that point
	 * as a MyString
	 * @param start
	 * @return
	 */
	public MyString substring(int start){
		int newLength = charArray.length - start;
		char[] newCharArray = new char [newLength];
		MyString newstrng = new MyString (newCharArray);
		if (start <= 0 || start > charArray.length){
			throw new ArrayIndexOutOfBoundsException();
		}else{
		for(int i = 0; i < newLength; i++){
			newCharArray[i] = charArray[start + i];
		}
		return newstrng;
		}
	}
	/**
	 * This method tests what element is in the array at the given position and outputs it as the int loc
	 * @param character
	 * @return
	 */
	public int indexOf(char character){
		int loc = -1;
		for (int i = 0; i < charArray.length; i++){
			if (character == charArray[i]){
				loc = i - 1;
			}
		}
		return loc;
	}
	/**
	 * This replace method inspects each element of the array and evaluates it to see if it is the oldChar,
	 * and if it is, replaces the value in the new array with the newChar
	 * @param oldChar
	 * @param newChar
	 * @return
	 */
	public MyString replace(char oldChar, char newChar){
		char[] newCharArray = new char [charArray.length];
		MyString newstrng = new MyString (newCharArray);
		for(int i = 0; i < charArray.length; i++){
			if (charArray[i] == oldChar){
				newCharArray[i] = newChar;
			}else{
				newCharArray[i] = charArray[i];
			} 
		}
		return newstrng;
	}
}
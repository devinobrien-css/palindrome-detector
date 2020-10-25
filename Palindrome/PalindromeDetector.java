import java.util.*;
/**Palindrome Detector
 * Detects if a word is a palindrome
 * NOTE: a palindrome is a word that is
 * spelled the same forwards and backwards
 * @author Devin O'Brien
 * @version 1.0
 */
public class PalindromeDetector 
{
	/**Initiates palindrome detector
	 * @param args - holds String array of Command Line Arguments
	 */
	public static void main(String [] args)
	{
		System.out.println("\nPALINDROME DETECTOR\n"
						+  "–––––––––––––––––––");
		loop();
	}

	/**Loops the palindrome detector until user quits
	 */
	public static void loop()
	{
		Scanner keyboard = new Scanner(System.in);
		  if(palindrome(0, promptUser(keyboard)))
		  {
			  System.out.println("\nYes, it is a palindrome\n"
			  				   + "–––––––––––––––––––––––");
			  System.out.println("Continue? (Y/N)");
			    if(!keyboard.nextLine().equalsIgnoreCase("Y"))
			    {
			    	System.exit(0);
			    }
			    else
			    	loop();
		  }
		  else 
		  {
			  System.out.println("\nNo it is not a palindrome\n" 
			  				   + "–––––––––––––––––––––––––");
		  	  System.out.println("Continue? (Y/N)");
		  	    if(!keyboard.nextLine().equalsIgnoreCase("Y"))
			    {
			    	System.exit(0);
			    }
		  	    else
		  	    	loop();
		  }
		keyboard.close();
	}
	
	/**Prompts user to enter any word
	 * @param keyboard reads input from keyboard
	 * @return array list of letters in word entered by user
	 */
	public static char[] promptUser(Scanner keyboard)
	{
		System.out.println("\nEnter a word to check : ");
		  char [] array = keyboard.nextLine().toCharArray();
		  return array;
	}
	/**Recursively checks if word is a palindrome
	 * @param n start location of search (always 0)
	 * @param array characters of word
	 * @return false if word is not a palindrome
	 * @return true if word is a palindrome
	 */
	public static boolean palindrome(int n, char [] array)
	{
		if(array[n] != array[(array.length - 1) - n])//BaseCase: break if two letters up for comparison aren't equal
		{
			return false;
		}
			if(array.length % 2 != 0) // if word is odd number of letters
			{
				if(n < ((array.length - 1) / 2))// scan through first half of word 
				{
					if(array[n] == array[(array.length - 1) - n])//compare to second half of word
					{
						return palindrome(n + 1, array);//repeat until fully compared
					}
					else
						return false;
				}
			}
			if(n < (array.length / 2) - 1)//scan through first half of word
			{
				if(array[n] == array[(array.length - 1) - n])//compare to second half of word
				{
					return palindrome(n + 1, array);//repeat until fully compared
				}
				else
					return false;
			}
		return true;
	}
}

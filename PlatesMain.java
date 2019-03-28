import java.util.Set;
import java.util.TreeSet;

public class PlatesMain {
	public static void main(String [] args) {
		String plates = "RRBBWWGG";
		char [] platesChars = plates.toCharArray();
		int shots = 1 * 2 * 3 * 4 * 5 * 6  * 7 * 8;
		int count = 0;
		int workingCount = 0;
		
		System.out.println("Plates program");
		System.out.println("Shots: " + shots);
		System.out.println("-----------------");
		for (String s : PlatesMain.permute(plates))
	    {
			boolean works = false;
			for(int index = 0; index != plates.length(); index++) {
				if(s.charAt(index) == plates.charAt(index)) {
					works = false;
					break;
				}
				else {
					works = true;
				}
			}
			if(works == true) workingCount++;
			System.out.println(s + ((works == true) ? " Works" : ""));
			count++;
	    }
		
		System.out.println("------------------");
		System.out.println("Plates: " + plates);
		System.out.println("Runs: " + count);
		System.out.println("Working count: " + workingCount);
	}
	
	public static Set<String> permute(String chars)
	  {
	    // Use sets to eliminate semantic duplicates (aab is still aab even if you switch the two 'a's)
	    // Switch to HashSet for better performance
	    Set<String> set = new TreeSet<String>();

	    // Termination condition: only 1 permutation for a string of length 1
	    if (chars.length() == 1)
	    {
	      set.add(chars);
	    }
	    else
	    {
	      // Give each character a chance to be the first in the permuted string
	      for (int i=0; i<chars.length(); i++)
	      {
	        // Remove the character at index i from the string
	        String pre = chars.substring(0, i);
	        String post = chars.substring(i+1);
	        String remaining = pre+post;

	        // Recurse to find all the permutations of the remaining chars
	        for (String permutation : permute(remaining))
	        {
	          // Concatenate the first character with the permutations of the remaining chars
	          set.add(chars.charAt(i) + permutation);
	        }
	      }
	    }
	    return set;
	  }
}

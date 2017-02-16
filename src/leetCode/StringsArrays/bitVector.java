package ArraysStrings;

public class bitVector {

	public static void main(String args[]){
		int checker = 0;
		String str = "Pooja Gupta";
		for(int i=0; i<str.length(); i++){
			int char_id = str.charAt(i) - 'a';
			if((checker & (1 << char_id)) > 0){
				System.out.println("Character reapeated - " + str.charAt(i));
			}
			checker |= (1 << char_id);
		}
	}
}
 
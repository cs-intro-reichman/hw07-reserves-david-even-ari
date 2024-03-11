
public class SpellChecker {


	public static void main(String[] args) {

  		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	 
	}
	public static String tail(String str) {
        return str.substring(1);}

		

	public static int levenshtein(String word1, String word2) {
	String a = word1.toLowerCase();
	String b = word2.toLowerCase();

	if (b.length() == 0){
		return a.length();
	}
	if (a.length() == 0){
		return b.length();
	}
	if (a.charAt(0)==b.charAt(0)){
		return levenshtein(tail(a),tail(b));
	}
	else {

     return (1+ Math.min(Math.min(levenshtein(tail(a),b), levenshtein(a, tail(b))), levenshtein(tail(a), tail(b))));

		}	 
	
	}


	

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for  (int i =0 ;i<3000;i++){
		dictionary[i]=in.readString();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
	int[] index= new int[3000];

	for(int i =0 ; i<3000 ;i++){
	index[i]=levenshtein(word, dictionary[i]);
    }
    int min =index[0];
	int j =0;
	for(int i =1 ; i<3000 ;i++){
        if (min>index[i]){
           min =index[i];
		   j = i;
		}}
		if (threshold<index[j]){
			return word;
		}
		return dictionary[j];

	}}


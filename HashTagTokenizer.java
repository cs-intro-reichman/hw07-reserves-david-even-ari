

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for  (int i =0 ;i<3000;i++){
		dictionary[i]=in.readString();
		}

	

		return dictionary;
	}

	/**
	 * @param word
	 * @param dictionary
	 * @return
	 */
	public static boolean existInDictionary(String word, String []dictionary) {
		int low =0;
		int high = dictionary.length-1;
		boolean flag = false;
		while (low<=high) {
			 int med = (int)(high+low) /2;
			 String target = dictionary[med];
			 int a= word.compareTo(target);
			 if(a == 0 ){
				flag=true;
				break; }
			if(a<0){
				high=med-1;
			} else{
                low = med +1;}

				}	
		return flag;
	}

	private static void compareTo(String target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			String chek =hashtag.substring(0,i);
			if(existInDictionary(chek.toLowerCase(), dictionary)) {
				System.out.println(chek.toLowerCase());
				breakHashTag(hashtag.substring(i,N), dictionary);
			}

		
        }
    }

}

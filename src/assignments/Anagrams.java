package assignments;

import java.util.*;
public class Anagrams
{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();

        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        for(int i = 0; i < n; i++)
            count += isAnagramUsingHashMap(str1, sc.nextLine()) ? 1 : 0;
        
        System.out.println(count);

        // System.out.println(isAnagram(str1, str2));
        // System.out.println(isAnagramUsingHashMap(str1, str2));
        // System.out.println(isAnagramUsingBacktracking(str1,str2));
	}

    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        int a1[] = new int[26];
        int a2[] = new int[26];
        for(int i = 0; i < str1.length(); i++){
            a1[str1.charAt(i) - 'a']++;
            a2[str2.charAt(i) - 'a']++;
        }

        return Arrays.equals(a1,a2);
    }

    
    
    public static boolean isAnagramUsingHashMap(String str1, String str2){
        
        if(str1.length() != str2.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str1.length(); i++)
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),0)+1);

        for(int i = 0; i < str2.length(); i++){

            if(map.containsKey(str2.charAt(i)) && map.get(str2.charAt(i)) > 0)
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            else 
                return false;

        }
        return true;
        
    }

    /*
        str1 = dusty 
        str2 = study


    
    */

    public static boolean isAnagramUsingBacktracking(String str1, String str2){
        return helperForBackTracking(str2.toCharArray(), str1, 0);
    }

    public static boolean helperForBackTracking(char[] str, String strToComapre, int pos){
        if(pos >= str.length)
            return strToComapre.equals(new String(str));
        
        
        for(int i = pos; i < str.length; i++){
            swap(str, i, pos);
            if(helperForBackTracking(str, strToComapre, pos + 1))
                return true;
            swap(str, pos, i);
        }

        return false;
    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
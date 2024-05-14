package org.example.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        String[] words = {"ab", "cd", "ef", "gh"};
//        String s = "wordgoodgoodgoodbestword";
//        System.out.println(indexes(s, words));
        String[] result = getAll(words);
        for(String s:result){
            System.out.println(s);
        }

    }

//    public static List<Integer> indexes(String s, String[] words){
//        Set<Integer> set = new HashSet<>();
//        String[] result = getAll(words);
//        for(String word : result){
//            if(s.contains(word)){
//                set.add(s.indexOf(word));
//            }
//        }
//        return new ArrayList<>(set);
//    }

    public static String[] getAll(String[] original){
        int n = original.length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            StringBuilder s = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                s.append(original[(i + j)%n]);
            }
            set.add(s.toString());

            for(int j = n - 1; j >= 0; j--){
                sb.append(original[(i + j)%n]);
            }
            set.add(sb.toString());
        }
        String[] result = set.toArray(new String[0]);
        return result;
    }
}

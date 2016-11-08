package com.lab.pkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q451 {

	public String frequencySort(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        int l = s.length();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0 ;i < l; i++){
            char chr = s.charAt(i);
            if(map.get(chr) != null){
                map.put(chr, map.get(chr)+1);
            }else{
                map.put(chr, 1);
            }
        }
        
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Character, Integer>>(){
            @Override
			public
            int compare(Entry<Character, Integer> a, Entry<Character, Integer> b){
                return  b.getValue() - a.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        int length = list.size();
        for(int i = 0; i < length; i++){
            char c = list.get(i).getKey();
            int j = list.get(i).getValue();
            for(int k = 1; k <= j; k++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

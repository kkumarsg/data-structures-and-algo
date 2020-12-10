package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubSequenceOfAString {


    public static void main(String[] args)
    {
        System.out.println(getSubSequenceList("abcdef").size());
    }

    public static Set<String> getSubSequenceList(String s){
        Set<String> sequence = new HashSet<>();
        if(s.length()==1){
            sequence.add(String.valueOf(s.charAt(0)));
            return sequence;
        }
        Set<String> minorSequence = getSubSequenceList(s.substring(1));
        sequence.add(String.valueOf(s.charAt(0)));
        for(String str: minorSequence){
            sequence.add(str);
            sequence.add(s.charAt(0)+str);
        }
        return sequence;
    }

}

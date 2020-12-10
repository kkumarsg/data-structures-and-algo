package stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] inputs = {60,10,20,40,35,38,50,70,65};
        findSpanArray(inputs);

    }

    public static int[] findSpanArray(int[] input){
        int[] spanArray = new int[input.length];
        int[] prevGreaterElement = new int[input.length];

        prevGreaterElement[0] = -1;
        for(int i=1; i<input.length; i++){
            if(input[i]<input[i-1]){
                prevGreaterElement[i] = i-1;
            }
            else if(input[i]==input[i-1]){
                prevGreaterElement[i] = prevGreaterElement[i-1];
            }
            else {
                int prev = i-1;
                while(prevGreaterElement[prev]!=-1 && input[prevGreaterElement[prev]]<input[i]){
                    prev = prevGreaterElement[prev];
                }
                prevGreaterElement[i] = prevGreaterElement[prev];
            }
        }
        for(int i=0; i<input.length; i++){
            if(prevGreaterElement[i]==-1){
                spanArray[i] = i+1;
            }
            else{
                spanArray[i] = i-prevGreaterElement[i];
            }
        }
        return spanArray;
    }
}

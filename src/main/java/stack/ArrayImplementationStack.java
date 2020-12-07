package stack;

public class ArrayImplementationStack {

    int[] elements;
    int top = -1;

    public ArrayImplementationStack(int maxSize) {
        elements = new int[maxSize];
    }

    public void pushElement(int ele) throws Exception {
        if(top<elements.length){
            top = top+1;
            elements[top] = ele;
        }
        else{
            throw new Exception("Stack is full try popping out before pushing ");
        }
    }

    public int popElement() throws Exception {
        if(top<0){
            throw new Exception("Stack is empty, try pushing some elements ");
        }
        int last = elements[top];
        elements[top] = 0;
        top = top - 1;
        return last;
    }

    public int size(){
        return top;
    }
}

class Runner{
    public static void main(String[] args) throws Exception {
        ArrayImplementationStack stack = new ArrayImplementationStack(10);
        stack.pushElement(5);
        stack.pushElement(10);
        stack.pushElement(15);
        System.out.println("stack.popElement() = " + stack.popElement());
        stack.pushElement(20);
        stack.pushElement(30);

        System.out.println("stack.popElement() = " + stack.popElement());
        System.out.println("stack.popElement() = " + stack.popElement());
        System.out.println("stack.popElement() = " + stack.popElement());
        System.out.println("stack.popElement() = " + stack.popElement());

        stack.pushElement(4);
        System.out.println("stack.popElement() = " + stack.popElement());
        System.out.println("stack.popElement() = " + stack.popElement());
    }
}

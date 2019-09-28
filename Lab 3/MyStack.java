//Start of MyStack.java

package myLab3;

/*
 * Syed-Murtaza Hasan
 * hasans25
 * 400128544
 */


import java.util.EmptyStackException;

public class MyStack {
    private SLLNode head;
    //public int sizeof;
    //creates a stack that is empty
    public MyStack() {
        //sizeof = 0;
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }
    //pushes an elem into the stack
    public void push(TNode v) {
        //sizeof = sizeof + 1;
        head = new SLLNode(v, head);
    }
    //takes an elem off of the stack to return it at the back
    public TNode pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("**Underflow**");
        } else {
            TNode e = head.element;
            //sizeof -= sizeof;
            head = head.next;
            return e;
        }
    }

    public TNode top() throws IllegalArgumentException {
        if (isEmpty() == true) {
            throw new IllegalArgumentException("**Underflow**");
        } else {
            return (head.element);
        }
    }
}

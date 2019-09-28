//Start of SLLNode.java

package myLab3;
/*
 * Syed-Murtaza Hasan
 * hasans25
 * 400128544
 */
public class SLLNode {
    public TNode element;
    public SLLNode next;

    public SLLNode (TNode e, SLLNode n) {
        this.element = e;
        this.next = n;
    }
}

//end of the class
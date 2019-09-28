package myLab3;

/*
 * Syed-Murtaza Hasan
 * hasans25
 * 400128544
 */

public class BSTSet {
    //one and only private field named root
    private TNode root;

    //One of the two constructor
    //Initialize the obj to rep. empty set

    public BSTSet() {
        root = null;
    }

    //Second of the two constructor
    //initializes the obj to rep. the set containing the inouts without repetitions of the same number/input.
    //ex. {1,2,3,4,5,6,5} --> {1,2,3,4,5,6}

    public BSTSet (int[] input) {
        int j;
        root = new TNode(input[0], null, null);
        for (j = 1; j < input.length; j++) {
            this.add(input[j]);
        }
    }

    //First of the 10 methods

    public boolean isIn (int v) {
        //Returns true if the asked integer is an elem of this BSTSet otherwise will return false.
        //this.element = e;
        //this.next = n;
        TNode x = root;
        //iterates through until null or to the num to find the entered number
        while (x != null) {
            if(x.element == v) {
                return true; //Found
            } else if (v < x.element) {
                x = x.left; //Not found --> Move to the left
            } else if (v > x.element) {
                x = x.right; //Not found --> Move to the right
            }
        }
        //Since its already formatted, code isn't too complicated
        return false; //Could not be found.

    }

    //     Start of add operation      //

    public void add(int v) {
        //takes v to the particular BSTSet if v wasn't already
        //Step 1: Check if v exists by running the constructor
        //Step 2: Add v to BSTSet if constructor came back false
        boolean check = true;
        check = isIn(v);

        if (root == null) {
            root = new TNode(v, null, null);
        }
        if (check == false) {
            this.add_another(v, root);
        }

    }

    private TNode add_another (int counter, TNode x) {
        if (root == null) {
            root = new TNode(counter, null, null);
            //We do this again but we check if set is empty & then create a new node.
        } else if (counter > x.element) {
            //if setting statement wasn't true then iterate again through this method to run again with moving to the right
            x.right = add_another(counter, x.right);
        } else if (counter < x.element) {
            //move to left and iterate the method again
            x.left = add_another(counter, x.left);
        }
        return x;
    }

    //     Start of remove operation     //

    public boolean remove (int v) {
        //removes v from BSTSet
        //Step 1: Check to see if v is an element
        //Step 2: If v is an elem, proceed to step 4, otherwise return false
        //Step 3: after removing the elem by making it null and moving the elems in appropriate direction

        boolean check;
        check = isIn(v);
        //Step 1 complete
        if (check == false) {
            return false;
            //Step 2 Complete
        } else if (check == true) {
            remove_another(v, root);
            return true;
        }
        return false;
    }

    private TNode minPosfinder (TNode x) {
        while(x.left != null){     //Left is where the smallest num is
            x = x.left;            //Consistently moves left to find start/min value
        }
        return x;
    }

    private TNode minValremover (TNode x) {
        if (x.left == null) {
            return x.right;
        } else if (x.left != null) {
            x.left = minValremover(x.left);
        } else {
            return x;
        }
        return x;
    }

    private TNode remove_another (int v, TNode x) {
        //input is less than x elem, remove left elem
        if (v > x.element) {
            x.right = remove_another(v, x.right);
        } else if (v < x.element) {
            //same as above but instead with greater value to remove right sub elem
            x.left = remove_another(v, x.left);
        } else if (x.right != null && x.left != null) {
            //another case of only 2 childs
            x.element = (minPosfinder(x.right)).element;
            //run minPosfinder on the right stree
            x.right = minValremover(x.right);
            //remove the val in the right stree
        } else {
            //another case but only for 1 child.
            if(x.left != null) {x = x.left;}
            else {x = x.right;}
        }
        return x;

    }

    //     end of remove operation     //
    //ifNull() is used later to find is the particular set is empty or not

    private boolean ifNull () {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public BSTSet union (BSTSet s) {
        if (s.ifNull() == true) {// checks to see if s is null or not
            BSTSet anotherSet0 = this;
            return anotherSet0;
        } else if (this.ifNull() == true) {//we switched this, and now we check this if it is empty.
            BSTSet anotherSet0 = s;
            return anotherSet0;
        } else {
            return this.anotherUnion(s.root);
        }
    }

    private BSTSet anotherUnion (TNode x) {
        BSTSet anotherCopy0 = this;
        if (x != null) {//only run this when x is opposite of null
            anotherCopy0.add(x.element); //this method is used to make sure to not add any elem thats already in there.
            anotherCopy0.anotherUnion(x.right); //adding node values into the new BSTSet from the right subtree
            anotherCopy0.anotherUnion(x.left); //same this as above but except in the left subtree.
        }
        return anotherCopy0;
    }

    public BSTSet intersection (BSTSet s) {
        int counter = 0;
        int[] anotherArray = new int [s.size() + this.size()];
        TNode x = s.root;
        if (x != null && this.isIn(x.element)) {
            anotherArray [counter] = x.element;
            counter++;
        }
        if (x != null) {
            while (x.left != null) {
                x = x.left;
                if (this.isIn(x.element)) {
                    anotherArray[counter] = x.element;
                    counter++;
                }
            }
            while (x != null) {
                x = x.right;
                if (this.isIn(x.element)) {
                    anotherArray [counter] = x.element;
                    counter++;
                }
            }
        }
        BSTSet anotherSet = new BSTSet (anotherArray);
        return anotherSet;


    }
    //     Start of size operation     //
    public int size () {
        return another_size(root);
    }

    private int another_size (TNode x) {
        if (x == null) {
            return 0;
        } else {
            int num = another_size(x.left) + 1 + another_size(x.right);
            return num;
        }
    }

    public int height () {
        return another_height(root);
    }

    private int another_height (TNode x) {
        if (x == null) {
            return -1;
        } else {
            int temp = Math.max(another_height(x.left) + 1,  another_height(x.right) + 1);
            return temp;
        }
    }
    //Two methods below are given methods in the lab description
    public void printBSTSet () {
        if (root == null) {
            System.out.println("The set is empty");
        } else {
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }

    private void printBSTSet (TNode t) {
        if (t != null) {
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }

    private int biggestNum(TNode x) {
        if (x.right == null) {return x.element;}
        else {return biggestNum(x.right);}
    }

    public void printNonRec () {
        MyStack nS = new MyStack();
        TNode x = root;
        int maxNum = biggestNum(root);
        if (root == null) { // a case for an empty stack
            System.out.println("particular Set is null");
        }
        while (x != null) { //this will push elems into the stack to the left until iterated
            nS.push(x);
            x = x.left;
        }
        do {
            //this will pop an element
            x = nS.pop();
            System.out.print(x.element + ", ");
            if (x.element == maxNum) {
                break;
            } else if (x.right != null) {
                x = x.right; //case if the right child exists
                while (x != null) { //push elements into stack until leftmost is run
                    nS.push(x);
                    x = x.left;
                }
            }
        } while (true);
    }

}

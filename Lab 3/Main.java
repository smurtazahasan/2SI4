//Syed-Murtaza Hasan

package myLab3;

public class Main {

    public static void main(String[] args) {

        int[] array0 = {1, 3, 2 ,6,6 9};
        int[] anotherArray = {};
        BSTSet set0= new BSTSet(array0);
        BSTSet set1= new BSTSet(anotherArray);
        System.out.print("Expected to be Empty ");
        set0.printBSTSet();
        set1.printBSTSet();
        System.out.println("\n Size Set0 " + set0.size());
        System.out.println("Expected True: " + set0.isIn(9));
        System.out.println("Expected False: " + set1.isIn(0));
        int[] arr0={4, 9, 3, 4, 6, 2, 5, 3, 10, 2};
        BSTSet set2=  new BSTSet(arr0);
        set2.printBSTSet();
        System.out.println("\n Set 2 above, Set 3 below ");
        set2.printBSTSet();
        BSTSet another5= set1.union(set2);
        another5.printBSTSet();
        System.out.println("Height of another5 null or -1 " + set2.height());
    }
}

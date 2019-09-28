package myLab4;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("\n Linear Probing \n\n");
        HashTableLin newHash1 = new HashTableLin(5,0.4);
        System.out.println("Size: --> " + newHash1.getSize() + ", Load Factor: --> " + newHash1.getLambda());
        newHash1.insert(12);
        newHash1.insert(29);
        newHash1.insert(21);
        newHash1.insert(10);
        newHash1.insert(19);
        newHash1.insert(19);

        newHash1.insert(90);

        System.out.println("Value 100 in T or F: " + newHash1.isIn(100));
        System.out.println("Value 29 in T or F: " + newHash1.isIn(29));

        newHash1.insert(200);
        newHash1.insert(3000);
        newHash1.insert(128);
        newHash1.insert(11);
        newHash1.printKeysAndIndexes();

        System.out.println("Table Size of LIN " + newHash1.getSize());
        System.out.println("Sum of Keys is " + newHash1.getSumofkeys());
        System.out.println("Max Load (Lambda) " + newHash1.getLambda());





        System.out.println("\n\n Quadratic Probing \n\n");


        HashTableQuad newHash2 = new HashTableQuad(10,0.8);

        System.out.println("Size: " + newHash2.getSize() + ", Load: " + newHash2.getLambda());
        newHash2.insert(12);
        newHash2.insert(1032);
        newHash2.insert(61);
        newHash2.insert(64);
        newHash2.insert(87);
        newHash2.insert(1004);
        newHash2.insert(556);
        newHash2.insert(9000);
        newHash2.insert(10);

        newHash2.insert(700);

        System.out.println("Value 9000 T or F: " + newHash2.isIn(9000));
        System.out.println("Value 1000000 T or F: " + newHash2.isIn(1000000));

        newHash2.printKeysAndIndexes();

        System.out.println("Size of newHash2: " + newHash2.getSize());
        System.out.println("Sum of Keys: " + newHash2.getSumofkeys());
        System.out.println("Load: " + newHash2.getLambda());

        newHash2.printKeys();
    }
}

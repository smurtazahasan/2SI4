package myLab4;

public class HashTableLin {
    private Integer[] Htable;
    private int Size;
    private int sumofkeys;
    private double lambda;
    private int[] empty;

    public HashTableLin (int maxNum, double load) {
        double temp_size = maxNum/load;
        int i = (int) temp_size;
        int Size = checkforprime(i);

        this.Size = Size;
        this.sumofkeys = 0;
        this.lambda = load;

        Integer[] x = new Integer[Size];
        this.Htable = x;

        int []y = new int[Size];
        this.empty = y;


    }

    public int checkforprime (int num0) {
        int j;
        num0 = num0 + 1;
        while(true) {
            j = 0;
            for (int counter = 2; counter <= Math.sqrt(num0); counter++) {
                if (num0 % counter == 0) {
                    j = j + 1;
                }
            }
            if (j == 0) {
                return num0;
            } else {
                num0 = num0 + 1;
                continue;
            }
        }
    }

    public boolean completeCheck() {
        for (int j = 0; j < this.Size; j++) {
            if (empty[j]==0) {
                return false;
            }
        }
        return true;
    }

    public void insert (int n) {
        if (n < 0) {
            n = Math.abs(n);
        }
        int j, a;
        boolean completeCheck = completeCheck();
        boolean checker = isIn(n);

        if (checker ==  true) {
            //This will only return if the key already exists
            return;
        } else if (completeCheck == true) {
            System.out.println("Hash Table is filled, no empty spots available");
        } else {
            this.sumofkeys++;
            float anotherLoad;
            anotherLoad = (float)this.sumofkeys/(float)this.Size;
            if(anotherLoad > this.lambda) {
                this.sumofkeys -= 1;
                rehash();
                insert(n);
            } else {
                int posFinder = n % this.Size;
                if (empty[posFinder] == 0) {
                    this.Htable[posFinder] = n;
                    empty[posFinder] = 1;
                    return;
                } else {
                    for (j = posFinder; j < this.Size; j++) {
                        if(this.empty[j] == 0) {
                            this.Htable[j] = n;
                            this.empty[j] = 1;
                            return;
                        }
                        if (j == (this.Size -1)) {
                            for (a = 0; a < posFinder; a++) {
                                if(this.empty[a] == 0) {
                                    this.Htable[a] = n;
                                    this.empty[a] = 1;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void rehash() {
        int[] anotherArray;
        //int i;
        anotherArray = new int[this.sumofkeys];
        int anothercounter = 0;
        for(int i = 0; i < this.Size; i++){
            if(this.empty[i] == 1){
                anotherArray[anothercounter] = this.Htable[i];
                anothercounter++;
            }
        }

        int Size = (this.Size*2);
        Size = checkforprime(Size);

        System.out.println("Table Rehashed from " + this.Size + " to " + Size);

        this.Size = Size;
        int[] anotherEmpty = new int[this.Size];
        this.empty = anotherEmpty;

        Integer[] table = new Integer[this.Size];
        this.Htable = table;

        int anotherSum = this.sumofkeys;
        this.sumofkeys = 0;

        for(int count = 0; count < anotherSum; count++){
            insert(anotherArray[count]);
        }
    }

    public boolean isIn (int n) {
        int posfinder = n % this.Size;
        for (int i = posfinder; i < this.Size; i++) {
            if((empty[i] == 1) && (this.Htable[i] == n)) {
                return true;
            }
            if (i == (this.Size-1)) {
                for (int a = 0; a < posfinder; a++) {
                    if((empty[a] == 1) && (this.Htable[a] == n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void printKeys() {
        for (int j = 0; j < this.Size; j++) {
            if (Htable[j] != null) {
                System.out.println(Htable[j]);
            }
        }
    }

    public void printKeysAndIndexes() {
        for (int j = 0; j < this.Size; j++) {
            if (this.empty[j] == 1){
                System.out.println("Index value " + j + " is equivalent to" + this.Htable[j]);
            }
        }
    }

    public int getSize(){
        return Size;
    }

    public int getSumofkeys(){
        return sumofkeys;
    }

    public double getLambda(){
        return lambda;
    }

}

package com.datastructures;

public class Array {
    protected int[] arr;
    protected int counter,indexSize;
        Array(){
            counter = 0;
        }
        Array(int indexSize){
            this.indexSize = indexSize;
            arr = new int[indexSize];
        }
        public void insert(int item){
            if(counter >= indexSize){
               int[] temp = new int[counter + 1];
               for(int i = 0; i < counter; i++)
                   temp[i] = arr[i];
               temp[counter++] = item;
                arr = temp;
            }
            else{
                arr[counter++] = item;
            }
        }
        public void Print(){
            System.out.println("  ");
            for(int i = 0; i < counter; i++)
                System.out.print(arr[i] + " ");
        }
        public void removeAt(int index){
            if(index < 0 || index >= counter)
                throw new IllegalArgumentException();
             else{
                if (index == counter - 1) {
                    arr[index] = 0;
                    counter--;
                } else {
                    for (int i = index; i < counter - 1; i++)
                        arr[i] = arr[i + 1];
                    arr[counter - 1] = 0;
                    counter--;
                }
            }
        }
        public int indexOf(int number){
            for(int i = 0; i<counter; i++) {
                if (arr[i] == number) {
                    return i;
                }
            }
            return -1;
        }

}
class ArrayExtension extends Array{
    private int maximum;
    ArrayExtension(int indexSize){
        super(indexSize);
    }
    public int max(){
        maximum = arr[0];
        for(int i = 1; i < counter; i++){
            if(maximum < arr[i]) {
                maximum = arr[i];
            }
        }
        return maximum;
    }
    public int intersect(){

        for(int i = 0; i < counter-1 ; i++)
            for(int j = i + 1 ; j < counter; j++)
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
        return -1;
    }

    public void reverse(){
        for(int i = counter - 1; i > -1 ; i--)
            System.out.print(arr[i] + "\t");
    }
    public void insertAt(int item, int index) {
        if (index < 0 || index > counter) {
            throw new IllegalArgumentException();
        }
        else if (index == counter) {
            insert(item);
        } else{
            insert(0);
            for(int i = counter - 2  ; i >= index; i--)
                arr[i+1] = arr[i];
            arr[index] = item;
        }
    }
}
// call code from main class

/*


ArrayExtension numbers = new ArrayExtension(3);
        for(int i = 10; i <= 50; i = i + 10)
            numbers.insert(i);
        numbers.Print();
        numbers.removeAt(4);
        numbers.Print();
        numbers.removeAt(0);
        numbers.Print();
        numbers.removeAt(2);
        numbers.Print();
        numbers.insert(50);
        numbers.insert(60);
        numbers.insert(70);
        numbers.insert(70);

        numbers.Print();
        System.out.println("\nThe number on arr["+numbers.indexOf(60)+"] index number.");
        System.out.println(numbers.max());
        System.out.print("Two Elements intersect - ");
        System.out.print((numbers.intersect() > 0) ? "Yes" : "No");
        System.out.println();
        System.out.println();
        numbers.reverse();

        System.out.println();
        numbers.Print();
        numbers.insertAt(100,1);
        numbers.Print();
*/

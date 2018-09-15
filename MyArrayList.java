import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.Arrays;

public class MyArrayList<T>{

    private Object[] values;
    private int size;

    public MyArrayList(){
        values = new Object[10];
    }
    public MyArrayList(int initialCapacity) throws IllegalArgumentException{
        if(initialCapacity<0){
            throw new IllegalArgumentException();
        }
        values = new Object[initialCapacity];

    }
    public void add(int index, T value) throws MyIndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        }
        if(size == values.length){
            ensureCapacity();
        }
        for (int i = values.length-1; i > index; i--) {
            if(i>=index+1) {

                values[i] = values[i-1];
            }
        }
        values[index] = value;
        size++;
    }
    public void add(T value){
        int i = values.length;
        boolean resize = false;
        if(size == values.length){
            ensureCapacity();
            resize = true;
        }
        if(resize == true) {
            values[i] = value;
        }else {
            values[size] = value;
        }
        size++;


    }
    public void addFront(T value){
        if(size == values.length){
            ensureCapacity();
        }
        for (int i = values.length-1; i > 0; i--) {
            if(i>=1) {

                values[i] = values[i-1];
            }
        }

        values[0] = value;
        size++;

    }
    public void clear(){
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
        size = 0;

    }
    public boolean contains(T value){
        if(indexOf(value)==-1){
            return false;
        }
        return true;
    }
    public void ensureCapacity(){
        Object[] temp = new Object[size*2];
        for (int i = 0; i < values.length; i++) {
            temp[i] = values[i];
        }
        this.values = temp;
    }

    @Override
    public boolean equals(Object o) {
        if(values == null){
            return false;
        }
        if (o instanceof MyArrayList){
            return Arrays.equals(values, ((MyArrayList) o).values);
        }
        return false;
    }
    public int indexOf(T value){
        if(value == null){
            for (int i = 0; i < size; i++) {
                if(values[i]==null){
                    return i;
                }
            }
            return -1;
        }else if(value != null){
            for (int i = 0; i < size; i++) {
                if(values[i] != null && values[i].equals(value)){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void remove(int index) throws MyIndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < values.length; i++) {
            if(i<values.length-1) {
                values[i] = values[i + 1];
            }else{
                values[i]=null;
            }
        }
        size--;

    }
    public boolean remove(T value){
        if(indexOf(value)==-1){
            return false;
        }
        remove(indexOf(value));

        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index)throws MyIndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        }
        return (T) values[index];

    }
    public void set(int index, T value)throws MyIndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        }
        values[index] = value;

    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(values[i]);
            if(i != size-1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        String string = stringBuilder.toString();
        return string;
    }
}

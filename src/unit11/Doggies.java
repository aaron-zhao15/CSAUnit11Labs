package unit11;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.Arrays;
import java.util.Collections;

public class Doggies {

    private Dog[] pups;

    public Doggies(int size) {
        //point pups at a new arry of Dog
        pups = new Dog[size];
    }

    public void set(int spot, int age, String name) {
        //put a new Dog in the array at spot 
        //make sure spot is in bounds	
        Dog dog = new Dog(age, name);
        if(spot < pups.length){
            pups[spot] = dog;
        }
    }

    public String getNameOfOldest() {
        int oldestAge = -1;
        int indexOfOldest = -1;
        for(int i = 0; i < pups.length; i++){
            if(pups[i].getAge()>oldestAge){
                oldestAge = pups[i].getAge();
                indexOfOldest = i;
            }
        }
        return pups[indexOfOldest].getName();
    }

    public String getNameOfYoungest() {
        int youngestAge = pups[0].getAge();
        int indexOfYoungest = 0;
        for(int i = 0; i < pups.length; i++){
            if(pups[i].getAge()<youngestAge){
                youngestAge = pups[i].getAge();
                indexOfYoungest = i;
            }
        }
        return pups[indexOfYoungest].getName();
    }

    public String toString() {
        return "" + Arrays.toString(pups);
    }
}

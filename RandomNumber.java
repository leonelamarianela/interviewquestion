package framework.InterviewTasks;

import java.util.Random;

/**
 * Created by Leonela on 6/13/2018.
 */
public class RandomNumber {

    private static int [] anArray;

    public static int [] list() {
        anArray = new int[499];
        return anArray;
    }

    public static void print() {
        for (int n : anArray) {
            System.out.println(n + " ");
        }
    }


    public static int randomFill() {
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
    }

    public static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }

        }
        return minValue;
    }


    public static void main(String args[]) {
        list();
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = randomFill();
        }
        print();
        System.out.println("min value :" + getMinValue(anArray));
    }


}


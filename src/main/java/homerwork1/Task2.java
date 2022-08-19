package homerwork1;

public class Task2 {

    public static void main(String[] args) {
        int num_arr[] = {3, 7, 6, 13, 33, 9, -100, 25};


        int max = num_arr[0];
        int min = num_arr[0];
        int k = 0;

        while (k < num_arr.length) {
            System.out.print(num_arr[k] + " ");
            if (num_arr[k] > max) {
                max = num_arr[k];
            }

            if (num_arr[k] < min) {
                min = num_arr[k];
            }
            k++;


        }

        System.out.println("\nthe biggest value is: " + max + "\n the min value is: " + min);
    }

}

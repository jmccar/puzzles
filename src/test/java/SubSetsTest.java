import org.junit.Test;

import static org.junit.Assert.*;

public class SubSetsTest {



    @Test
    public  void mainTest(){




        /*int[] sorted = sortArray(inputs);

        printarr(inputs);
        System.out.println("Sorted");

        printarr(sorted);



        //Solution sln = new Solution();

       // System.out.print(getsubsets(inputs));

       int[][] results =null;
       int[][] existingsubset= { { 1, 2 }, { 3, 4, 5 } };

       results = addsubset(inputs,results,existingsubset);
       print2d(results);


     int[][] array1 = { { 3 }};
       int[][] array2 = {{2} };


       int[][] arrInt = mergesubsets(array1,array2);
*/



        testdefault();
        //  testlowerinloop();

    }

    @Test
    public void testdefault(){


        //    int[] inputs = {1,2,3};

        int[] inputs={ 20, 15, 10, 1, 19, 2, 13, 3, 7 };

        int[][] arrInt = SubSets.getsubsets(inputs);



        System.out.println("================ unsorted");
        print2d(arrInt);


    }



    @Test
    static void testlowerinloop(){
        int[] array1 = {1,2,3};
        int[] array2 = {1,3};

        printarr(SubSets.findlowerinLoop(array1,array2,2));
    }


    private static void print2d( int[][] arrInt){

        for (int[] curarr : arrInt) {


            for (int curelem: curarr)
                System.out.print(curelem + " ");

            System.out.println("");
        }


    }

    private static void printarr(int[] arrInt){


        if(null == arrInt){
            System.out.println("array null");
            return;
        }
        for (int anArrInt : arrInt) {

            System.out.print(anArrInt + " ");


        }
        System.out.println("");

    }

}
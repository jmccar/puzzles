import java.util.*;

 
    
public class SubSets {
    
    
     public static void main(String a[]){




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

     static void testdefault(){

        
        int[] inputs = {1,2,3};

      int[][] arrInt = getsubsets(inputs);

  
   
         System.out.println("================ unsorted");
        print2d(arrInt);
   
        
     }
     static void testlowerinloop(){
        int[] array1 = {1,2,3};
        int[] array2 = {1,3};

        printarr(findlowerinLoop(array1,array2,2));
     }
     static  int[] findlowerinLoop(int[] array1,int[] array2,int size) {


        
        for(int i=0;i<size;i++){
          if(array1[i] == array2[i])
                continue;
            else if(array1[i] < array2[i])
                return array1;
            else if(array1[i] > array2[i])
                return array2;

            }
       return null;         
     
    }


     static void print2d( int[][] arrInt){

        for (int i = 0; i < arrInt.length; i++) {           

            
                for (int j = 0; j < arrInt[i].length; j++) 
                    System.out.print(arrInt[i][j] + " ");
            
            System.out.println("");
        }

        
     }

     static void printarr( int[] arrInt){

        
        if(null == arrInt){
            System.out.println("array null");
            return;
        }
        for (int i = 0; i < arrInt.length; i++) {           
            
                System.out.print(arrInt[i] + " ");
            
          
        }
        System.out.println("");
        
     }
     /*

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
     */


    static  int[] copy(int[] inputs) {

        int[] results = new int[inputs.length];
        for(int i=0;i<inputs.length;i++)
            results[i]=inputs[i];

        return results;



    }
    static  int[] sortArray(int[] inp) {

        int[] inputs = copy(inp);

        for(int i=0;i<inputs.length;i++){

            for(int j=i+1;j<inputs.length;j++){
                if(inputs[i] > inputs[j]){

                    int temp = inputs[i];
                    inputs[i]= inputs[j];
                    inputs[j]= temp;
                    


                }

            }


        }
        return inputs;
    }
   

    /*

        123
        0

        array1bigger=true
        return true

        3
        1 3
         array1bigger=false
        true


        1,2
        1



    */
 

    static boolean isEmpty(int[] inputs) {

        return inputs.length ==0;

    }

    static  int[][] getarraywithvalue(int curindex,int value,int[][] inputs) {


 

        int[][] results = null;
        for(int i=0;i<inputs.length;i++){

            if(!isEmpty(inputs[i])){

                if(inputs[i].length > curindex && inputs[i][curindex] == value){


                    results=incrementArraySpace(results);
                    int resultIndex=results.length-1;
                    results[resultIndex] = inputs[i]; 

                }
               
              
            }


        }

        return results;
    }

  
    static  int[] findlower(int[] array1,int[] array2) {

        boolean isArray1Bigger =(array1.length > array2.length);
        int size = isArray1Bigger?array2.length:array1.length;
        int[] results=findlowerinLoop(array1,array2,size);



        if(null != results){

            System.out.println("=== Direct ==");
          
            printarr(results);
            System.out.println("=====");
            return results;
        }
            
      

        //Now return lower array firs

        if(isArray1Bigger)
            results= array2;
        else
         results= array1;        


            System.out.println("=== In Direct ==");
            System.out.println("=== arraived array 1 ==");
            printarr(array1);
            System.out.println("=== arraived array 2 ==");
            printarr(array2);
            System.out.println("=== results ==");
            printarr(results);
            System.out.println("=====");
       
            return results;

    }

    static  int getLowestElement(int[][] inputs) {

        int lowestelem = Integer.MAX_VALUE;
        int curindex=0;

        for(int i=0;i<inputs.length;i++)
            if(lowestelem > inputs[i][curindex])               
                        lowestelem = inputs[i][curindex];
     
                        
      return   lowestelem;                
    }

    static  int[] getEmptyElement(int[][] inputs) {

        int[] results=null;

        
        for(int i=0;i<inputs.length;i++){

            if(isEmpty(inputs[i])){
                results=inputs[i];
                break;
            }

        }
        return results;


    }

    static  int[] getLowestArray(int[][] inputs) {

        int[] results=getEmptyElement(inputs);

        if(null != results)
            return results;
        
        int curindex=0;
        int lowestelem=getLowestElement(inputs);
        
        for(int i=0;i<inputs.length;i++){

            
            if(lowestelem == inputs[i][curindex]){
                if(null != results)
                    results = findlower(results,inputs[i]);
                else
                    results=inputs[i];
            }
               
        }

  
        return results;
    }
    static  int[][] sort2dArray(int[][] inputs) {

        int[][] results = null;
        int count= inputs.length;

        
        for(int i=0;i<count;i++){

           int[] result= getLowestArray(inputs);

           results=incrementArraySpace(results);
            int resultIndex=results.length-1;
            results[resultIndex] = copy(result); 

            inputs= removesubset(result,inputs);

            //remove result from inputs


        }
        return results;
    }


 
    
    static  int[][] removesubset(int[] subset ,int[][] inputs) {


            int[][] results=null;
         //if all conditions satisfied , add to arry

         for(int i=0;i<inputs.length;i++){

            if(arrayEquals(inputs[i],subset) == false){
                
                results =  incrementArraySpace(results);
                results[results.length-1] = inputs[i];
            }  
        }

        return results;



    }

   

    static  int[][] incrementArraySpace(int[][] array1) {

        int add = 1;
        int[][] results =null;
        if(null == array1){

             results = new int[add][];
             return results;

        }

        int totalLength = array1.length + add;

       results = new int[totalLength][];
        for(int i=0;i<array1.length;i++){


            if(null != array1[i]){
            results[i]=new int[array1[i].length];

            for(int j=0;j<array1[i].length;j++){
                results[i][j]=array1[i][j];                    

            }
        }

        }

        return results;


    }

 

    static  int[][] mergesubsets(int[][] array1,int[][] array2) {


        if(null == array1 || null == array1[0])
            return array2;
        
        if(null == array2 || null == array2[0])
            return array1;

        int totalLength = array1.length + array2.length ;

        
        int[][] results = new int[totalLength][];

        int resultIndex=0;
        for(int i=0;i<array1.length;i++){

            int array1IndexLength = array1[i].length;

            results[resultIndex] = new int[array1IndexLength];

                for(int j=0;j<array1IndexLength;j++){
                    results[resultIndex][j]=array1[i][j];                    

                }
            resultIndex++;
        }

        for(int i=0;i<array2.length;i++){

            int array2IndexLength = array2[i].length;

            results[resultIndex] = new int[array2IndexLength];

                for(int j=0;j<array2IndexLength;j++){
                    results[resultIndex][j]=array2[i][j];                    
                    
                }
            resultIndex++;
        }

        return results;

    }


    static  int[][] getsubsets(int[] inputs) {

        int[][] existingResults = null;
        existingResults = new int[1][];
        existingResults[0] = new int[0];      
        int[][] unsortedresults = getunsortedsubsets(existingResults,inputs);
        int[][] results = sort2dArray(unsortedresults);
        return results;
    }

    static  boolean arrayEquals(int[] array1 ,int[] array2) {

        
         array1=sortArray(array1);
         array2=sortArray(array2);

         if(array1.length != array2.length)
                return false;

        for(int j=0;j<array1.length;j++)
            if(array1[j] != array2[j])
                return false;

        return true;        
    }


    static int[][] addSinglesubset(int input ,int[][] results){

        int[] updatedinputs = new int[1];
        updatedinputs[0] =input;

        return addsubset(updatedinputs,results);

    }
    static int[][] addsubset(int[] inputs ,int[][] results){

        int[][] updatedresults= results;

        if(containssubset(inputs,results) == false){            
           updatedresults=incrementArraySpace(results);
            int resultIndex=updatedresults.length-1;
            updatedresults[resultIndex] = inputs; 
         
        }

        return updatedresults;

    }


 
    static  boolean containssubset(int[] inputs ,int[][] results) {


        if(results == null )
            return false;

        if( null == inputs)    
                return true;

         //if all conditions satisfied , add to arry

         for(int i=0;i<results.length;i++){

            if(null != results[i] && arrayEquals(results[i],inputs)){
                return true;
            }  
        }

        return false;



    }

     static  int[][] getunsortedsubsets(int[][] existingsubset,int[] inputs) {

        int[][] results =   mergesubsets(null,existingsubset);
        
    

        

        if(inputs.length == 2){      
            results = addsubset(inputs,results);    
            results = addSinglesubset(inputs[0],results);    
            results = addSinglesubset(inputs[1],results);  
            return results;
           
       }

    
    
       results = addsubset(inputs,results);    
        


        for(int i=0;i<inputs.length;i++){


            
         
            
            int[] nextInput = new int[inputs.length-1];
            int nextInputIndex=0;
             
             
            
             
            for(int j=0;j<inputs.length;j++){

                if(i!=j){

                    
                    nextInput[nextInputIndex++]=inputs[j];
                }
            }

               results= getunsortedsubsets(results,nextInput);
            
            



           
           
        }



        return results;



     }





  
    
    
     
}

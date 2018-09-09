public class SubSets {
    



    public int[][] subsets(int[] inputs) {
        
        return getsubsets(inputs);
       
         
         
     }
 
   private static  int[] copy(int[] inputs) {

       

        int[] results = new int[inputs.length];
       System.arraycopy(inputs, 0, results, 0, inputs.length);

        return results;



    }
    private static  int[][] sortAllArrays(int[][] inputs) {


        for(int i = 0; i< inputs.length; i++){
            inputs[i] = sortSingleArray( inputs[i]);
        }

        return inputs;
        
    }

    private static  int[] sortSingleArray(int[] inputs) {

        

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
    private static  int[] sortArray(int[] inp) {

        
            return inp;

    }
   

 

    private static boolean isEmpty(int[] inputs) {

        return inputs.length ==0;

    }

    static  int[][] getarraywithvalue(int curindex,int value,int[][] inputs) {


 

        int[][] results = null;
        for (int[] input : inputs) {

            if (!isEmpty(input)) {

                if (input.length > curindex && input[curindex] == value) {


                    results = incrementArraySpace(results);
                    int resultIndex = results.length - 1;
                    results[resultIndex] = input;

                }


            }


        }

        return results;
    }

  
     static  int[] findlowerinLoop(int[] array1, int[] array2, int size) {


        
        for(int i=0;i<size;i++){
            if(array1[i] < array2[i])
                return array1;
            else if(array1[i] > array2[i])
                return array2;

            }
       return null;         
     
    }
    private static  int[] findlower(int[] array1, int[] array2) {

        boolean isArray1Bigger =(array1.length > array2.length);
        int size = isArray1Bigger?array2.length:array1.length;
        int[] results=findlowerinLoop(array1,array2,size);



        if(null != results)            
            return results;
            
      

        //Now return lower array firs

        if(isArray1Bigger)
            results= array2;
        else
            results= array1;        

       
        return results;

    }

    private static  int getLowestElement(int[][] inputs) {

        int lowestelem = Integer.MAX_VALUE;
        int curindex=0;

        for (int[] input : inputs)
            if (lowestelem > input[curindex])
                lowestelem = input[curindex];
     
                        
      return   lowestelem;                
    }

    private static  int[] getEmptyElement(int[][] inputs) {

        int[] results=null;


        for (int[] input : inputs) {

            if (isEmpty(input)) {
                results = input;
                break;
            }

        }
        return results;


    }

    private static  int[] getLowestArray(int[][] inputs) {

        int[] results=getEmptyElement(inputs);

        if(null != results)
            return results;
        
        int curindex=0;
        int lowestelem=getLowestElement(inputs);

        for (int[] input : inputs) {


            if (lowestelem == input[curindex]) {
                if (null != results)
                    results = findlower(results, input);
                else
                    results = input;
            }

        }

  
        return results;
    }




    private static  int[][] sort2dArray(int[][] inputs) {

        int[][] results = null;

        inputs= sortAllArrays(inputs);
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


 
    
    private static  int[][] removesubset(int[] subset, int[][] inputs) {


            int[][] results=null;
         //if all conditions satisfied , add to arry

        for (int[] input : inputs) {

            if (arrayEquals(input, subset) == false) {

                results = incrementArraySpace(results);
                results[results.length - 1] = input;
            }
        }

        return results;



    }

   

    private static  int[][] incrementArraySpace(int[][] array1) {

        int add = 1;
        int[][] results;
        if(null == array1){

             results = new int[add][];
             return results;

        }

        int totalLength = array1.length + add;

       results = new int[totalLength][];
        for(int i=0;i<array1.length;i++){


            if(null != array1[i]){
            results[i]=new int[array1[i].length];

                System.arraycopy(array1[i], 0, results[i], 0, array1[i].length);
        }

        }

        return results;


    }

 

    private static  int[][] mergesubsets(int[][] array1, int[][] array2) {


        if(null == array1 || null == array1[0])
            return array2;
        
        if(null == array2 || null == array2[0])
            return array1;

        int totalLength = array1.length + array2.length ;

        
        int[][] results = new int[totalLength][];

        int resultIndex=0;
        resultIndex = updateArrayfrom(array1, results, resultIndex);

       updateArrayfrom(array2, results, resultIndex);

        return results;

    }

    private static int updateArrayfrom(int[][] array1, int[][] results, int resultIndex) {
        for (int[] anArray1 : array1) {

            int array1IndexLength = anArray1.length;

            results[resultIndex] = new int[array1IndexLength];

            System.arraycopy(anArray1, 0, results[resultIndex], 0, array1IndexLength);
            resultIndex++;
        }
        return resultIndex;
    }


    static  int[][] getsubsets(int[] inputs) {

        int[][] existingResults;
        existingResults = new int[1][];
        existingResults[0] = new int[0];      
       
        return sort2dArray(getunsortedsubsets(existingResults,inputs));
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

        for (int[] result : results) {

            if (null != result && arrayEquals(result, inputs)) {
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
            int inplen=inputs.length;
             
            for(int j=0;j<inplen;j++){
                if(i!=j){
                    nextInput[nextInputIndex++]=inputs[j];
                }
            }

               results= getunsortedsubsets(results,nextInput);
            
            



           
           
        }



        return results;



     }





  
    
    
     
}

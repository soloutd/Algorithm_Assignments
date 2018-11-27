package WeekOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;
public class AlgorithmDay1 {



        public static int Algorithm_one(){
            int [] ints = new int [1500];

            ArrayList<Integer> evenNumbers = new ArrayList<>();

            for (int i=0; i<ints.length;i++){
                ints[i]=(int) (Math.random()*1000);
                /*System.out.print(ints[i]+"-- ");*/
                if(ints[i]%2==0){
                    evenNumbers.add(ints[i]);
                }
            }
            /*System.out.print(evenNumbers);*/

            int max =0;
            for(int i=0; i<evenNumbers.size();i++){

                for(int j=0; j<evenNumbers.size();j++){
                    int k = Math.abs(evenNumbers.get(i)-evenNumbers.get(j));
                    if(k>max){
                        max = k;
                    }
                }
            }


            return max;
        }

        public static int [] RandomNumber(){
            int [] ints = new int [1500];
            Random random = new Random();

            for (int i=0; i<ints.length;i++){
                ints[i]=-1000 + new Random().nextInt(2001);;/*(int) (Math.random()*1000);*/
                /* System.out.print(ints[i]+" <--> ");*/

            }
            return ints;
        }


        public static int Algorithm_Two(){
            int [] ints = RandomNumber();

            int max =0;
            for(int i=0; ints.length>i;i++){

                if(ints[i]%2==0){
                    for(int j=i+1; ints.length>j;j++){
                        if(ints[j]%2==0){
                            int k = Math.abs(ints[i]-ints[j]);
                            if(k>max){
                                max = k;
                            }
                        }
                    }
                }
            }

            return max;
        }
        /*
        * this is the 3rd
        * */

        public static int Algorithm_3(){
            int [] ints = RandomNumber();
            int max=-1000; int min= 1000;
            for(int i=0; i< ints.length;i++) {
                if (ints[i] % 2 == 0) {
                    if (max < ints[i]) {
                        max = ints[i];
                    }
                    if (min > ints[i]) {
                        min = ints[i];
                    }

                }
            }
            return max-min;
        }

        public static int Algorithm_4(){
            int [] ints = RandomNumber();
            int max = Arrays.stream(ints).filter(e-> (e%2==0)).max().getAsInt();
            int min = Arrays.stream(ints).filter(e-> (e%2==0)).min().getAsInt();
            return max - min;
        }

        public static void main(String[] args) {

            // write your code here
            long startTime = System.currentTimeMillis();
            System.out.println(Algorithm_one());
            long endTime = System.currentTimeMillis();
            System.out.println(endTime- startTime +" --> Milli Seconds! for Algorithm One");

            long startTime1 = System.currentTimeMillis();
            System.out.println(Algorithm_Two());
            long endTime1 = System.currentTimeMillis();
            System.out.println(endTime1- startTime1 +" --> Milli Seconds! for Algorithm Two");

            long startTime2 = System.currentTimeMillis();
            System.out.println(Algorithm_3());
            long endTime2 = System.currentTimeMillis();
            System.out.println(endTime2- startTime2 +" --> Milli Seconds! for Algorithm 3");

            long startTime3= System.currentTimeMillis();
            System.out.println(Algorithm_4());
            long endTime3 = System.currentTimeMillis();
            System.out.println(endTime3- startTime3 +" --> Milli Seconds! for Algorithm 4");
        }

}

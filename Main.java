import java.util.ArrayList;
import java.util.Arrays;

import my_package.*;

class Main{


    public static void main(String[] args){

        ArrayList<ArrayList<Number>> xValues = new ArrayList<ArrayList<Number>>(
            Arrays.asList(
                new ArrayList<Number>(
                    Arrays.asList(
                        5,45
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.11, 
                        26
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.6, 30
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.9, 34
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        4.8, 40
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.8, 36
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.3, 19
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.8, 28
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.5, 23
                    )
                ),new ArrayList<Number>(
                    Arrays.asList(
                        5.6, 32
                    )
                )

        ));
        ArrayList<Number> yVals = new ArrayList<Number>(
            Arrays.asList(
                77,47,55,59,72,60,40,60,45,58
            )
        );

        Knn knn = new Knn(xValues, yVals, 5);
        
        ArrayList<Number> x2 = new ArrayList<Number>(
            Arrays.asList(
                5.6,32
            )
        );

        knn.predict(x2);
    }

}
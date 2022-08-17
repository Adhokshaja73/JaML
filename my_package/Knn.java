package my_package;

import java.util.ArrayList;

public class Knn{


    ArrayList<ArrayList<Number>> xValues;
    ArrayList<Number> yValues;
    int k;


    public Knn(ArrayList<ArrayList<Number>> xValues, ArrayList<Number> yValues, int k){
        this.xValues = xValues;
        this.yValues = yValues;
        this.k = k;
    }

    public void predict(ArrayList<Number> x2){
        ArrayList<Integer> indexes = new ArrayList<>();

        ArrayList<Number> distanceList =  new ArrayList<>();
        try{
            for(int i = 0; i < xValues.size(); i += 1){
                distanceList.add(distance(xValues.get(i), x2));
                indexes.add(i);
            }
        }
        catch(InvalidSizeException e){
            System.out.println("Expected size ..");
            return;
        }   
        
        // Sort the indexes based on the corresponding values in distanceList;
        //      
        boolean swap = true;
        while(swap == true){
            swap = false;
            for(int i = 0; i < distanceList.size()-1; i += 1){
                if(distanceList.get(indexes.get(i)).doubleValue() > distanceList.get(indexes.get(i+1)).doubleValue()){
                    int temp = indexes.get(i);
                    indexes.set(i, indexes.get(i+1));
                    indexes.set(i+1, temp);
                    swap = true;
                }
            }
        }
        System.out.println(distanceList);
        System.out.println(indexes);

        double out = 0;
        for(int i = 0 ;i < k; i += 1){
            out += yValues.get(indexes.get(i)).doubleValue();
        }
        out = out / k;
        System.out.println(out);
    }



    private Number distance(ArrayList<Number> x1, ArrayList<Number> x2) throws InvalidSizeException{
        Number mDistance = 0;
        if(x1.size() != x2.size()){
            InvalidSizeException exception = new InvalidSizeException();
            throw exception;
        }

        else{
            for(int i = 0; i < x1.size(); i += 1){
                mDistance = Math.pow(x1.get(i).doubleValue() - x2.get(i).doubleValue(), 2);
            }
        }
        mDistance = Math.pow(mDistance.doubleValue(), 0.5);
        return mDistance;
    }
}
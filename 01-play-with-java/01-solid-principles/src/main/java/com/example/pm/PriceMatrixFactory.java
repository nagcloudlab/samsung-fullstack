package com.example.pm;

// Factory class
public class PriceMatrixFactory {

    // Factory method
    public static PriceMatrix getPriceMatrix(String version){
        if(version.equals("1.0")){
            return new PriceMatrix_v1();
        }else if(version.equals("2.0")){
            return new PriceMatrix_v2();
        }else{
            return null;
        }
    }


}

package com.example.user.myfirstapp.ui;

import java.math.BigDecimal;

public class ComplexNumbersCalculator {


    private double realNumber, imageNumber;

    public ComplexNumbersCalculator(double realNumber, double imageNumber){

        this.realNumber = realNumber;
        this.imageNumber = imageNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public double getImageNumber() {
        return imageNumber;
    }

    private String sign(){

        if (imageNumber > 0) return  " + ";
        else return  " - ";
    }

    public String toString(){

        Double scaleRealNumber, scaleImageNumber;

        scaleRealNumber = new BigDecimal(realNumber).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        scaleImageNumber = new BigDecimal(imageNumber).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();

        String string;
        if (imageNumber == 1 || imageNumber == -1) {
            if (realNumber == 0) {
                string = sign() + "i";
            } else {
                string = Double.toString(scaleRealNumber) + sign() + " i ";
            }
        } else {
            string = Double.toString(scaleRealNumber) + sign() + Double.toString(Math.abs(scaleImageNumber)) + " i ";
        }
        return string;
            }

    public static ComplexNumbersCalculator sum(ComplexNumbersCalculator firstComplexNumber,
                                               ComplexNumbersCalculator secondComplexNumber){

        return new ComplexNumbersCalculator(firstComplexNumber.getRealNumber() +
                secondComplexNumber.getRealNumber(), firstComplexNumber.getImageNumber() +
                secondComplexNumber.getImageNumber());

    }

    public static ComplexNumbersCalculator minus(ComplexNumbersCalculator firstComplexNumber,
                                                 ComplexNumbersCalculator secondComplexNumber){

        return new ComplexNumbersCalculator(firstComplexNumber.getRealNumber() -
                secondComplexNumber.getRealNumber(), firstComplexNumber.getImageNumber() -
                secondComplexNumber.getImageNumber());

    }

    public static ComplexNumbersCalculator multiplication(ComplexNumbersCalculator firstComplexNumber,
                                                          ComplexNumbersCalculator secondComplexNumber){

        return new ComplexNumbersCalculator(firstComplexNumber.getRealNumber() *
                secondComplexNumber.getRealNumber() - firstComplexNumber.getImageNumber() *
                secondComplexNumber.getImageNumber(), firstComplexNumber.getRealNumber() *
                secondComplexNumber.getImageNumber() + secondComplexNumber.getRealNumber() *
                firstComplexNumber.getImageNumber());

    }

    public static ComplexNumbersCalculator div(ComplexNumbersCalculator firstComplexNumber,
                                               ComplexNumbersCalculator secondComplexNumber){

        double divider;
        divider = Math.pow(secondComplexNumber.getRealNumber(), 2) + Math.pow(secondComplexNumber.getImageNumber(), 2);

        return new ComplexNumbersCalculator((firstComplexNumber.getRealNumber() *
                secondComplexNumber.getRealNumber() + firstComplexNumber.getImageNumber() *
                secondComplexNumber.getImageNumber())/divider,
                (firstComplexNumber.getImageNumber() * secondComplexNumber.getRealNumber()
                        - firstComplexNumber.getRealNumber() * secondComplexNumber.getImageNumber())/divider);

    }

}

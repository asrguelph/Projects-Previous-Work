package ePortfolio;
import java.util.*;
/*
 * Name: Adnan Rangwala
 * ID: 1275671
 * Program Title: MutualFund.java
 * Description: MutualFund user class used by portfolio file
 */
    /**
    * Class MutualFund, main class for handling mutual fund investments and helping with manipulating their values
    */
    public class MutualFund extends Investments{
        

        /**
         * Constructor class MutualFund
         * @param symbol takes the value and stores it into investment symbol variable
         * @param name takes value and stores it into investment name variable
         * @param quantity takes value and stores it into investment quantity variable
         * @param price takes variable and stores it into price variable
         */
        public MutualFund(String symbol,String name,int quantity,double price) {
            super(symbol,name,quantity,price);
            updateBookValue();
        }

        /**
         * No arg constructor for stock, sets up default values for each variable
         */
        public MutualFund() {//no arg constructor
            super();
        }

        /**
         * updateBookValue method recalculates book value for mutual fund
         */
        public void updateBookValue() {//basic way to re calculate book value
            bookValue = price*quantity;
        }

        /**
         * getPaymentValue calculates payment for mutual fund
         * @return returns the payment value calculated
         */
        public double getPaymentValue() {
            return price*quantity - 45;
        }

        /**
         * getGainValue calculates gain
         * @return returns the gain value
         */
        public double getGainValue() {
            double payment = getPaymentValue();
            return payment - bookValue;
        }


        /**
         * equals returns true or false when two investments equal eachother
         * @param otherObject is the other instance being compared
         *  
         */
        @Override
        public boolean equals (Object otherObject) {
            if (otherObject == null) {
                return false;
            } 
            else if (getClass() != otherObject.getClass()) {
                return false;
            } 
            else {
                MutualFund otherInvest = (MutualFund)otherObject;
                return  symbol.equals(otherInvest.symbol) && name.equals(otherInvest.name) && quantity == otherInvest.quantity && price == otherInvest.price;
            }
        }

        /**
         * toString displays investment information through a string
         * @return string that has the information in a string
         */
        @Override
        public String toString() {//to string
            return String.format("Type: Mutual Fund \nSymbol: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nBook Value: $%.2f\n",symbol,name,quantity,price,bookValue);
        }
        

    }
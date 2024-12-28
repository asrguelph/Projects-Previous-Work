package ePortfolio;
import java.util.*;
/*
 * Name: Adnan Rangwala
 * ID: 1275671
 * Program Title: Stock.java
 * Description: Stock user class used by portfolio file
 */

    /**
    * Class Stock, main class for handling stock investments and helping with manipulating their values
    */
    public abstract class Investments{
        /**
         * String variable to store symbol value
         */
        protected String symbol;

        /**
         * String variable to store investment name value
         */
        protected String name;

        /**
         * integer variable to store quantity value
         */
        protected int quantity;

        /**
         * double variable to store price value
         */
        protected double price;

        /**
         * double variable to store book value
         */
        protected double bookValue;

        /**
         * No arg constructor for stock, sets up default values for each variable
         */
        public Investments() {//no arg constructor
            this("N/A","No name",0,0);
        }

        /**
         * Constructor class stock
         * @param symbol takes the value and stores it into investment symbol variable
         * @param name takes value and stores it into investment name variable
         * @param quantity takes value and stores it into investment quantity variable
         * @param price takes variable and stores it into price variable
         */
        public Investments(String symbol,String name,int quantity,double price) {//constructor for stock
            if (symbol == null || name == null || quantity == 0 || price == 0 || symbol.isEmpty() || name.isEmpty()) {
                throw new IllegalArgumentException("The input you entered was invalid and has empty input!"); 
            }
            this.symbol = symbol;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public Investments(Investments original) {
            if (original == null) {
                System.out.println("Error");
                System.exit(0);
            }
            name = original.name;
            symbol = original.symbol;
            quantity = original.quantity;
            price = original.price;
            bookValue = original.bookValue;
        }

        /**
         * getRemainingQuantity calculates remaining quantity
         * @param someQuantity quantity sold
         * @return returns integer value of quantity remaining
         */
        public int getRemainingQuantity(int someQuantity) {
            return quantity - someQuantity;
        }

        /**
         * getBookValueRemaining calculates the remaining book value when some quantity is removed
         * @param someQuantity quantity sold
         * @return returns the book value remaining
         */
        public double getBookValueRemaining(int someQuantity) {
            int remainingQuantity = getRemainingQuantity(someQuantity);
            return bookValue*((double)remainingQuantity/quantity);
        }

        /**
         * getBookValueSold calculates the amount of book value that was sold
         * @param someQuantity quantity sold
         * @return returns the total book value sold
         */
        public double getBookValueSold(int someQuantity) {
            double bookValueRemaining = getBookValueRemaining(someQuantity);
            return bookValue - bookValueRemaining;
        }



        /**
         * toString displays investment information through a string
         * @return string that has the information in a string
         */
        public String toString() {//to string
            return String.format("Symbol: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nBook Value: $%.2f\n",symbol,name,quantity,price,bookValue);
        }

        /**
         * equals returns true or false when two investments equal eachother
         * @param otherObject is the other instance being compared
         */
        public boolean equals (Object otherObject) {
            if (otherObject == null) {
                return false;
            } 
            else if (getClass() != otherObject.getClass()) {
                return false;
            } 
            else {
                Investments otherInvest = (Investments)otherObject;
                return  symbol.equals(otherInvest.symbol) && name.equals(otherInvest.name) && quantity == otherInvest.quantity && price == otherInvest.price;
            }
        }
        
        /**
         * getSymbol gets the symbol from the investment
         * @return returns the symbol
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * getName gets the name from the investment
         * @return returns the name
         */
        public String getName() {
            return name;
        }

        /**
         * getQuantity gets the quantity from the investment
         * @return returns the quantity
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * getPrice gets the price from the investment
         * @return returns the price
         */
        public double getPrice() {
            return price;
        }

        /**
         * getBookValue gets the book valu from the investment
         * @return returns the book value
         */
        public double getBookValue() {
            return bookValue;
        }

        /**
         * setSymbol sets the symbol to the specified parameter in a investment
         * @param symbol the symbol you want to set
         */
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        /**
         * setName sets the name to the specified parameter in a investment
         * @param name the name you want to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * setQuantity sets the quantity to the specified parameter in a investment
         * @param quantity the quantity you want to set
         */
        public void setQuantity(int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("The quantity entered was less than or equal to 0!");
            }
            this.quantity = quantity;
        }

        /**
         * setPrice sets the price to the specified parameter in a investment
         * @param price the price you want to set
         */
        public void setPrice(double price) {
            if (price <= 0) {
                throw new IllegalArgumentException("The price entered was less than or equal to 0!");
            }
            this.price = price;
        }

        /**
         * setBookValue sets the book value to the specified parameter in a investment
         * @param bookValue the book value you want to set
         */
        public void setBookValue(double bookValue) {
            this.bookValue = bookValue;
        }
        
        public abstract double getGainValue();
        public abstract double getPaymentValue();
        public abstract void updateBookValue();

    }
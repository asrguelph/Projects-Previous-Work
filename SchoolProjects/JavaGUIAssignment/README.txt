---1. This program is meant to hekp with creating a invesment portfolio, organizing investments that are either stocks or mutual funds
The program helps find, create, and sell investments as well, and uses java.swing and java.awt to implement a GUI to handle this.

---2. The program assumes that there is no mismatch between data, For example, an input where a number is required will always assume there is a number, such as where you are creating a intger value

---3.To first compile and run the program, they should first do:
javac ePortfolio/.*java - to compile
java ePortfolio/Portfolio.java - to run

Note that filenames are stored outside of the package as a text file and are accessed at the start/end of a program if stated

The user when running the program is shown the main menu, in the menu they can enter a answer for the following options

buy - Buying or adding new quantity to an investment
In the first menu option, the user will be prompted to enter between the stock or mutual fund investment option, and the user is prompted to input the name of the investment symbol
as well as the quantity (number value) they are buying followed by a price (also a number value) and the full name of the investment
Once the buy button is pressed, the investment is added if it is fully correct.
If the symbol already exists and is of the same investment type, the user will then be notified they are adding to an existing stock

sell - Sell an investment
In this menu option, the user is able to input a symbol name, quantity value (number), then a price value (number),
In order to sell an investment, the user must click the sell button once entering all the values
if the symbol name is not found within stock/mutual funds, it will display a message stating it was not found.
If the quantity is too high, the program will will display a message stating there was an error with selling.
If the quantity value becomes 0, the investment will be removed from the list
If it is sold partially, it will recalculate the invesment information

update - Update Investment Prices
In this menu option, the user will be asked multiple times to re add a new price value for each investment entered, each value must be a number
The user will press previous or next to move to the next investment, and will press save once they want to save the updated price

getGain - Get total gain
In this menu option, the user will not do anything and be shown the gain value of the entire investment

search - Search for a investment
In this menu option, the user will be prompted to enter the symbol name, keyword name, and price range  the user has the option to enter nothing into these values
For the price range, the user must enter two numbers, the low price range and high price range. (low price - high price)
For the key word, it must be contained within the name of the investment or it wont be found
For the symbol, it must be the same as a symbol name or it wont be found.
If you ignore all the prompts, you will end up being shown all investments
If you do a search, it will only show the following investments that fit the search

quit - Quit 
The user can quit the program in the menu by pressing on the quit bar


---4. Test plan
If user chooses stock and inputs a symbol that already exists in mutual fund - program will re ask for input on symbol name
OUTPUT: Please enter either a stock or mutual fund
INPUT: stock
OUTPUT: Please enter a symbol name
INPUT: AAP 
OUTPUT: Already exists in mutual fund! please try again

after user inputs symbol, ask for price/quantity
Inputting a negative price/quantity value number (e.g -1) when buying quantity - program re asks for input
INPUT: -3
OUTPUT: The following price/quantity value is invalid! Please try again.

Inputting a 0 as a price/quantity number when buying quantity - program re asks for input
INPUT: 0
OUTPUT: The following price/quantity value is invalid! Please try again.

When selling, if the user inputs a negative number for price/quantity - program re asks for input
INPUT: -3
OUTPUT: The following price/quantity value is invalid! Please try again.

When selling if user inputs 0 for price/quantity - program re asks for input
INPUT: 0
OUTPUT: The following price/quantity value is invalid! Please try again.

If when selling the quantity is too much and would result in a negative amount being sold - should result in the sell cancelling and returning to menu
INPUT: 500 (current quantity for investment is 400)
OUTPUT: The quantity amount you are selling is too high and is invalid! Please try again.

When updating investment prices if user puts in 0 or negative value - program re asks for input
INPUT: 0
OUTPUT: The following price value is invalid! Please try again.
INPUT: -1
OUTPUT: The following price value is invalid! Please try again.

If user ignores symbol, but adds keyword or range - program will continue to run and find investments that meet the following keyword/range but ignores symbol, and vice versa
If user puts in invalid range format for search- program re asks for input:
INPUT -34343445fa
OUTPUT: There has been an error with the price range, please re input it again!

If user puts in keyword that is found in between a symbol name - program will still find investment
OUTPUT: Please enter the keyword you are looking for
INPUT: X W (abritrary words)
OUTPUT: Found stock/mutual fund with "Hello X Im W" as name

if user puts in greater number for minimum value of range than max number - program re asks for input
INPUT 20-10
OUTPUT: There has been an error with the price range, please re input it again!

If the user inputs a dash and then a number only, or a number and then a dash only, program will output the numbers greater/equal or less than/equal to the given number
INPUT: -10
OUTPUT: stock with $1.00 price
INPUT: 10-
OUTPUT: stock with $10+ price

If only keyword is entered in search, should only show the investments with that keyword 

If only symbol is entered in search, should only show the investments with that symbol

If nothing is inputted in search, will show all investments

If all of an existing keyword is sold in hashmap, update hashmap and remove said keyword

If one of a existing keyword is sold in hashmap, update hashmap to remove that index

If only one word as that keyword is inputted for search, it should find all investments with that one keyword

If a price range and key word is inputted, it should show investments with that pricerange and keyword


--5. Improvements for future
If I could, I would probably try to add in much more error handling and do more thorough testing on the program, I would also try to make it more modular
as I feel the current program is a bit messy and not as organized/readable as it could be.
If I had more time, I would spend it thoroughly testing through my code much more and making it much less messy and more efficient as well as 
less fragile.
I would definitely in the future refine my GUI as well, as it was the best I could do within the time I had, but I definitely feel like I could make it better.



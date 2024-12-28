# Lab Exercise 5

In this lab we will again be working in new pairs.

The program we will write will again read CSV files, but can be based on any previous program you and your partner choose, including the handout program from the first lab


# Task 1 Description

We will call our program for this task `unpivot.py`

Tabular data can be supplied in "pivoted" form, which is common for people to read, or "unpivoted" form which is commonly maching readable.

Take for example this data summarizing the names `Andrew`, `Kassandra` and `Puneet` from 2010 to 2015:

|    Name   |  Sex  |  2010 |  2013 |  2012 |  2013 |  2014 |  2015 |
| --------- | :---: | ----: | ----: | ----: | ----: | ----: | ----: |
|    Andrew |   F   |    15 |    11 |    21 |    14 |    11 |    10 |
|    Andrew |   M   | 14263 | 13291 | 12632 | 11678 | 11180 | 10135 |
| Kassandra |   F   |   539 |   463 |   411 |   394 |   414 |   373 |
|    Puneet |   F   |       |     7 |     5 |       |     6 |     8 |


As you may find data in "pivoted" form that you wish to use for your project, writing a script to convert it is a useful task.

The data shown above is in the file `pivot_data_2010_to_2015.csv` in the "pivoted" form.

The unpivoted version output should look like this:

	```
	Name,Sex,Year,Frequency
	Andrew,F,2010,15
	Andrew,F,2011,11
	Andrew,F,2012,21
	Andrew,F,2013,14
	Andrew,F,2014,11
	Andrew,F,2015,10
	Andrew,M,2010,14263
	Andrew,M,2011,13291
	Andrew,M,2012,12632
	Andrew,M,2013,11678
	Andrew,M,2014,11180
	Andrew,M,2015,10135
	Kassandra,F,2010,539
	Kassandra,F,2011,463
	Kassandra,F,2012,411
	Kassandra,F,2013,394
	Kassandra,F,2014,414
	Kassandra,F,2015,373
	Puneet,F,2011,7
	Puneet,F,2012,5
	Puneet,F,2014,6
	Puneet,F,2015,8
	```



Your command line should be of the form

    $ python3 unpivot.py pivot_data_2010_to_2015.csv 2 Year Frequency

This command line refers to:

* the input file to read
* the number of columns to skip (in this case, for Name and Sex) before unpivoting the rest of the data
* the column name to use for the values from the header row (here `Year`)
* the column name to use for the values from the cells (here `Frequency`)


# Considerations

If there is no value given in a pivoted table cell, there should be no output line for this value.  (Note that Puneet's name has fewer lines in the unpivoted data.)

You will be working with Python lists (which is the "array" like type we have been using)  more formally in this lab than we have previously, so I wish to remind you of some tools for iterating over Python lists using integer indices:

* the function `len(list)` will tell you how many elements are in a list

* the function `range(start,end)` will give you a list of values that you can use with a for loop. For example the code below will print out the integers 0 through 9, each on a separate line (note that `range()` goes up to *but not including* the second value):
	
	```
	for i in range(0, 10):
		print(i)
	```

* you may want to build up a string to then print out as a line.  String concatenation in Python is done using the `+` operator.  For example, to create the string `breadfruit` from `bread` and `fruit`, we could use this code:

	```
	b = "bread"
	f = "fruit"
	bf = b + f
	print(bf)
	```

## Lab submission

* Submit your new programs using the CourseLink dropbox for the lab as in past weeks.


# Some questions that you should now be able to answer

* How can I select part of a list to use in a `for` loop?
* How can I build up my own interesting strings?
* What would be required to go the other way and "pivot" some "unpivoted" data?

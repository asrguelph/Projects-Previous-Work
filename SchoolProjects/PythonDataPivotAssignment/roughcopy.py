#!/usr/bin/env python

'''
find_first_name.py
  Author: Ananya Dikshit
  Project: 
  Date of Last Update: 

  Functional Summary:
      This script takes two CSV files, one containing data and another containing names.
      It counts the number of females in the data file, then searches for each name in the
      name file within the data file and prints the ranks of females and males for each name
      if found, or zero if not found. It also prints the total number of found and missing names.

     Commandline Parameters: 2
        argv[1] = data file containing information about individuals
        argv[2] = name file containing names to search for in the data file
'''



#
#   Packages and modules
#

# The 'sys' module gives us access to system tools, including the
# command line parameters, as well as standard input, output, and error
import sys
# The 'csv' module gives us access to a tool that will read CSV
# (Comma Separated Value) files and provide us access to each of
# the fields on each line in turn
import csv
#to check whether the file is empty or not 
import os 


def main(argv):
    '''
    Main function in the script. Separating the body of the
    script into a function allows us to manage local
    variables within this function, separate from global constants
    declared outside.
    '''
    # Check if the correct number of command-line arguments is provided
    if len(argv) != 5:
        print("Usage: find_first_name.py <data file> <name file>")
        sys.exit(1)
        
   

    # store the command line arguements to the variables
    data_filename = argv[1]
    start_range = int(argv[2])
    header_3=argv[3]
    header_4=argv[4]

 
    # Open data files
    try:
        data_fh = open(data_filename, encoding="utf-8-sig")
    except IOError as err:
        # Display an error message if files cannot be opened
        print("Unable to open {} file: {}".format(data_filename,err), file=sys.stderr)
        sys.exit(1)

    # Open name files
    
    #
    # Create a CSV (Comma Separated Value) reader based on this
    # open file handle.  Use the reader in a loop iteration
    # to access each line in turn.
    #
    data_reader = csv.reader(data_fh)
    header = [] 
    header = next(data_reader)

   
    
    print("{},{},{},{}".format(header[0],header[1],header_3,header_4))
    for row in data_reader:
            for x in range(start_range, len(row)):
               if row[x]!='':
                  print("{},{},{},{}".format(row[0],row[1],header[x],row[x]))
  

if __name__ == "__main__":

    #
    #   End of Function
    #

##
## Call our main function, passing the system argv as the parameter
##
    main(sys.argv)
#
#   End of Script
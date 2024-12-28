
import sys
import csv

#
# Open the name data input file.  The encoding argument
# indicates that we want to handle the BOM (if present)
# by simply ignoring it.
#

def main(argv):
    fileName = argv[1]
    yobFile = open(fileName, encoding="utf-8-sig")

    yobReader = csv.reader(yobFile)
    for row_reader in yobReader:
        print(row_reader)

main(sys.argv)
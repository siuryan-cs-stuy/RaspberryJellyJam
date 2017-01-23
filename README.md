# RaspberryJellyJam
## APCS1 final project: Terminal CSV Tool


Description:

Our CSV Tool is a tool used on the command line to work with csv data. This tool allows users to: add data, set data, sort through data, calculate statistics, print data in a readable format, and more. The idea behind this project is to give a user a quick and easy way to work with CSVs through the terminal so they can also utilize the functionality and convenience of terminal commands. 


Instructions:

1. clone repo

2. `javac Woo.java`

3. `java Woo` to avail yourself of possible commands

4. `java Woo <fileName.csv> --<command> <arg1> <arg2> <arg...> <-flag>`

5. to get a description of a method, `java Woo --<method> -h`

Note: Unless you supply a write flag(overwrites the file), the program will output data to the terminal. This allows you to redirect this information to other places such as to new files.
  Ex. `java Woo oldFile.csv --delCol 1 > newFile.csv`

# RaspberryJellyJam
## APCS1 final project: Terminal CSV Tool


Description:

Our CSV Tool is a tool used on the command line to work with csv data. This tool allows users to: add data, set data, sort through data, calculate statistics, print data in a readable format, and more. The idea behind this project is to give a user a quick and easy way to work with CSVs through the terminal so they can also utilize the functionality and convenience of terminal commands. 


Instructions:

1. clone repo

2. `javac Woo.java`

3. `java Woo` to avail yourself of possible commands

4. `java Woo <fileName.csv> --<command> <args...> <-flag>`

5. to get a more detailed description of a command, `java Woo --<command> -h`

Note: Unless you supply a write flag `-w` which overwrites the input file, the program will only output data to the terminal without saving it to the file. This allows you to redirect this information to other places such as to new files.
  Ex. `java Woo oldFile.csv --delCol 1 > newFile.csv`

/*
Do it when you are free.

Take a folder path and search text from command line say "/docs" ,
identify all the text files in that directory and write a multi-threaded application
 to search for the given text and print a consolidated report about the files and
 the line numbers in which the text was found.

e.g. java Search /docs "Sample content"

It should produce a report indicating each file name and the corresponding line numbers
 in which it was found.

e.g.

a.txt   1, 2, 8
b.txt   90
c.txt   99, 102
Hint -

File dir = new File("/docs");
File [] files = dir.listFiles( new YourOwnFileNameFilter() );
 // this filter should accept only .txt files.
 */
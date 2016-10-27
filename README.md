# Calculation of a graph of names

This program calculates the edges of a graph of names where two nodes have an edge if they have a 
[Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance) of 1

* Input is a file that contains a list of names, separated by newline '\n'.
* Output is a file that contains two names separated by TAB '\t'. These two names have a 
[Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance) of 1.

There are some versions of the code vailable:

* the fastest is `EdgesParJ` which uses parallel streams of Java 8.
* `EdgesStreamJ` is a sequential Java 8 stream.
* `EdgesSeq` is the sequantial version


On an Intel i7-5930K CPU running with 4 GHz the running time for 260.000 names was reduces from more than 3 hours to 
26 minutes (16 GB Ram @2400 MHz). 1.352.302 edges were calculated.

(c) 2016 Jörn Dinkla, http://www.dinkla.net


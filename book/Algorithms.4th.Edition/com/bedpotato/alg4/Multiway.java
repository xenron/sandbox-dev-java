package com.bedpotato.alg4;

import com.bedpotato.alg4.utils.In;
import com.bedpotato.alg4.utils.StdOut;
/*************************************************************************
 *  Compilation:  javac Multiway.java
 *  Execution:    java Multiway input1.txt input2.txt input3.txt ...
 *  Dependencies: IndexMinPQ.java In.java StdOut.java
 * 
 *  Merges together the sorted input stream given as command-line arguments
 *  into a single sorted output stream on standard output.
 *
 *  % more m1.txt 
 *  A B C F G I I Z
 *
 *  % more m2.txt 
 *  B D H P Q Q
 * 
 *  % more m3.txt 
 *  A B E F J N
 *
 *  % java Multiway m1.txt m2.txt m3.txt 
 *  A A B B B C D E F F G H I I J N P Q Q Z 
 *
 *************************************************************************/

/**
 *  The <tt>Multiway</tt> class provides a client for reading in several
 *  sorted text files and merging them together into a single sorted
 *  text stream.
 *  This implementation uses a {@link IndexMinPQ} to perform the multiway
 *  merge. 
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/24pq">Section 2.4</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class Multiway { 

    // This class should not be instantiated.
    private Multiway() { }

    // merge together the sorted input streams and write the sorted result to standard output
    private static void merge(In[] streams) { 
        int N = streams.length; 
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N); 
        for (int i = 0; i < N; i++) 
            if (!streams[i].isEmpty()) 
                pq.insert(i, streams[i].readString()); 

        // Extract and print min and read next from its stream. 
        while (!pq.isEmpty()) {
            StdOut.print(pq.minKey() + " "); 
            int i = pq.delMin(); 
            if (!streams[i].isEmpty()) 
                pq.insert(i, streams[i].readString()); 
        }
        StdOut.println();
    } 


    /**
     *  Reads sorted text files specified as command-line arguments;
     *  merges them together into a sorted output; and writes
     *  the results to standard output.
     *  Note: this client does not check that the input files are sorted.
     */
    public static void main(String[] args) { 
        int N = args.length; 
        In[] streams = new In[N]; 
        for (int i = 0; i < N; i++) 
            streams[i] = new In(args[i]); 
        merge(streams); 
    } 
} 

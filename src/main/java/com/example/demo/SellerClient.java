package com.example.demo;


import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class SellerClient {
    private PrintWriter out;
    private BufferedReader in;

    


        public static void main(String[] args) throws IOException {
            File file = new File("demo/src/main/resources/file1.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                // System.out.println(st+);
                String[] parts = st.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = String.join(" ",Arrays.copyOfRange(parts,2,parts.length));
                System.out.println("------------------------------");
                System.out.println("Part1 = "+part1);
                System.out.println("Part2 = "+part2);
                System.out.println("Part3 = "+part3);
                // System.out.println(st + st.charAt(0));
            }

    }
}

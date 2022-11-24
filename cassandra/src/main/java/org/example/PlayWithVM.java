package org.example;


import sun.misc.VM;

public class PlayWithVM {
    public static void main(String[] args) {
        System.out.println(VM.isDirectMemoryPageAligned());
        System.out.println(VM.maxDirectMemory());
    }
}

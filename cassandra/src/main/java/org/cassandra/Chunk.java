package org.cassandra;

import java.nio.ByteBuffer;

/**
 * A memory chunk: it takes a buffer (the slab) and slices it
 * into smaller buffers when requested.
 *
 *
 */
public class Chunk {
    private final int UNITS = 64;

    private final ByteBuffer slab;
//    private final long baseAddress;
    private final int capacity;

    public static void main(String[] args) {
        long n = -1L;
        System.out.println(Long.toBinaryString(n));
        int free = Long.bitCount(-1L);
        System.out.println(free);
    }

    public Chunk(ByteBuffer slab) {
        this.slab = slab;
        this.capacity = this.slab.capacity();
//        this.baseAddress = baseAddress;
    }
}

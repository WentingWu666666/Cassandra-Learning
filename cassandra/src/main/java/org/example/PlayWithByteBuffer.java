package org.example;

import java.nio.ByteBuffer;

public class PlayWithByteBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        System.out.println("hasRemaining: " + buffer.hasRemaining());

        //byte b = 128;
        byte b = 127;

        System.out.println("position: " + buffer.position());
        buffer.put(0, (byte) 127);
        System.out.println(buffer.get(0));
        System.out.println("position: " + buffer.position());

        buffer.put(0, (byte) 126);
        System.out.println(buffer.get(0));
        System.out.println(buffer.get(0));
    }
}

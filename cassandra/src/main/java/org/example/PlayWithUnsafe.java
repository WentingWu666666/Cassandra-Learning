package org.example;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class PlayWithUnsafe {

    public static Unsafe createUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws InstantiationException, NoSuchFieldException {
        Unsafe unsafe = PlayWithUnsafe.createUnsafe();
        int pageSize = unsafe.pageSize();
        System.out.println(pageSize);

        int addressSize = unsafe.addressSize();
        System.out.println(addressSize);

        long addr = unsafe.allocateMemory(10);
        System.out.println(unsafe.getByte(addr));
        System.out.println(unsafe.getByte(addr + 100));
        System.out.println(unsafe.getChar(addr + 100));

        System.out.println(unsafe.arrayBaseOffset(boolean[].class));
        System.out.println(unsafe.arrayBaseOffset(short[].class));

        ByteBuffer buffer = ByteBuffer.allocate(1);

        System.out.println("--------address--------");
        long address = unsafe.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        System.out.println(address);
        System.out.println(unsafe.getLong(buffer, address));

        address = unsafe.objectFieldOffset(Buffer.class.getDeclaredField("capacity"));
        System.out.println(address);
        System.out.println(unsafe.getLong(buffer, address));

        address = unsafe.objectFieldOffset(ByteBuffer.class.getDeclaredField("isReadOnly"));
        System.out.println(address);
        System.out.println(unsafe.getBoolean(buffer, address));
    }
}

package com.hieulv.videocallpc.utils;

public class Utils {
    public static byte integerToOneByte(int value) throws Exception {
        if ((value > Math.pow(2,15)) || (value < 0)) {
            throw new Exception("Integer value " + value + " is larger than 2^15");
        }
        return (byte)(value & 0xFF);
    }

    public static byte[] integerToTwoBytes(int value) throws Exception {
        byte[] result = new byte[2];
        if ((value > Math.pow(2,31)) || (value < 0)) {
            throw new Exception("Integer value " + value + " is larger than 2^31");
        }
        result[0] = (byte)((value >>> 8) & 0xFF);
        result[1] = (byte)(value & 0xFF);
        return result;
    }

    public static byte[] integerToFourBytes(int value) throws Exception {
        byte[] result = new byte[4];
        if ((value > Math.pow(2,63)) || (value < 0)) {
            throw new Exception("Integer value " + value + " is larger than 2^63");
        }
        result[0] = (byte)((value >>> 24) & 0xFF);
        result[1] = (byte)((value >>> 16) & 0xFF);
        result[2] = (byte)((value >>> 8) & 0xFF);
        result[3] = (byte)(value & 0xFF);
        return result;
    }

    public static int oneByteToInteger(byte value) throws Exception {
        return (int)value & 0xFF;
    }

    public static int twoBytesToInteger(byte[] value) throws Exception {
        if (value.length < 2) {
            throw new Exception("Byte array too short!");
        }
        int temp0 = value[0] & 0xFF;
        int temp1 = value[1] & 0xFF;
        return ((temp0 << 8) + temp1);
    }

    public static long fourBytesToLong(byte[] value) throws Exception {
        if (value.length < 4) {
            throw new Exception("Byte array too short!");
        }
        int temp0 = value[0] & 0xFF;
        int temp1 = value[1] & 0xFF;
        int temp2 = value[2] & 0xFF;
        int temp3 = value[3] & 0xFF;
        return (((long)temp0 << 24) + (temp1 << 16) + (temp2 << 8) + temp3);
    }
}

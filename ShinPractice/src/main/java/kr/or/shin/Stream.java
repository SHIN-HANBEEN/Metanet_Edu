package kr.or.shin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        byte[] inSrc = {1, 2, 3, 4, 5, 6, 7};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//        System.out.println("Input Source: " + Arrays.toString(inSrc));

        try{
            while (input.available() > 0) {
                int len = input.read(temp);
//                System.out.println("input.read(temp) : " + input.read(temp));
                output.write(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outSrc = output.toByteArray();
        System.out.println("Output Source: " + Arrays.toString(outSrc));

    }
}

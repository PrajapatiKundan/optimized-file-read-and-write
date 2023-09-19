package bytestreamuse;

import java.io.*;

public class CopyPasteImage {

    static String inputFileName = "wallpaper.jpg";

    public static void fileCopyWithoutBuffer() {
        System.out.println("--------------------File copy without using buffer--------------------");

        // Output file name
        String outputFileName = "wallpaper_copy_without_buffer.jpg";

        // Measure performance
        long startTime, elapsedTime;

        try (FileInputStream fileInputStream = new FileInputStream(inputFileName);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {

            startTime = System.nanoTime();

            int byteRead = fileInputStream.read();

            while (byteRead != -1) {
                fileOutputStream.write(byteRead);
                byteRead = fileInputStream.read();
            }

            elapsedTime = System.nanoTime() - startTime;

            System.out.println("Elapsed time: " + (elapsedTime / 1000000.0) + " milliseconds");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileCopyUsingBuffer() {
        System.out.println("--------------------File copy using buffer--------------------");

        // Measure performance
        long startTime, elapsedTime;

        // Output file name
        String outputFileName = "wallpaper_copy_with_buffer.jpg";

        try (BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(new FileInputStream(inputFileName));
             BufferedOutputStream bufferedOutputStream =
                    new BufferedOutputStream(new FileOutputStream(outputFileName))) {

            startTime = System.nanoTime();

            byte[] bytesRead = new byte[4000];
            int numOfBytesRead = bufferedInputStream.read(bytesRead);

            while (numOfBytesRead != -1) {
                bufferedOutputStream.write(bytesRead, 0, numOfBytesRead);
                numOfBytesRead = bufferedInputStream.read(bytesRead);
            }

            elapsedTime = System.nanoTime() - startTime;

            System.out.println("Elapsed time: " + (elapsedTime / 1000000.0) + " milliseconds");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        fileCopyWithoutBuffer();
        fileCopyUsingBuffer();
    }
}

/*
Output:
--------------------File copy without using buffer--------------------
Elapsed time: 491.3693 milliseconds

--------------------File copy using buffer--------------------
Elapsed time: 0.6456 milliseconds
*/
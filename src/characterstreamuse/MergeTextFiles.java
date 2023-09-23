package characterstreamuse;

import java.io.*;

public class MergeTextFiles {
    static public String file_one = "file_one.txt";
    static public String file_two = "file_two.txt";
    static public String file_three = "file_three.txt";

    public static void mergeMultipleTextFiles() {

        long startTime, elapsedTime;
        double totalTime;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(file_one),
                             "UTF-8"));
             BufferedWriter bufferedWriter =
                     new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_three),
                             "UTF-8"))) {

            startTime = System.nanoTime();

            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line + "\n");
                line = bufferedReader.readLine();
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed time taken to read and write file_one into file_three: " + (elapsedTime / 1000000.0) + " milliseconds");
            totalTime = (elapsedTime / 1000000.0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(file_two),
                             "UTF-8"));
             BufferedWriter bufferedWriter =
                     new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_three, true),
                             "UTF-8"))) {

            startTime = System.nanoTime();

            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line + "\n");
                line = bufferedReader.readLine();
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed time taken to read and write file_two into file_three: " + (elapsedTime / 1000000.0) + " milliseconds");
            totalTime += (elapsedTime / 1000000.0);
            System.out.println("Total time taken: " + totalTime + " milliseconds");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        mergeMultipleTextFiles();
    }
}

/*
Output:
Elapsed time taken to read and write file_one into file_three: 2.5996 milliseconds
Elapsed time taken to read and write file_two into file_three: 0.6189 milliseconds
Total time taken: 3.2185 milliseconds
*/

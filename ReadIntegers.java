import java.io.*;

public class ReadIntegers {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
            String line = null;
            while((line = in.readLine()) != null)
                System.out.println(Integer.parseInt(line));
        } catch(IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

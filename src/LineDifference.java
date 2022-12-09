import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineDifference {
    public LineDifference() {
    }

    public static void main(String[] args) {
        try {
            BufferedReader a = new BufferedReader(new FileReader("a.txt"));
            BufferedReader b = new BufferedReader(new FileReader("b.txt"));
            String lineA = a.readLine();
            String lineB = b.readLine();

            int diffLineCount;
            for(diffLineCount = 0; lineA != null || lineB != null; lineB = b.readLine()) {
                if (!lineA.equals(lineB)) {
                    ++diffLineCount;
                }

                lineA = a.readLine();
            }

            System.out.println(diffLineCount);
            a.close();
            b.close();
        } catch (IOException var6) {
            System.out.println("File write error: " + var6.getMessage());
        }

    }
}

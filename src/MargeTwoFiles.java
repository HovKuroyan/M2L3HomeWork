import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MargeTwoFiles {
    public MargeTwoFiles() {
    }

    public static void main(String[] args) {
        File c = null;

        try {
            MargeTwoFiles margeTwoFiles = new MargeTwoFiles();
            File a = new File("a.txt");
            File b = new File("b.txt");
            String var10002 = margeTwoFiles.getFileName(a);
            c = new File(var10002 + "_connect_to_" + margeTwoFiles.getFileName(b) + ".txt");
            c.createNewFile();
            Scanner scanner = new Scanner(a);
            PrintWriter writer = new PrintWriter(new FileWriter(c));

            while(scanner.hasNext()) {
                writer.print(scanner.nextLine() + "\n");
            }

            scanner = new Scanner(b);

            while(scanner.hasNext()) {
                writer.print(scanner.nextLine() + "\n");
            }

            writer.close();
        } catch (IOException var7) {
            System.out.println("File write error: " + var7.getMessage());
            c.deleteOnExit();
        }

    }

    String getFileName(File file) {
        String fileName = "";
        String fileNameTxt = file.getName();

        for(int i = 0; fileNameTxt.charAt(i) != '.'; ++i) {
            fileName = fileName + fileNameTxt.charAt(i);
        }

        return fileName;
    }
}

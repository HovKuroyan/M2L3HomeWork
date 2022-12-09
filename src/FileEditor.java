import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileEditor {
    public FileEditor() {
    }
    public static void main(String[] args) {
        File fileCopy = null;

        try {
            FileEditor fileEditor = new FileEditor();
            File file = new File("test.txt");
            String fileName = fileEditor.fileNameLength(file);
            fileCopy = new File(fileName + ".txt");
            fileCopy.createNewFile();
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(new FileWriter(fileCopy));

            while(scanner.hasNext()) {
                writer.print(scanner.nextLine() + "\n");
            }

            writer.close();
        } catch (IOException var7) {
            System.out.println("File write error: " + var7.getMessage());
            fileCopy.deleteOnExit();
        }

    }

    public String fileNameLength(File file) {
        String fileName = "";
        String fileNameTxt = file.getName();

        for(int i = 0; fileNameTxt.charAt(i) != '.'; ++i) {
            fileName = fileName + fileNameTxt.charAt(i);
        }

        fileName = fileName + file.length();
        return fileName;
    }
}
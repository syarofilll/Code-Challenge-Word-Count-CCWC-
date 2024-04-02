import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ccwc {
    public static void main(String[] args) {
        // Pastikan argumen command line tidak kosong
        if (args.length == 0) {
            System.out.println("Usage: ccwc [-c | -l | -w] <file>");
            return;
        }

        // Ambil opsi dan nama file dari argumen command line
        String option = args[0];
        String fileName = args[1];

        // Baca file dan lakukan sesuai dengan opsi yang diberikan
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int byteCount = 0;
            int lineCount = 0;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                byteCount += line.getBytes().length;
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            reader.close();

            // Cek opsi yang diberikan
            switch (option) {
                case "-c":
                    System.out.println(byteCount + " " + fileName);
                    break;
                case "-l":
                    System.out.println(lineCount + " " + fileName);
                    break;
                case "-w":
                    System.out.println(wordCount + " " + fileName);
                    break;
                default:
                    System.out.println(lineCount + " " + wordCount + " " + byteCount + " " + fileName);
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

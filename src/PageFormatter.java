import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Page Formatter.
 * @author Xavier Marti Llull
 */
public class PageFormatter {

    /**
     * Main method. <br>
     * It gets the file path of document.txt and paginates its contents in order
     * to finally write them in a new file called "formattedText.txt"
     * @param args String[] with the arguments of the execution of the program.
     *             (this program does not use any parameter so if the user specifies
     *             any, it is ignored).
     */
    public static void main(String[] args) {

        String file_path = "./document.txt";

        try {
            String formattedText = processText(file_path);
            BufferedWriter writer = new BufferedWriter(new FileWriter("formattedText.txt"));
            writer.write(formattedText);
            writer.close();

        } catch(IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Formatter method. <br>
     * It recieves the file path of the file to be transformed and creates an
     * <i>StringBuilder</i> that recieves the words in the desired format just
     * after they are read from the original file.
     * @param filePath String with the file path of the input file
     * @return String to be written in the output file
     * @throws IOException
     */
    public static String processText(String filePath) throws IOException {

        StringBuilder formattedText = new StringBuilder();
        File input_file = new File(filePath);
        Scanner input = new Scanner(input_file);

        /** Number of chars counter */
        int count_chars = 0;
        /** Number of lines counter */
        int count_lines = 0;

        /** In order to achieve good efficiency, we add the words to <i>formattedText</i>
         * just after they are read instead of putting all the file's content in a String.
         */
        while (input.hasNext()) {

            String word = input.next();

            /** We add the readed word to local variable <i>word</i>
             * and we update the number of chars read with the number of
             * characters of <i>word</i>.
             */
            formattedText.append(word);
            count_chars += word.length();

            /** If the acumulated amount of chars is lower than 80, it
             * means that we have space for the space character that came next */
            if (count_chars < 80) {
                formattedText.append(" ");
                count_chars++;
            }

            /** If we had already surpassed the amount of 80 characters with the
             * addition of the read word, or we have added an space character
             * and we have reached the 80 characters, it's time to introduce a line
             * break and reset the char counter */
            if (count_chars >= 80) {
                formattedText.append("\n");
                count_chars = 0;

                /** In addition, the line counter is updated and it is controlled if
                 *  we have reached 25 lines to add a separation mark that represents
                 *  end of page
                 */
                count_lines++;
                if (count_lines % 25 == 0) formattedText.append("---------- ").append(count_lines / 25).append(" ----------\n");
            }
        }

        return formattedText.toString();
    }
}
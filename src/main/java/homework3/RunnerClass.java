package homework3;

import homework2.classes.Car;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RunnerClass {

    private static Logger logger = LogManager.getLogger(RunnerClass.class);


    public static void main(String[] args) throws IOException {

        File randomText = new File("src\\main\\resources\\textFile.txt");
        FileUtils.touch(randomText);

        //reading the FILE and change text to lower Case.

        String rtext = FileUtils.readFileToString(randomText, "UTF-8").toLowerCase();

        ArrayList<String> splitText = new ArrayList<>(Arrays.asList(rtext.split("")));

        String[] chars = rtext.split("[$&+,:;=?@#|'<>.-^*()%!]| |[0-9]| \n", 0);

        int count = 0;

        for (int i=0; i<chars.length; i++){
            if (StringUtils.countMatches(rtext, chars[i]) == 1){
                count++;
            }
        }

        File resultsFile = new File("src/main/resources/resultFile");
        FileUtils.touch(resultsFile);
        FileUtils.write(resultsFile, "Unique words found: " + count + "\n", "UTF-8");
        logger.info("Total of unique words: "+ count);




    }
}




















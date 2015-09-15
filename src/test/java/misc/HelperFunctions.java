package misc;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Krystian on 2015-09-13.
 */
public class HelperFunctions {
    private static Properties prop;

    public static String getProperty(String key){
        if(prop == null){
            loadProperties();
        }
        return prop.getProperty(key);
    }


    protected static void loadProperties(){
        prop = new Properties();
        InputStream stream = HelperFunctions.class.getClassLoader().getResourceAsStream(
                "configuration.properties");
        try {
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out
                    .println("Cannot locate file \"wikiahomework.properties\"");
        }
    }
    public static void moveCursorOutOfTheWay(){
        try {
            Robot robot = new Robot();
            robot.mouseMove(0, 0);
        } catch (AWTException e) {

            System.out.println("Robot failed ! Cursor might interfere with test !");

        }

    }
}

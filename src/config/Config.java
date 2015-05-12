/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public final class Config {

    public int MAX_PENALTY_POINTS = 3;

    public Config() {
        try {
            getPropValues();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPropValues() throws IOException {
        String result = "";
        Properties prop = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        // get the property value and print it out
        MAX_PENALTY_POINTS = Integer.getInteger(prop.getProperty("points"));

        result += "MAX POINTS = " + MAX_PENALTY_POINTS;

        return result;
    }
}

package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.util.regex_constructor.RegExConstructor;
import by.tc.task01.entity.AppliencesFactory;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.IncorrectPathToFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.tc.task01.dao.util.string_splitter.StringSplitter.splitString;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final static Logger logger = LogManager.getLogger(ApplianceDAOImpl.class);

    public <E> ArrayList<Appliance> find(Criteria<E> criteria, RegExConstructor regExConstructor) throws AnalogIOException, IncorrectPathToFileException {

        //creation of criteria regex pattern
        logger.info("Start of regex construction from specified criteria");
        String regex = regExConstructor.constructRegEx(criteria);
        logger.info("Regex construction is done");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        //getting relative resource address:
        URL resource = ApplianceDAOImpl.class.getResource("/appliances_db.txt");
        File file;

        try {
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException ex) {
            throw new IncorrectPathToFileException("Appliance-source file was't found");
        }

        ArrayList<String> goodsList = new ArrayList<>();
        logger.info("Looking for matches in appliance-source file has started");
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while (br.ready()) {
                String line = br.readLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    goodsList.add(matcher.group());
                }
            }
        } catch (IOException ex) {
            throw new AnalogIOException("Error occured during reading data from file", ex);
        }

        if (goodsList.size() == 0) {
            logger.info("No suitable appliances weren't found");
            return new ArrayList<>();
        }
        logger.info("Looking for matches in appliance-source file is done");


        logger.info("Parsing of matched strings started");
        ArrayList<String> entitiesList = splitString(goodsList);
        logger.info("Parsing of matched strings is done");
        logger.info("Appliances creation started");
        AppliencesFactory appliencesFactory = AppliencesFactory.getInstance();
        ArrayList<Appliance> appliance = appliencesFactory.getAppliance(entitiesList);
        logger.info("Appliances creation is done");
        return appliance;
    }
}

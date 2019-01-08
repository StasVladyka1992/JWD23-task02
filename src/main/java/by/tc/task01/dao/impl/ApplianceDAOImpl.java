package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.parser.StringParser;
import by.tc.task01.dao.regex_constructor.RegexConstructor;
import by.tc.task01.entity.AppliencesFactory;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.NoParametersException;
import by.tc.task01.exception.NullReferenceException;
import by.tc.task01.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final static Logger logger = LogManager.getLogger(ApplianceDAOImpl.class);

    public <E> ArrayList<Appliance> find(Criteria<E> criteria) throws AnalogIOException, NullReferenceException,
            NoParametersException, URISyntaxException {
        //creation of criteria and searching in the file
        logger.info("Start of regex construction from specified criteria");
        String regex = RegexConstructor.constructRegEx(criteria);
        logger.info("Regex construction is done");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        ArrayList<String> goodsList = new ArrayList<String>();
        logger.info("Looking for matches in appliance-source file started");

        //Get resource address:
        URL resource = ApplianceDAOImpl.class.getResource("/appliances_db.txt");
        File file = Paths.get(resource.toURI()).toFile();

        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            while (br.ready()) {
                String line = br.readLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    goodsList.add(matcher.group());
                }
            }
        } catch (IOException ex) {
            throw new AnalogIOException("IOexception was thrown in <find()> (ApplianceDaoImpl)", ex);
        }
        logger.info("Looking for matches in appliance-source file is done");
        if (goodsList.size() == 0) {
            return new ArrayList<Appliance>();
        }
        logger.info("Parsing of matched strings started");
        ArrayList<String> entitiesList = StringParser.parseString(goodsList);
        logger.info("Parsing of matched strings is done");
        logger.info("Appliances creation started");
        ArrayList<Appliance> appliance = AppliencesFactory.getAppliance(entitiesList);
        logger.info("Appliances creation is done");
        return appliance;
    }


    // you may add your own code here

}


//you may add your own new classes
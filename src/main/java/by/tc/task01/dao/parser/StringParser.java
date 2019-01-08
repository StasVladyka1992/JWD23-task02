package by.tc.task01.dao.parser;


import by.tc.task01.exception.NoParametersException;
import by.tc.task01.exception.NullReferenceException;
import by.tc.task01.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Vladyka Stas
 * on 22.12.2018 at 23:38
 **/
public final class StringParser {
    private final static Logger logger = LogManager.getLogger(StringParser.class);
    public static ArrayList<String> parseString(ArrayList<String> goodsList) throws NullReferenceException,NoParametersException{

        if (goodsList.size()==0){
            throw new NoParametersException("NoParametersException was thrown in <parseString>\n");
        }


        if (goodsList == null){
            throw new NullReferenceException("NullReferenceException was thrown in <parseString>\n");
        }

        ArrayList<String> objectAttributes = new ArrayList<String>();
        ArrayList<String> fieldsAndAttributes = new ArrayList<String>();

        //StringS split
            for (String good : goodsList) {
                String[] splittedFields = good.split("[( : )(, )(;)\\s]");
                for (int i = 0; i < splittedFields.length; i++) {
                    objectAttributes.add(splittedFields[i]);
                }
            }

        //Adding non-empty values to list;
        for (int i = 0; i <objectAttributes.size() ; i++) {
            if (!objectAttributes.get(i).equals("")) {
                fieldsAndAttributes.add(objectAttributes.get(i));
            }
        }

    return fieldsAndAttributes;
    }
}

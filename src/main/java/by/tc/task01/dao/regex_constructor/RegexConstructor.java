package by.tc.task01.dao.regex_constructor;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.NullReferenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


/**
 * Created by Vladyka Stas
 * on 22.12.2018 at 0:50
 **/
public class RegexConstructor {
    private static final Logger logger = LogManager.getLogger(RegexConstructor.class);
    public static <E> String constructRegEx(Criteria<E> criteria) throws NullReferenceException {
        if (criteria == null || criteria.getCriteria().size() == 0) {
//            logger.error("NullReferenceException was thrown in <constructRegex()>");
            throw new NullReferenceException("NullReferenceException was thrown in <constructRegex()>\n");
        }

        StringBuilder regex = new StringBuilder();
        int size = criteria.getCriteria().size();

        //main regex template construction
        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            //class name
            String appType = pair.getKey().getClass().getSimpleName();
            //attribute name
            String attribute;
            if (pair.getKey() == null) {
                throw new NullReferenceException("NullReferenceException was thrown in <constructRegEx>\n");
            } else {
                attribute = pair.getKey().toString();
            }

            // if there is only one criteria for searching
            if (size == 1) {
                regex.append(appType + " :.+?" + attribute + "=" + pair.getValue() + "[,;].+");
                return regex.toString();
            }
            // if there are several criterias for searching:
                // regex main template construction
            else {
                regex.append(appType + " :.+?");
                break;
            }
        }
        // repeated part of regex construction
        StringBuilder repeatedPart = new StringBuilder("((");
        int counter = 1;
        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            String attribute = pair.getKey().toString();
            if (counter == size) {
                repeatedPart.append("(" + attribute + "=" + pair.getValue() + "))[,;\\s].+?)");
            } else {
                repeatedPart.append("(" + attribute + "=" + pair.getValue() + ")|");
            }
            counter++;
        }

        //final regular creation
            //adding repeated part of regex
        regex.append(repeatedPart + "{" + (size - 1) + "}");
            //deleting from the end of repeated part "?)"
        regex.append(repeatedPart.substring(1, repeatedPart.length() - 2));
        return regex.toString();
    }
}

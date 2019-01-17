package by.tc.task01.dao.util.regex_constructor;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

/**
 * Created by Vladyka Stas
 * on 18.01.2019 at 0:31
 **/
public class RegExConstructor {
    public  static <E> String constructRegEx(Criteria<E> criteria) {
        StringBuilder regex = new StringBuilder();
        int size = criteria.getCriteria().size();

        //main regex template construction
        //i don't need cycle here, but it is was easier to write code through "foreach" construction
        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            //appType
            String appType = pair.getKey().getClass().getSimpleName();
            //app characteristic value
            String attribute = pair.getKey().toString();
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

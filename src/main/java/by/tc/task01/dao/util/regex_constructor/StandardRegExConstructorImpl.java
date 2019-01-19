package by.tc.task01.dao.util.regex_constructor;

import java.util.Iterator;
import java.util.Map;

import by.tc.task01.entity.criteria.Criteria;


/**
 * Created by Vladyka Stas
 * on 18.01.2019 at 0:31
 **/
public class StandardRegExConstructorImpl implements RegExConstructor {
    public <E> String constructRegEx(Criteria<E> criteria) {
        StringBuilder regex = new StringBuilder();

        // 1) Excluding element with null\empty values
        Iterator<Map.Entry<E, Object>> iter = criteria.getCriteria().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<E, Object> pair = iter.next();
            if (pair.getValue() == null || pair.getValue().equals("")) {
                if (criteria.getCriteria().size() != 1) {
                    iter.remove();
                } else break;
            }
        }
        int size = criteria.getCriteria().size();
        // 2) main regex template construction
        //i don't need cycle here, but it is was easier to write code through "foreach" construction
        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            //appType
            String appType = pair.getKey().getClass().getSimpleName();
            //app characteristic type: CAPACITY, HEIGHT and so on...
            String attribute = pair.getKey().toString();
            // if there is only one criteria for searching
            if (size == 1) {
                //attribute value is undefined
                if (pair.getValue() == null || (pair.getValue().equals(""))) {
                    return regex.append(appType + ".*$").toString();
                }
                //attribute value is defined
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

        // 3) repeated part of regex construction
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
        // 4) final regular creation
            //adding repeated part of regex
        regex.append(repeatedPart + "{" + (size - 1) + "}");
            //deleting from the end of repeated part "?)"
        regex.append(repeatedPart.substring(1, repeatedPart.length() - 2));
        return regex.toString();
    }
}

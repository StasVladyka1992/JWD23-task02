package by.tc.task01.service.util;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.impl.ApplianceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Created by Vladyka Stas
 * on 18.01.2019 at 0:54
 **/
public class CriteriaValidator {
    private static final Logger logger = LogManager.getLogger(ApplianceServiceImpl.class);

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        if (criteria == null || criteria.getCriteria().size() == 0) {
            logger.info("Illegal criterias. Criterias list either doesn't exist or doesn't have any criterias");
            return false;
        }
        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            if (pair.getKey() == null) {
                logger.info("Illegal criterias. Some criteria has null key");
                return false;
            }
        }
        return true;
    }
}


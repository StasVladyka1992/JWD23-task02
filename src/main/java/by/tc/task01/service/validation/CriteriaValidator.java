package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class CriteriaValidator {
    private final static Logger logger = LogManager.getLogger(CriteriaValidator.class);

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        if (criteria == null || criteria.getCriteria().size()==0 ) {
            logger.info("Invalid criteria");
            return false;
        }

        for (Map.Entry<E, Object> pair :
                criteria.getCriteria().entrySet()) {
            if (pair.getKey() == null) {
                logger.info("Invalid criteria");
                return false;
            }
        }
        return true;
    }

}

//you may add your own new classes
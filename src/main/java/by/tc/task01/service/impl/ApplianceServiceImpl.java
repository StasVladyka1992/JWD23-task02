package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.*;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.util.CriteriaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;


public class ApplianceServiceImpl implements ApplianceService {
    private static final Logger logger = LogManager.getLogger(ApplianceServiceImpl.class);

    public <E> ArrayList<Appliance> find(Criteria<E> criteria) throws IncorrectPathToFileException, AnalogIOException {
        logger.info("Validating criteria");
        if (!CriteriaValidator.criteriaValidator(criteria)) {
            return null;
        }
        logger.info("Validation is done");
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        ArrayList<Appliance> appliances = applianceDAO.find(criteria);
        return appliances;
    }
}


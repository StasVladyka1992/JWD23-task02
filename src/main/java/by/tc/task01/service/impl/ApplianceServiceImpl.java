package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.NoParametersException;
import by.tc.task01.exception.NullReferenceException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.CriteriaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;
import java.util.ArrayList;


public class ApplianceServiceImpl implements ApplianceService{
	private static final Logger logger = LogManager.getLogger(ApplianceServiceImpl.class);

	public <E> ArrayList<Appliance> find(Criteria<E> criteria) throws AnalogIOException, NullReferenceException,
			NoParametersException, URISyntaxException {
		logger.info("Validating criteria");
		if (!CriteriaValidator.criteriaValidator(criteria)) {
			return null;
		}
		logger.info("Validation is done");
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		ArrayList<Appliance> appliances;

		appliances = applianceDAO.find(criteria);



		// you may add your own code here

		return appliances;
	}
}

//you may add your own new classes

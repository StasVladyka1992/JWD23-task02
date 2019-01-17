package by.tc.task01.service;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.*;

import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ApplianceService {	
	
	<E> ArrayList<Appliance> find(Criteria<E> criteria) throws IncorrectPathToFileException, AnalogIOException;
	
}

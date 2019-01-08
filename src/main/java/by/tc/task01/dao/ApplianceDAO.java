package by.tc.task01.dao;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.NoParametersException;
import by.tc.task01.exception.NullReferenceException;


import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ApplianceDAO {
	<E> ArrayList<Appliance> find(Criteria<E> criteria) throws AnalogIOException, NullReferenceException, NoParametersException,
			URISyntaxException;
}

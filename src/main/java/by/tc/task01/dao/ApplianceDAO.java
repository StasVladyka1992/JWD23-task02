package by.tc.task01.dao;

import by.tc.task01.dao.util.regex_constructor.RegExConstructor;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.IncorrectPathToFileException;

import java.util.ArrayList;

public interface ApplianceDAO {
	<E> ArrayList<Appliance> find(Criteria<E> criteria, RegExConstructor regExConstructor) throws IncorrectPathToFileException, AnalogIOException;
}

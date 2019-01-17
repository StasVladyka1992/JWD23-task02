package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.*;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws AnalogIOException, IncorrectPathToFileException{

        ArrayList<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria<Oven> criteriaOven = new Criteria<Oven>();
        criteriaOven.add(Oven.CAPACITY, 32);
        logger.info("Criteria object 'Oven' is created");

        appliances = service.find(criteriaOven);

        logger.info("Printing objects with specified criteria");
        PrintApplianceInfo.print(appliances, criteriaOven);
        logger.info("Printing objects with specified criteria is done\n");

        ////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria<>();
        criteriaOven.add(Oven.HEIGHT, 45);
        criteriaOven.add(Oven.DEPTH, 60);
        logger.info("Criteria object 'Oven' is created");

        appliances = service.find(criteriaOven);

        logger.info("Printing objects with specified criteria");
        PrintApplianceInfo.print(appliances, criteriaOven);
        logger.info("Printing objects with specified criteria is finished\n");

        //////////////////////////////////////////////////////////////////

        Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
        criteriaTabletPC.add(TabletPC.COLOR, "blue");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);
        logger.info("Criteria object 'TabletPC' is created");

        appliances = service.find(criteriaTabletPC);

        logger.info("Printing objects with specified criteria");
        PrintApplianceInfo.print(appliances, criteriaTabletPC);
        logger.info("Printing objects with specified criteria is done\n");


//        Criteria<VacuumCleaner> vacuumCriteria = new Criteria<VacuumCleaner>();
//        vacuumCriteria.add(VacuumCleaner.WAND_TYPE, "all-in-one");
//        logger.info("Criteria object 'VacuumCleaner' is created");
//
//        appliances = service.find(vacuumCriteria);
//
//        logger.info("Printing objects with specified criteria");
//        PrintApplianceInfo.print(appliances, vacuumCriteria);
//        logger.info("Printing objects with specified criteria is done\n");

    }
}

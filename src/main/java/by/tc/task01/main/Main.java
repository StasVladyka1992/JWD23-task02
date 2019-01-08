package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.AnalogIOException;
import by.tc.task01.exception.NoParametersException;
import by.tc.task01.exception.NullReferenceException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NullReferenceException, URISyntaxException {

        ArrayList<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        //////////////////////////////////////////////////////////////////

        Criteria<Oven> criteriaOven = new Criteria<Oven>();
        criteriaOven.add(Oven.CAPACITY, 32);
        logger.info("Criteria object 'Oven' is created");
        try {
            appliances = service.find(criteriaOven);
            logger.info("Printing objects with specified criteria");
            PrintApplianceInfo.print(appliances, criteriaOven);
            logger.info("Printing objects with specified criteria is done\n");
        } catch (AnalogIOException|NoParametersException|NullReferenceException e) {
            System.out.println(e.getMessage());
            logger.error(e.getCause().getMessage());
        }

        ////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria<Oven>();
        criteriaOven.add(Oven.HEIGHT, 45);
        criteriaOven.add(Oven.DEPTH, 60);
        logger.info("Criteria object 'Oven' is created");
        try {
            appliances = service.find(criteriaOven);
            logger.info("Printing objects with specified criteria");
            PrintApplianceInfo.print(appliances, criteriaOven);
            logger.info("Printing objects with specified criteria is finished\n");
        } catch (AnalogIOException|NoParametersException|NullReferenceException e) {
            System.out.println(e.getMessage());
            logger.error(e.getCause().getMessage());
        }

        //////////////////////////////////////////////////////////////////

        Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
        criteriaTabletPC.add(TabletPC.COLOR, "blue");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);
        logger.info("Criteria object 'TabletPC' is created");
        try {
            appliances = service.find(criteriaTabletPC);
            logger.info("Printing objects with specified criteria");
            PrintApplianceInfo.print(appliances, criteriaTabletPC);
            logger.info("Printing objects with specified criteria is done\n");
        } catch (AnalogIOException|NoParametersException|NullReferenceException e) {
//            System.out.println(e.getMessage());
            logger.error(e.getCause().getMessage());
        }
    }
}

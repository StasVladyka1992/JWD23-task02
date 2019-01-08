package by.tc.task01.main;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.NullReferenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PrintApplianceInfo {
    private static final Logger logger = LogManager.getLogger(PrintApplianceInfo.class);
    public static <E> void print(ArrayList<Appliance> appliances, Criteria<E> criteria) throws NullReferenceException {

        if (criteria==null||appliances==null){
            System.out.println("Criteria wasn't specified correctly\n");
        }
        else if (appliances.size() == 0) {
            System.out.println("Appliances with specified criteria:\n" + criteria.toString() +
                    "weren't found;\n");
        } else {
            StringBuilder appliancesInfo = new StringBuilder(appliances.get(0).getClass().getSimpleName()
                    + " with specified criteria:\n"
                    + criteria.toString());
            for (Appliance appliance :
                    appliances) {
                appliancesInfo.append(appliance.toString() + "\n");
            }
            System.out.println(appliancesInfo.toString());
        }

    }

    // you may add your own code here

}

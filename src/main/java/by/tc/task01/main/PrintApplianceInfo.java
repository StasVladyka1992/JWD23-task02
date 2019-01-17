package by.tc.task01.main;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PrintApplianceInfo {
    public static <E> void print(ArrayList<Appliance> appliances, Criteria<E> criteria) {

        if (appliances == null) {
            System.out.println("Criteria wasn't specified correctly\n");
        } else if (appliances.size() == 0) {
            String appType = criteria.getCriteria()
                    .entrySet()
                    .iterator()
                    .next()
                    .getKey()
                    .getClass()
                    .getSimpleName();
            System.out.println(appType + " with specified criteria:\n" + criteria.toString() +
                    "wasn't found;\n");
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
}

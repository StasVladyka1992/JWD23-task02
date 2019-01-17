package by.tc.task01.entity;

import by.tc.task01.entity.appliance.*;
import java.util.ArrayList;

/**
 * Created by Vladyka Stas
 * on 23.12.2018 at 20:22
 **/
public final class AppliencesFactory {
    public static ArrayList<Appliance> getAppliance(ArrayList<String> list) {
        ArrayList<Appliance> appliancesList = new ArrayList<Appliance>();
        if (list.size()==0) {
            return appliancesList;
        }

        //finding type of object
        if (list.get(0).equalsIgnoreCase("Oven")) {
            int numberOfFields = Oven.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {
                //creation of new object in 7 strings of ArrayList<String> list
                Oven oven = new Oven();
                for (int j = i * 7 + 1; j < list.size(); j++) {
                    //exit from cycle if (string's number in parameter "list" % numberOfFields)==0
                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("power_consumption")) {
                        oven.setPower_consumption(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("weight")) {
                        oven.setWeight(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("capacity")) {
                        oven.setCapacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("depth")) {
                        oven.setDepth(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("height")) {
                        oven.setHeight(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("width")) {
                        oven.setWidth(Double.parseDouble(array[1]));
                    }
                }
                appliancesList.add(oven);
            }
        }

        if (list.get(0).equalsIgnoreCase("Laptop")) {
            int numberOfFields = Laptop.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {

                Laptop laptop = new Laptop();
                for (int j = i * 7 + 1; j < list.size(); j++) {

                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("battery_capacity")) {
                        laptop.setBattery_capacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("os")) {
                        laptop.setOs(array[1]);
                    } else if (array[0].equalsIgnoreCase("memory_rom")) {
                        laptop.setMemory_rom(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("system_memory")) {
                        laptop.setSystem_memory(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("cpu")) {
                        laptop.setCpu(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("display_inchs")) {
                        laptop.setDisplay_inchs(Double.parseDouble(array[1]));
                    }
                }
                appliancesList.add(laptop);
            }
        }

        if (list.get(0).equalsIgnoreCase("Refrigerator")) {
            int numberOfFields = Refrigerator.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {
                Refrigerator refrigerator = new Refrigerator();
                for (int j = i * 7 + 1; j < list.size(); j++) {

                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("power_consumption")) {
                        refrigerator.setPower_consumption(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("weight")) {
                        refrigerator.setWeight(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("freezer_capacity")) {
                        refrigerator.setFreezer_capacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("overall_capacity")) {
                        refrigerator.setOverall_capacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("height")) {
                        refrigerator.setHeight(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("width")) {
                        refrigerator.setWidth(Double.parseDouble(array[1]));
                    }
                }
                appliancesList.add(refrigerator);
            }
        }

        if (list.get(0).equalsIgnoreCase("VacuumCleaner")) {
            int numberOfFields = VacuumCleaner.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {
                VacuumCleaner vacuumCleaner = new VacuumCleaner();
                for (int j = i * 7 + 1; j < list.size(); j++) {
                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("power_consumption")) {
                        vacuumCleaner.setPower_consumption(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("filter_type")) {
                        vacuumCleaner.setFilter_type(array[1]);
                    } else if (array[0].equalsIgnoreCase("bag_type")) {
                        vacuumCleaner.setBag_type(array[1]);
                    } else if (array[0].equalsIgnoreCase("wand_type")) {
                        vacuumCleaner.setWand_type(array[1]);
                    } else if (array[0].equalsIgnoreCase("motor_speed_regulation")) {
                        vacuumCleaner.setMotor_speed_regulation(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("cleaning_width")) {
                        vacuumCleaner.setCleaning_width(Double.parseDouble(array[1]));
                    }
                }
                appliancesList.add(vacuumCleaner);
            }
        }

        if (list.get(0).equalsIgnoreCase("TabletPC")) {
            int numberOfFields = TabletPC.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {
                //creation of new object in 6 strings of ArrayList<String> list
                TabletPC tabletPC = new TabletPC();
                for (int j = i * 5 + 1; j < list.size(); j++) {
                    //exit from cycle if (string's number in parameter "list" % numberOfFields)==0
                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("battery_capacity")) {
                        tabletPC.setBattery_capacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("dispaly_inches")) {
                        tabletPC.setDisplay_inches(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("memory_rom")) {
                        tabletPC.setMemory_rom(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("flash_memory_capacity")) {
                        tabletPC.setFlash_memory_capacity(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("color")) {
                        tabletPC.setColor(array[1]);
                    }
                }
                appliancesList.add(tabletPC);
            }
        }

        if (list.get(0).equalsIgnoreCase("Speakers")) {
            int numberOfFields = Speakers.class.getDeclaredFields().length + 1;
            int objectsToReturnCounter = list.size() / numberOfFields;
            for (int i = 0; i < objectsToReturnCounter; i++) {
                //creation of new object in 5 strings of ArrayList<String> list
                Speakers speakers = new Speakers();
                for (int j = i * 4 + 1; j < list.size(); j++) {
                    //exit from cycle if (string's number in parameter "list" % numberOfFields)==0
                    if (j % numberOfFields == 0) {
                        break;
                    }
                    String[] array = list.get(j).split("=");
                    if (array[0].equalsIgnoreCase("power_consumption")) {
                        speakers.setPower_consumption(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("number_of_speakers")) {
                        speakers.setNumber_of_speakers(Double.parseDouble(array[1]));
                    } else if (array[0].equalsIgnoreCase("frequency_range")) {
                        speakers.setFrequency_range(array[1]);
                    } else if (array[0].equalsIgnoreCase("cord_length")) {
                        speakers.setCord_length(Double.parseDouble(array[1]));

                    }
                    appliancesList.add(speakers);
                }
            }
        }
    return appliancesList;}
}

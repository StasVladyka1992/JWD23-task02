package by.tc.task01.dao.util.string_splitter;

import java.util.ArrayList;

/**
 * Created by Vladyka Stas
 * on 18.01.2019 at 0:32
 **/
public final class StringSplitter {
    public static ArrayList<String> splitString(ArrayList<String> goodsList) {
        ArrayList<String> fieldsAndAttributes = new ArrayList<>();

        for (String good : goodsList) {
            String[] splittedFields = good.split("[( : )(, )(;)\\s]");
            for (int i = 0; i < splittedFields.length; i++) {
                if (!splittedFields[i].equals("")) {
                    fieldsAndAttributes.add(splittedFields[i]);
                }
            }
        }
        return fieldsAndAttributes;
    }
}

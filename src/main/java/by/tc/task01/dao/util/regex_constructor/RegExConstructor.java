package by.tc.task01.dao.util.regex_constructor;

import by.tc.task01.entity.criteria.Criteria;

/**
 * Created by Vladyka Stas
 * on 19.01.2019 at 10:07
 **/
public interface RegExConstructor {
    <E> String constructRegEx(Criteria<E> criteria);
}

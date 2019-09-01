package com.chen.service;

import com.chen.pojo.MSG;

public interface ClassService {
    MSG getAllFirstClassification();

    MSG getAllSecondClassification(Integer firstClassID);

    MSG getAllThirdClassification(Integer secondClassID);

    MSG updateClass(Integer originalId, String updateData, String className);

    MSG addClass(Integer superiorId, String inputVal, String className);

    MSG removeClass(Integer id, String className);
}

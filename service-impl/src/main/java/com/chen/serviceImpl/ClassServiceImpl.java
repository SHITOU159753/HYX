package com.chen.serviceImpl;

import com.chen.dao.ClassDao;
import com.chen.pojo.MSG;
import com.chen.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDao classDao;


    @Override
    public MSG getAllFirstClassification() {
        List<Map<Integer,String>> allFirstClass = classDao.getFirstClass();

        return MSG.success(allFirstClass);
    }

    @Override
    public MSG getAllSecondClassification(Integer firstClassID) {
        List<Map<Integer,String>> allSecondClass = classDao.getSecondClass(firstClassID);
        return MSG.success(allSecondClass);
    }

    @Override
    public MSG getAllThirdClassification(Integer secondClassID) {
        List<Map<Integer,String>> allThirdClass = classDao.getThirdClass(secondClassID);
        return MSG.success(allThirdClass);
    }

    @Override
    public MSG updateClass(Integer originalId, String updateData, String className) {
        Integer num = 0;
        switch (className){
            case "firstClass":
                num = classDao.updateClass(originalId,updateData,"firstClassification");
                break;
            case "secondClass":
                num = classDao.updateClass(originalId,updateData,"secondClassification");
                break;
            case "thirdClass":
                num = classDao.updateClass(originalId,updateData,"thirdClassification");
                break;
        }
        if(num == 0){
            return MSG.fail("修改失败，未知错误，影响行数为0，请联系管理员");

        }
        return MSG.success(num);
    }

    @Override
    public MSG addClass(Integer superiorId, String inputVal, String className) {
        Integer num = 0;
        switch (className){
            case "firstClass":
                num = classDao.addFirstClass(inputVal);
                break;
            case "secondClass":
                num = classDao.addClass(superiorId,"firstClassifcationID",inputVal,"secondClassification");
                break;
            case "thirdClass":
                num = classDao.addClass(superiorId,"secondClassificationID",inputVal,"thirdClassification");
                break;
        }
        if(num == 0){
            return MSG.fail("新增失败，未知错误，影响行数为0，请联系管理员");

        }
        return MSG.success(num);
    }

    @Override
    public MSG removeClass(Integer id, String className) {
        Integer num = 0;
        switch (className){
            case "firstClass":
                List<Map<Integer,String>> allSecondClass = classDao.getSecondClass(id);
                if(allSecondClass.size() != 0){
                    return MSG.fail("删除失败，该类别下二级分类有数据，请先删除二级分类数据");
                }
                num = classDao.removeClass(id,"firstClassification");
                break;
            case "secondClass":
                List<Map<Integer,String>> allThirdClass = classDao.getThirdClass(id);
                if(allThirdClass.size() != 0){
                    return MSG.fail("删除失败，该类别下三级分类有数据，请先删除三级分类数据");
                }
                num = classDao.removeClass(id,"secondClassification");
                break;
            case "thirdClass":
                num = classDao.removeClass(id,"thirdClassification");
                break;
        }
        if(num == 0){
            return MSG.fail("删除失败，未知错误，影响行数为0，请联系管理员");
        }
        return MSG.success(num);
    }
}

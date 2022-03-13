package by.tms.dao;

import by.tms.servise.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class OperationListHandler implements ValueListIterator{

    @Autowired
    private CalculatorService calculatorService;
    private int cursor;

    public OperationListHandler(){
    }

    @Override
    public int getSize(String username) {
        return calculatorService.getOperationsByUsername(username).size();
    }

    @Override
    public List getCurrentElements(int limit,String username) {
        return calculatorService.getOperationsByUsername(username)
                .stream().skip(cursor).limit(limit).collect(Collectors.toList());
    }

    @Override
    public List getPreviousElements(int limit,String username) {
        if(cursor>=limit){
            cursor = cursor-limit;
        }else cursor = 0;
        return getCurrentElements(limit,username);
    }

    @Override
    public List getNextElements(int limit,String username) {
        if(cursor+limit<getSize(username)){
            cursor = cursor+limit;
        }
        return getCurrentElements(limit,username);
    }
}

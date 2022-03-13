package by.tms.dao;

import java.util.List;

public interface ValueListIterator {

    public int getSize(String username);

    public List getCurrentElements(int limit,String username);

    public List getPreviousElements(int limit,String username);

    public List getNextElements(int limit,String username);
}

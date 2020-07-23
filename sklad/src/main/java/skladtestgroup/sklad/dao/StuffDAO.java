package skladtestgroup.sklad.dao;

import skladtestgroup.sklad.model.Stuff;

import java.util.List;

public interface StuffDAO {
    List<Stuff> allStuff(int page);
    void add (Stuff stuff);
    void delete (Stuff stuff);
    void edit (Stuff stuff);
    Stuff getById (int id);
    int stuffCount();

    boolean checkTitle(String title);
}

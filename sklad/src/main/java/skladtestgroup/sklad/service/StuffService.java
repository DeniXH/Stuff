package skladtestgroup.sklad.service;

import skladtestgroup.sklad.model.Stuff;

import java.util.List;

public interface StuffService {
    List<Stuff> allStuff(int page);
    void add(Stuff stuff);
    void delete(Stuff stuff);
    void edit(Stuff stuff);
    Stuff getById(int id);
    int stuffCount();

    boolean checkTitle(String title);
}

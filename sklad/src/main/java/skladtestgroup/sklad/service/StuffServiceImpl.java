package skladtestgroup.sklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skladtestgroup.sklad.dao.StuffDAO;
import skladtestgroup.sklad.model.Stuff;

import java.util.List;

@Service
public class StuffServiceImpl implements StuffService {

    private StuffDAO stuffDAO;

    @Autowired
    @Transactional
    public void setStuffDAO(StuffDAO stuffDAO){
        this.stuffDAO = stuffDAO;
    }

    @Override
    @Transactional
    public List<Stuff> allStuff(int page) {
        return stuffDAO.allStuff(page);
    }

    @Override
    @Transactional
    public void add(Stuff stuff) {
        stuffDAO.add( stuff );
    }

    @Override
    @Transactional
    public void delete(Stuff stuff) {
        stuffDAO.delete( stuff );
    }

    @Override
    @Transactional
    public void edit(Stuff stuff) {
        stuffDAO.edit( stuff );
    }

    @Override
    @Transactional
    public Stuff getById(int id) {
        return stuffDAO.getById( id );
    }

    @Override
    @Transactional
    public int stuffCount(){return stuffDAO.stuffCount();}

    @Override
    @Transactional
    public boolean checkTitle(String title) {
        return stuffDAO.checkTitle(title);
    }
}

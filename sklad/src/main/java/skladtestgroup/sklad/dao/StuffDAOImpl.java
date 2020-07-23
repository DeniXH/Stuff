package skladtestgroup.sklad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import skladtestgroup.sklad.model.Stuff;
import org.hibernate.query.Query;

import java.util.List;

@Repository
public class StuffDAOImpl implements StuffDAO {
        private SessionFactory sessionFactory;

        @Autowired
        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        @SuppressWarnings("unchecked")
        public List<Stuff> allStuff(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Stuff").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
        }

        @Override
        public int stuffCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Stuff", Number.class).getSingleResult().intValue();
        }

        @Override
        public void add(Stuff stuff) {
            Session session = sessionFactory.getCurrentSession();
            session.persist( stuff );
        }

        @Override
        public void delete(Stuff stuff) {
            Session session = sessionFactory.getCurrentSession();
            session.delete( stuff );
        }

        @Override
        public void edit(Stuff stuff) {
            Session session = sessionFactory.getCurrentSession();
            session.update( stuff );
        }

        @Override
        public Stuff getById(int id) {
            Session session = sessionFactory.getCurrentSession();
            return session.get(Stuff.class, id);
        }

    @Override
    public boolean checkTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Stuff where title = :title");
        query.setParameter("title", title);
        return query.list().isEmpty();
    }
    }
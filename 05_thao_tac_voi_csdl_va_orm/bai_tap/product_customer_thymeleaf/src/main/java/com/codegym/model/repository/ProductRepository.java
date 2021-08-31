package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
//        Session session = null;
//        List<Product> products = null ;
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            products = session.createQuery("from product").getResultList();
//        } finally {
//            if (session != null){
//                session.close();
//            }
//        }
//        return products;
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT c FROM Product AS c", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        ConnectionUtil.entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
//        return ConnectionUtil.entityManager.find(Product.class,id);
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(id);
            product1.setName(product.getName());
            product1.setCategory(product.getCategory());
            product1.setPrice(product.getPrice());
            session.saveOrUpdate(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        ConnectionUtil.entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(id);
            session.remove(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        ConnectionUtil.entityManager.remove(product);
    }
}

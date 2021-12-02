package ru.geekbrains.context.data;

import ru.geekbrains.context.services.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            Product newProduct = session.get(Product.class, product.getId());
            return newProduct;
        }
    }

    @Override
    public void updateAmountById(Long id, Integer delta) {
//            HQL Example:
//            session.createQuery("update User u set u.name = :name where u.id = :id")
//                    .setParameter("name", newName)
//                    .setParameter("id", id)
//                    .executeUpdate();
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setAmount(delta);
            session.getTransaction().commit();
        }
    }
}

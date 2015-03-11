package edu.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import edu.persistence.model.Book;

/**
 *  DAO for Book
 */
@Stateless
public class BookDao
{
   @PersistenceContext(unitName = "jpa-introduction")
   private EntityManager em;

   public void create(Book entity)
   {
      em.persist(entity);
   }

   public void deleteById(Long id)
   {
      Book entity = em.find(Book.class, id);
      if (entity != null)
      {
         em.remove(entity);
      }
   }

   public Book findById(Long id)
   {
      return em.find(Book.class, id);
   }

   public Book findByIsbn(String isbn) {
      TypedQuery<Book> findByIsbn = em.createNamedQuery("bookByIsbn", Book.class);
      findByIsbn.setParameter("isbn", isbn);

      return findByIsbn.getSingleResult();
   }

   public Book update(Book entity)
   {
      return em.merge(entity);
   }

   public List<Book> listAll(Integer startPosition, Integer maxResult)
   {
      TypedQuery<Book> findAllQuery = em.createQuery("SELECT DISTINCT b FROM Book b ORDER BY b.id", Book.class);
      if (startPosition != null)
      {
         findAllQuery.setFirstResult(startPosition);
      }
      if (maxResult != null)
      {
         findAllQuery.setMaxResults(maxResult);
      }
      return findAllQuery.getResultList();
   }
}

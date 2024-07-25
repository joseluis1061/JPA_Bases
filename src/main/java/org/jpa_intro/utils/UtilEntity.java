package org.jpa_intro.utils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {
  private static final EntityManagerFactory entityManagerFactory =  buildEntityManagerFactory();

  private static EntityManagerFactory buildEntityManagerFactory() {
    return Persistence.createEntityManagerFactory("myPersistenceUnit");
  }

  public static EntityManager getEntityManagerFactory(){
    return entityManagerFactory.createEntityManager();
  }

}

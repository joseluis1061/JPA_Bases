package org.jpa_intro.utils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {
  // EntityManagerFactory estático y final patron singleton
  private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

  // Método privado para construir el EntityManagerFactory
  private static EntityManagerFactory buildEntityManagerFactory() {
    // Crea y retorna un EntityManagerFactory usando la unidad de persistencia especificada
    return Persistence.createEntityManagerFactory("myPersistenceUnit");
  }

  // Método público para obtener un nuevo EntityManager
  public static EntityManager getEntityManager() {
    // Crea y retorna un nuevo EntityManager usando el EntityManagerFactory
    return entityManagerFactory.createEntityManager();
  }

}

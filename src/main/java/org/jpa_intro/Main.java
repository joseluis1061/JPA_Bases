package org.jpa_intro;
// Importa la clase User definida en el paquete org.jpa_intro.enity
import org.jpa_intro.enity.User;
// Importa la clase UtilEntity definida en el paquete org.jpa_intro.utils
import org.jpa_intro.utils.UtilEntity;
// Importa la interfaz EntityManager necesaria para JPA
import javax.persistence.EntityManager;
// Importa la interfaz List para manejar colecciones de objetos
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Obtiene un EntityManager para interactuar con la base de datos
    EntityManager em = UtilEntity.getEntityManager();
    // Crea una consulta JPQL para obtener todos los usuarios y ejecuta la consulta
    // e es un alias para los datos de User la segunda e indica todos los datos
    List<User> users = em.createQuery("SELECT e from User e", User.class).getResultList();
    System.out.println("------- Listar Datos -------");
    // Imprime cada usuario en la lista
    users.forEach(System.out::println);
    System.out.println("----------------------------\n");

    System.out.println("------- Buscar empleado por id -------");
    int userId = 1;
    User userByID = em.find(User.class, userId);
    System.out.println(userByID);
    System.out.println("----------------------------\n");

    System.out.println("------- Crear nuevo usuario -------");
    User newUser =  new User();
    newUser.setEmail("correo10@correo.com");
    newUser.setLogin("Logead");
    newUser.setPassword("admin123");
    newUser.setNickname("salesMan");

    em.getTransaction().begin();
    em.persist(newUser);
    em.getTransaction().commit();
    System.out.println("Nuevo empleado creado: "+ newUser);

    System.out.println("----------------------------\n");

    System.out.println("------- Actualizar usuario -------");
    User updateUser =  em.find(User.class, 24);
    updateUser.setLogin("logead");

    em.getTransaction().begin();
    em.persist(updateUser);
    em.getTransaction().commit();
    System.out.println("Empleado actualizado: "+ updateUser);

    System.out.println("----------------------------\n");

    System.out.println("------- Delete usuario -------");
    User deleteUser =  em.find(User.class, 24);
    em.getTransaction().begin();
    em.remove(deleteUser);
    em.getTransaction().commit();
    System.out.println("Empleado borrado: "+ deleteUser);
    System.out.println("----------------------------\n");

    System.out.println("----- Terminar proceso -------");
    em.close();
    System.out.println("----------------------------\n");
  }
}
package org.laboratory;



import jakarta.persistence.*;
import org.laboratory.model.Student;
import org.laboratory.model.Course;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Création des étudiants
        Student student1 = new Student("Ahlam");
        Student student2 = new Student("Ilham");

        // Création des cours
        Course course1 = new Course("Salesforce");
        Course course2 = new Course("Physics");

        // Inscription des étudiants aux cours
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        // Sauvegarde dans la base de données
        em.persist(student1);
        em.persist(student2);
        em.persist(course1);
        em.persist(course2);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Données insérées avec succès !");
    }
}

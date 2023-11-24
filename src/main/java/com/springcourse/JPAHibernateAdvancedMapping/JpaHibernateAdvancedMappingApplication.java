package com.springcourse.JPAHibernateAdvancedMapping;

import com.springcourse.JPAHibernateAdvancedMapping.DAO.AppDAO;
import com.springcourse.JPAHibernateAdvancedMapping.entity.Instructor;
import com.springcourse.JPAHibernateAdvancedMapping.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id =1;

		System.out.println("Deleting Instructor: "+id);
		appDAO.deleteInstructorById(id);

	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Find instrucotr by ID: "+ id);

		Instructor instructorById = appDAO.findInstructorById(id);
		System.out.println("Instroctor: "+ instructorById);
		System.out.println("Instructor Details: "+ instructorById.getInstructorDetails());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Pedro", "Peralta", "teste@email.com");

		InstructorDetails instructorDetails = new InstructorDetails("xptoChannle.com", "Surf");

		instructor.setInstructorDetails(instructorDetails);

		System.out.println("Saving: "+ instructor);
		appDAO.save(instructor);

	}

}

package pat123.pat123;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pat123.pat123.entities.Patients;
import pat123.pat123.repositories.Patientrepositorie;

@SpringBootApplication
public class Pat123Application {

	public static void main(String[] args) {
		SpringApplication.run(Pat123Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(Patientrepositorie patientrepositorie){
       return args ->{
		   patientrepositorie.save(new Patients(null,"KANDE FILS",false));
		   patientrepositorie.save(new Patients(null,"NANA KETCHOP",true));
		   patientrepositorie.save(new Patients(null,"KALALA MUTEMBO",true));
		   patientrepositorie.findAll().forEach(p ->{
			   System.out.println(p.getNom());
		   } );
	   };
	}

}

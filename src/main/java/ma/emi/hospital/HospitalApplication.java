package ma.emi.hospital;

import ma.emi.hospital.entities.Patient;
import ma.emi.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner{

    @Autowired
    private PatientRepository patientRepository ;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"soufiane",new Date(),false,23));
        patientRepository.save(new Patient(null,"anas",new Date(),false,43));
        patientRepository.save(new Patient(null,"hamza",new Date(),false,35));
        patientRepository.save(new Patient(null,"zakarya",new Date(),true,230));
    }
}

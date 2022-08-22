package pat123.pat123.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pat123.pat123.entities.Patients;
public interface Patientrepositorie extends JpaRepository<Patients,Long> {
}

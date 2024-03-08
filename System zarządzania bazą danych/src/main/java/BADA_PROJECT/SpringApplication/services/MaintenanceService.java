package BADA_PROJECT.SpringApplication.services;

import BADA_PROJECT.SpringApplication.entities.Maintenances;
import BADA_PROJECT.SpringApplication.repository.MaintenanceRepository;
import BADA_PROJECT.SpringApplication.servicesInterfaces.MaintenanceServiceInterface;
import com.sun.tools.javac.Main;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MaintenanceService implements MaintenanceServiceInterface {
    MaintenanceRepository maintenanceRepository;
    @Override
    public Maintenances getMaintenance(int id){
        return maintenanceRepository.getReferenceById(id);
    }
    @Override
    public List<Maintenances> getMaintenances() {
        return maintenanceRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Maintenances addMaintenance(Maintenances maintenances) {
        return maintenanceRepository.save(maintenances);
    }

    @Override
    public void deleteMaintenance(int id) {
            maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenances modifyMaintenance(Maintenances maintenances) {
        return maintenanceRepository.save(maintenances);
    }
}

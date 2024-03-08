package BADA_PROJECT.SpringApplication.servicesInterfaces;

import BADA_PROJECT.SpringApplication.entities.Maintenances;

public interface MaintenanceServiceInterface {
    Maintenances getMaintenance(int id);
    Iterable<Maintenances> getMaintenances();
    Maintenances addMaintenance(Maintenances maintenances);
    void deleteMaintenance(int id);
    Maintenances modifyMaintenance(Maintenances maintenances);
}

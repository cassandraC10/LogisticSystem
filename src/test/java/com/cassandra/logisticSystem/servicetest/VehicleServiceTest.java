package com.cassandra.logisticSystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import com.cassandra.logisticSystem.data.model.Vehicle;
import com.cassandra.logisticSystem.data.repository.VehicleRepository;
import com.cassandra.logisticSystem.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    public void testManageVehicles() {

        Vehicle testVehicle = new Vehicle();
        testVehicle.setType("Truck");
        testVehicle.setCapacity(5000);
        testVehicle.setLicensePlateNumber("ABC123");
        testVehicle.setCurrentLocation("Warehouse A");


        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(testVehicle);
        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(testVehicle));


        Vehicle savedVehicle = vehicleService.saveOrUpdateVehicle(testVehicle);


        assertNotNull(savedVehicle);
        assertEquals("Truck", savedVehicle.getType());
        assertEquals(5000, savedVehicle.getCapacity());
        assertEquals("ABC123", savedVehicle.getLicensePlateNumber());
        assertEquals("Warehouse A", savedVehicle.getCurrentLocation());

    }
}

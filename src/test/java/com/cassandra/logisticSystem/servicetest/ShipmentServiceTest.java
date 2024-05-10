package com.cassandra.logisticSystem.servicetest;

import com.cassandra.logisticSystem.data.model.Shipment;
import com.cassandra.logisticSystem.data.repository.ShipmentRepository;
import com.cassandra.logisticSystem.service.ShipmentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ShipmentServiceTest {

    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentService shipmentService;
    @Test
    public void testTrackShipment() {

        Shipment testShipment = new Shipment();
        testShipment.setStatus("In Transit");


        LocalDate currentDate = LocalDate.now();
        LocalDate expectedDeliveryDate = currentDate.plusDays(5);
        Date expectedDeliveryDateAsDate = Date.from(expectedDeliveryDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        testShipment.setDeliveryDate(expectedDeliveryDateAsDate);

        when(shipmentRepository.findById(anyLong())).thenReturn(Optional.of(testShipment));

        Shipment trackedShipment = shipmentService.getShipmentById(1L);

        assertNotNull(trackedShipment);
        assertEquals("In Transit", trackedShipment.getStatus());
        assertEquals(expectedDeliveryDate, trackedShipment.getDeliveryDate());
    }
}

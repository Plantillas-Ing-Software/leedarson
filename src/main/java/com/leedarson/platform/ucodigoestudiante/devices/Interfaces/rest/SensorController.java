package com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Exceptions.SensorAlreadyExistsException;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Services.SensorCommandService;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources.CreateSensorResource;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources.SensorResource;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.transform.CreateSensorCommandFromResourceAssembler;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.transform.SensorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing sensors.
 * Provides endpoints to create and manage sensors.
 */
@RestController
@RequestMapping(value = "/api/v1/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensors", description = "Sensor Management Endpoints")
public class SensorController {

    private final SensorCommandService sensorCommandService;

    /**
     * Constructor for initializing the SensorController with the required service.
     *
     * @param sensorCommandService The service to handle sensor creation logic.
     */
    public SensorController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    /**
     * Creates a new sensor with the provided data.
     *
     * @param resource The data for creating the sensor in the form of a CreateSensorResource object.
     * @return ResponseEntity with the created sensor data in a SensorResource object.
     *         If creation fails, returns a 400 Bad Request response.
     * @throws SensorAlreadyExistsException if a sensor with the same data already exists.
     */
    @Operation(
            summary = "Create a Sensor",
            description = "Creates a Sensor with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sensor created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<SensorResource> createSensor(@RequestBody CreateSensorResource resource) {
        var createSensorCommand = CreateSensorCommandFromResourceAssembler.toCommandFromResource(resource);
        var sensor = sensorCommandService.handle(createSensorCommand);
        if (sensor.isEmpty()) return ResponseEntity.badRequest().build();
        var sensorResource = SensorResourceFromEntityAssembler.toResourceFromEntity(sensor.get());
        return new ResponseEntity<>(sensorResource, HttpStatus.CREATED);
    }

    /**
     * Exception handler for SensorAlreadyExistsException.
     * This method will return a 400 Bad Request response when a sensor already exists.
     *
     * @param ex The exception that is thrown when a sensor already exists.
     * @return ResponseEntity with the exception message.
     */
    @ExceptionHandler(SensorAlreadyExistsException.class)
    public ResponseEntity<String> handleSensorAlreadyExists(SensorAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

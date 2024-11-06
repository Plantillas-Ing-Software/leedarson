package com.leedarson.platform.ucodigoestudiante.devices.Infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and manipulating {@link Sensor} entities in the database.
 * <p>
 *     This interface extends {@link JpaRepository} to provide standard CRUD operations for the {@link Sensor} entity.
 *     It also includes custom query methods to retrieve sensors based on specific attributes.
 * </p>
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    /**
     * Finds a {@link Sensor} by its name, associated sensor type ID, and manufacturer.
     * <p>
     *     This method allows the retrieval of a {@link Sensor} by matching its name, sensor type ID, and manufacturer.
     *     It is useful for ensuring that a sensor with the same attributes does not already exist in the system before
     *     creating a new one.
     * </p>
     *
     * @param name the name of the sensor
     * @param sensorTypeId the ID of the sensor type associated with the sensor
     * @param manufacturer the manufacturer of the sensor
     * @return an {@link Optional} containing the found {@link Sensor} if it exists,
     * or an empty {@link Optional} if no matching sensor is found
     */
    Optional<Sensor> findByNameAndSensorTypeIdAndManufacturer(String name, Long sensorTypeId, String manufacturer);
}

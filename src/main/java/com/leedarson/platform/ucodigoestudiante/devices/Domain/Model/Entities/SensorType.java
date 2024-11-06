package com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Entity representing a Sensor Type.
 * <p>
 *     This entity defines the type of a sensor, such as Temperature, Motion, or Humidity.
 *     It contains the unique identifier and the name of the sensor type.
 * </p>
 */
@Getter
@Entity
public class SensorType {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    protected SensorType() {
    }

    public SensorType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}

package com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Command.CreateSensorCommand;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;
import com.leedarson.platform.ucodigoestudiante.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Represents a Sensor entity in the system.
 * <p>
 *     This class models the Sensor domain object, containing information such as
 *     the sensor's name, type, description, manufacturer, and reference image URL.
 *     It is mapped to a database table via JPA annotations and inherits audit functionality
 *     from {@link AuditableAbstractAggregateRoot}.
 * </p>
 */
@Getter
@Entity
public class Sensor extends AuditableAbstractAggregateRoot<Sensor> {

    @Column(nullable = false, length = 50)
    private String name;

    /**
     * The type of the sensor.
     * This field is a reference to the {@link SensorType} entity.
     * It is mapped as a many-to-one relationship with lazy loading.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_type_id", nullable = false)
    private SensorType sensorType;

    @Column(nullable = false, length = 360)
    private String description;

    @Column(nullable = false, length = 100)
    private String manufacturer;

    @Column(nullable = false)
    private String referenceImageUrl;

    protected Sensor() {}

    /**
     * Constructs a new {@code Sensor} object using the provided command.
     * This constructor is used to create a new sensor entity based on the data provided
     * in the {@link CreateSensorCommand}.
     *
     * @param command the command containing the necessary data to create a new Sensor
     * @see CreateSensorCommand
     */
    public Sensor(CreateSensorCommand command){
        this.name = command.name();
        this.sensorType = command.sensorType();
        this.description = command.description();
        this.manufacturer = command.manufacturer();
        this.referenceImageUrl = command.referenceImageUrl();
    }

}

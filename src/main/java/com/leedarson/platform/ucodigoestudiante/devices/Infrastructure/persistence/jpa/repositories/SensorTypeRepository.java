package com.leedarson.platform.ucodigoestudiante.devices.Infrastructure.persistence.jpa.repositories;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and manipulating {@link SensorType} entities in the database.
 * <p>
 *     This interface extends {@link JpaRepository} to provide standard CRUD operations
 *     for the {@link SensorType} entity.
 *     It is used to manage and retrieve data related to sensor types.
 * </p>
 */
@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {

}

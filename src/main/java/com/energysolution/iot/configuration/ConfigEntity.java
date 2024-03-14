package com.energysolution.iot.configuration;

import com.energysolution.iot.iotdevice.IoTDeviceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "CONFIG")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class ConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", nullable = false, length = 128)
    private String deviceId;

    @ManyToOne
    @JoinColumn(name = "device_key", referencedColumnName = "id")
    private IoTDeviceEntity device;

    @Column(name = "configuration", nullable = false, length = 10000)
    private String configuration;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

}
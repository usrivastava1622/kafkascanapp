package net.sinec.springboot;

import lombok.*;
//import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import javax.persistence.*;

//@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Device1")
@Entity
@Data
@ToString
// @AllArgsConstructor
// @NoArgsConstructor
public class DeviceList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    // @Column(name="IPAddress")
    String ipAddress;

    // @Column(name = "Physical_Address")
    String physicalAddress;

    // @Column(name = "Device_Type")
    String deviceType;

    // @Column(name = "Device_Location")
    String deviceLocation;
}

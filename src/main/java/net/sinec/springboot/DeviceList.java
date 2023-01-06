package net.sinec.springboot;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


//@Entity
//@FieldDefaults(level= AccessLevel.PRIVATE)
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="device_list")
@Data
public class DeviceList {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(name="IPAddress")
    String ipAddress;

//    @Column(name = "Physical_Address")
    String physicalAddress;

//    @Column(name = "Device_Type")
    String deviceType;

//    @Column(name = "Device_Location")
    String deviceLocation;
}

package com.dwteam.driver;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T20:50:18+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class DriverMapperImpl implements DriverMapper {

    @Override
    public Driver toEntity(DriverDTO driverDTO) {
        if ( driverDTO == null ) {
            return null;
        }

        Driver driver = new Driver();

        driver.setUserName( driverDTO.getUserName() );
        driver.setPassWord( driverDTO.getPassWord() );
        driver.setPhoneNumber( driverDTO.getPhoneNumber() );
        driver.setBalance( driverDTO.getBalance() );
        driver.setId( driverDTO.getId() );
        driver.setDriverLicense( driverDTO.getDriverLicense() );

        return driver;
    }

    @Override
    public DriverDTO toDTO(Driver driver) {
        if ( driver == null ) {
            return null;
        }

        DriverDTO driverDTO = new DriverDTO();

        driverDTO.setId( driver.getId() );
        driverDTO.setUserName( driver.getUserName() );
        driverDTO.setPassWord( driver.getPassWord() );
        driverDTO.setPhoneNumber( driver.getPhoneNumber() );
        driverDTO.setDriverLicense( driver.getDriverLicense() );
        driverDTO.setBalance( driver.getBalance() );

        return driverDTO;
    }
}

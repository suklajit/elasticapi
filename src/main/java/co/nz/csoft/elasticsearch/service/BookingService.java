package co.nz.csoft.elasticsearch.service;

import co.nz.csoft.elasticsearch.dto.ExternalReservationDto;

public interface BookingService {
	
	void createReservationThmToHyp(ExternalReservationDto externalReservationDto);

}

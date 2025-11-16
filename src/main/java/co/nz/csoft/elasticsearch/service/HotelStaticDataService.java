package co.nz.csoft.elasticsearch.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import co.nz.csoft.elasticsearch.dto.HotelStaticDataDto;
import co.nz.csoft.elasticsearch.model.CityLocation;
import co.nz.csoft.elasticsearch.thm.dto.ThmPropertyDto;




public interface HotelStaticDataService {
	HotelStaticDataDto createHotelStaticData(HotelStaticDataDto hotelStaticDataDto);

	List<HotelStaticDataDto> createListOfHotelStaticData(List<HotelStaticDataDto> hotelStaticDataDtos);

	List<HotelStaticDataDto> getAllByHotelId(Long hotelId);

	List<HotelStaticDataDto> findByCity(String city);
	
	//List<HotelStaticDataDto> findByCountry(String country);
	List<HotelStaticDataDto> findByCountry(String country, int page, int size);

	void fetchHotelStaticData();

	//ThmPropertyDto fetchPropertyFromHyperguest(String checkIn, int nights, int guests, String hotelIds);

	List<ThmPropertyDto> fetchAndMapAllHotelData();

	ThmPropertyDto checkAvailability(String source,Date fromDate, Date toDate,Integer noOfRooms,Integer noOfPersons,Integer noOfChildren,Long hotelIds);

	void fetchAllCitiesAndSaveToElasticsearch();

	void saveCitiesToNewIndex();

	void savePropertyNamesToNewIndex() throws IOException, Exception;

	


}

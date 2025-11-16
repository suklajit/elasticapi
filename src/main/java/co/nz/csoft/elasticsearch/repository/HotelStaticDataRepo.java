package co.nz.csoft.elasticsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.nz.csoft.elasticsearch.model.HotelStaticData;

@Repository
public interface HotelStaticDataRepo extends JpaRepository<HotelStaticData, Long> {

	List<HotelStaticData> findByHotelId(Long hotelId);

	List<HotelStaticData> findByCity(String city);

	Page<HotelStaticData> findByCountry(String country, Pageable pageable);
	

}

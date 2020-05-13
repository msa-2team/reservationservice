package roomreservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyReservationListRepository extends CrudRepository<MyReservationList, Long> {

    List<MyReservationList> findByReserveId(String reserveId);

}
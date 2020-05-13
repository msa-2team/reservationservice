package roomreservation;

import roomreservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyReservationListViewHandler {


    @Autowired
    private MyReservationListRepository myReservationListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                MyReservationList myReservationList = new MyReservationList();
                // view 객체에 이벤트의 Value 를 set 함
                myReservationList.setReserveId(reserved.getReserveId());
                // view 레파지 토리에 save
                myReservationListRepository.save(myReservationList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCompleted_then_UPDATE_1(@Payload PayCompleted payCompleted) {
        try {
            if (payCompleted.isMe()) {
                // view 객체 조회
                List<MyReservationList> myReservationListList = myReservationListRepository.findByReserveId(payCompleted.getReserveId());
                for(MyReservationList myReservationList : myReservationListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservationList.setReserveStatus(payCompleted.getStatus());
                    // view 레파지 토리에 save
                    myReservationListRepository.save(myReservationList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRejected_then_UPDATE_2(@Payload RoomRejected roomRejected) {
        try {
            if (roomRejected.isMe()) {
                // view 객체 조회
                List<MyReservationList> myReservationListList = myReservationListRepository.findByReserveId(roomRejected.getReserveId());
                for(MyReservationList myReservationList : myReservationListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservationList.setReserveStatus(roomRejected.getStatus());
                    // view 레파지 토리에 save
                    myReservationListRepository.save(myReservationList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayFailed_then_UPDATE_3(@Payload PayFailed payFailed) {
        try {
            if (payFailed.isMe()) {
                // view 객체 조회
                List<MyReservationList> myReservationListList = myReservationListRepository.findByReserveId(payFailed.getReserveId());
                for(MyReservationList myReservationList : myReservationListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservationList.setReserveStatus(payFailed.getStatus());
                    // view 레파지 토리에 save
                    myReservationListRepository.save(myReservationList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_4(@Payload PayCanceled payCanceled) {
        try {
            if (payCanceled.isMe()) {
                // view 객체 조회
                List<MyReservationList> myReservationListList = myReservationListRepository.findByReserveId(payCanceled.getReserveId());
                for(MyReservationList myReservationList : myReservationListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservationList.setReserveStatus(payCanceled.getStatus());
                    // view 레파지 토리에 save
                    myReservationListRepository.save(myReservationList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
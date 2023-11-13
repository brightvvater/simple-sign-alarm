package bitedu.bipa.simplesignalarm.model.dto;
import lombok.Data;

@Data
public class AlarmResDTO {

    private int approvalDocId;
    private int receiverId;
    private String alarmCode;
}

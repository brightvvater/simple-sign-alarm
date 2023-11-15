package bitedu.bipa.simplesignalarm.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AlarmDeleteDTO {
    private int alarmId;
    private Timestamp alarmDate;
    private boolean cocnfirmationStatus;
    private int alarmCode;
    private int approvalDocId;
    private String positionName;
    private String gradeName;
    private String alarmContent;
    private int orgUserId;
}

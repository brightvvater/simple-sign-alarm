package bitedu.bipa.simplesignalarm.model.dto;

import lombok.Data;

@Data
public class AlarmDTO {
    private int alarmId;
    private String alarmDate;
    private boolean confirmationStatus;
    private String alarmCode;
    private int approvalDocId;
    private String alarmContent;
    private String approvalDocTitle;
    private String userName;
    private int orgUserId;
}

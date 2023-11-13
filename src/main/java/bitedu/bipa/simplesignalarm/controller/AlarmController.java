package bitedu.bipa.simplesignalarm.controller;

import bitedu.bipa.simplesignalarm.model.dto.AlarmDTO;
import bitedu.bipa.simplesignalarm.model.dto.AlarmResDTO;
import bitedu.bipa.simplesignalarm.service.AlarmService;
import bitedu.bipa.simplesignalarm.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping("/createNewAlarm")
    public void createNewAlarm(@RequestBody AlarmResDTO alarmResDTO){
        alarmService.createNewAlarm(alarmResDTO.getApprovalDocId(), alarmResDTO.getReceiverId(), alarmResDTO.getAlarmCode());
    }

    @GetMapping("/alarm")
    public List<AlarmDTO> getAlarm(){
        int orgUserId = (int) SessionUtils.getAttribute("orgUserId");
        List<AlarmDTO> alarmDTO = alarmService.selectAlarm(orgUserId);
        return alarmDTO;
    }

    @GetMapping("/alarm/count")
    public int alarmCount(){
        int orgUserId = (int) SessionUtils.getAttribute("orgUserId");
        return alarmService.alarmCount(orgUserId);
    }

    @PutMapping("/alarm/update/{alarmId}")
    public boolean confirmationStatusUpdate(@PathVariable int alarmId) {
        return alarmService.updateConfirmationStatus(alarmId);
    }
}

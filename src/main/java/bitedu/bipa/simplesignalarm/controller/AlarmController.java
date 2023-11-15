package bitedu.bipa.simplesignalarm.controller;

import bitedu.bipa.simplesignalarm.model.dto.AlarmDTO;
import bitedu.bipa.simplesignalarm.model.dto.AlarmResDTO;
import bitedu.bipa.simplesignalarm.service.AlarmService;
import bitedu.bipa.simplesignalarm.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping("/createNewAlarm")
    public void createNewAlarm(@RequestBody AlarmResDTO alarmResDTO){
        alarmService.createNewAlarm(alarmResDTO.getApprovalDocId(), alarmResDTO.getReceiverId(), alarmResDTO.getAlarmCode());
    }

    @GetMapping("/")
    public List<AlarmDTO> getAlarm(){
        System.out.println("alarm controller : " + RequestContextHolder.getRequestAttributes().getSessionId());
        int orgUserId = (int) SessionUtils.getAttribute("orgUserId");
        List<AlarmDTO> alarmDTO = alarmService.selectAlarm(orgUserId);
        return alarmDTO;
    }

    @GetMapping("/count")
    public int alarmCount(){
        int orgUserId = (int) SessionUtils.getAttribute("orgUserId");
        return alarmService.alarmCount(orgUserId);
    }

    @PutMapping("/update/{alarmId}")
    public boolean confirmationStatusUpdate(@PathVariable int alarmId) {
        return alarmService.updateConfirmationStatus(alarmId);
    }

    @DeleteMapping("/alarm/delete/{alarmId}")
    public void deleteAlarm(@PathVariable int alarmId){
        alarmService.deleteAlarm(alarmId);
    }

        @Autowired
        private RedisTemplate<String, Object> redisTemplate;

//        @GetMapping("/get-session/{sessionId}")
//        public Object getSession(@PathVariable String sessionId) {
//            String sessionKey = "spring:session:sessions:" + sessionId;
//            return redisTemplate.opsForValue().get(sessionKey);
//        }

}



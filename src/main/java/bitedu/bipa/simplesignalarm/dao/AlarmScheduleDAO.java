package bitedu.bipa.simplesignalarm.dao;

import bitedu.bipa.simplesignalarm.mapper.AlarmScheduleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AlarmScheduleDAO {

    private final AlarmScheduleMapper alarmScheduleMapper;

    public AlarmScheduleDAO(AlarmScheduleMapper alarmScheduleMapper) {
        this.alarmScheduleMapper = alarmScheduleMapper;
    }

    public int insertAlarmDeleteHistory(int offset, int pageSize) {
        return alarmScheduleMapper.insertAlarmDeleteHistory(offset,pageSize);
    }

    public int deleteAlarmHistory(int offset, int pageSize) {
        return alarmScheduleMapper.deleteAlarmHistory(offset,pageSize);
    }
    public int selectAllCountAlarmHistory(int offset, int pageSize) {
        return alarmScheduleMapper.selectAllCountAlarmHistory(offset, pageSize);
    }
}

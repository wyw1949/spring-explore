package com.yoke.service.impl;

import com.yoke.mapper.RedPacketMapper;
import com.yoke.mapper.UserRedPacketMapper;
import com.yoke.model.RedPacket;
import com.yoke.model.UserRedPacket;
import com.yoke.service.IUserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserRedPacketServiceImpl implements IUserRedPacketService {

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    @Autowired
    private RedPacketMapper redPacketMapper;

    @Transactional
    @Override
    public boolean grabRedPacket(int rpId, int userId) {
        RedPacket redPacket = redPacketMapper.getRedPacketById(rpId);
        if (redPacket != null && redPacket.getStock() > 0){
            redPacketMapper.updateRedPacketById(rpId);
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setUser_id(userId);
            userRedPacket.setAmount(new BigDecimal("10"));
            userRedPacket.setGrab_time(new Date());
            userRedPacket.setRed_packet_id(rpId);
            userRedPacket.setNote("抢到一个红包");
            int result = userRedPacketMapper.grabRedPacket(userRedPacket);
            return result > 0;
        }
        return false;
    }
}

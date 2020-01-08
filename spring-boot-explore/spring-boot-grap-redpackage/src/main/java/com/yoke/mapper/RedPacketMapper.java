package com.yoke.mapper;

import com.yoke.model.RedPacket;
import org.apache.ibatis.annotations.Param;

public interface RedPacketMapper {
    RedPacket getRedPacketById(@Param("id") int id);

    Integer updateRedPacketById(@Param("id") int id);
}

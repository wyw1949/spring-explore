package com.yoke.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserRedPacket {
    private Integer id;
    private Integer red_packet_id;
    private Integer user_id;
    private BigDecimal amount;
    private Date grab_time;
    private String note;
}

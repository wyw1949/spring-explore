package com.yoke.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RedPacket {

    private Integer id;
    private Integer user_id;
    private BigDecimal amount;
    private Date send_date;
    private Integer total;
    private BigDecimal unit_amount;
    private Integer stock;
    private Integer version;
    private String note;


}

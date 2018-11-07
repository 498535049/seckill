package com.spring.test.dm;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;


@TableName("success_killed")
public class SuccessKilled extends Model<SuccessKilled> {
    private Long id;
    @TableField("user_phone")
    private Long userPhone;
    private short state;
    @TableField("create_time")
    private Date createTime;
    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
//多对一,因为一件商品在库存中有很多数量，对应的购买明细也有很多。
//    private Seckill seckill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

//    public Seckill getSeckill() {
//        return seckill;
//    }
//
//    public void setSeckill(Seckill seckill) {
//        this.seckill = seckill;
//    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "id=" + id +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ",userid=" +userid+
                '}';
    }
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

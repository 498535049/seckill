package com.spring.test.dm;

/**
 * 封装执行秒杀后的结果:是否秒杀成功
 * Created by codingBoy on 16/11/27.
 */
public class SeckillExecution {

    private Long id;

    //秒杀执行结果的状态
    private int state;

    //状态的明文标识
    private String stateInfo;

    //当秒杀成功时，需要传递秒杀成功的对象回去
    private SuccessKilled successKilled;

    //秒杀成功返回所有信息
    public SeckillExecution(Long id, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.id = id;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    //秒杀失败
    public SeckillExecution(Long id, SeckillStatEnum statEnum) {
        this.id = id;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

    public Long getSeckillId() {
        return id;
    }

    public void setSeckillId(Long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {

        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "id=" + id +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}

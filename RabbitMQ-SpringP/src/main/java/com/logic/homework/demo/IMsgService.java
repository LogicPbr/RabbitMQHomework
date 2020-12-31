package com.logic.homework.demo;

/**
 * CopyRright(c)2017-2020 Logic  <p>
 * FileName  IMsgService <p>
 * Describe  <p>
 * author   logic <p>
 * version  v1.0 <p>
 * CreateDate  2020-12-31 18:01 <p>
 */
public interface IMsgService {

    public void directSend(String msg);

    public void topicSend(String msg);

    public void fanoutSend(String msg);
}

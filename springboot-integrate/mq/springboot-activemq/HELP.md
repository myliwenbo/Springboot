　　· StreamMessage -- Java原始值的数据流
　　· MapMessage--一套名称-值对
　　· TextMessage--一个字符串对象
　　· ObjectMessage--一个序列化的 Java对象
　　· BytesMessage--一个字节的数据流


    // 签收模式说明
    // AUTO_ACKNOWLEDGE：表示在消费者receive消息的时候自动的签收
    // CLIENT_ACKNOWLEDGE：表示消费者receive消息后必须手动的调用acknowledge()方法进行签收
    // DUPS_OK_ACKNOWLEDGE：签不签收无所谓了，只要消费者能够容忍重复的消息接受，当然这样会降低Session的开销

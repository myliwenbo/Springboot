package vip.xjdai.springbootconfiguration.model;

import lombok.Data;

@Data
public class MessageModel {

    private UserModel userModel;

    public MessageModel(UserModel userModel) {
        this.userModel = userModel;
        System.out.println("create MessageModel");

    }
}

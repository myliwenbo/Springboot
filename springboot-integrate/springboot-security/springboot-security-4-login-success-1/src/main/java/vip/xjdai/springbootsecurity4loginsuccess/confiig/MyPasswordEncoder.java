package vip.xjdai.springbootsecurity4loginsuccess.confiig;

import cn.hutool.crypto.digest.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Bean
//public PasswordEncoder passwordEncoder() {
//        // 配置密码编码器
//        return new MyPasswordEncoder();
//        }
@Component
class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5.create().digestHex16(rawPassword.toString());
    }

    /**
     * 验证
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5.create().digestHex16(rawPassword.toString()));
    }
}
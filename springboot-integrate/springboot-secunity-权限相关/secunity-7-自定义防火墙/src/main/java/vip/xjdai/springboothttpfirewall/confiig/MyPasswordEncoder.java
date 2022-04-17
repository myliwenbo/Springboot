package vip.xjdai.springboothttpfirewall.confiig;

import cn.hutool.crypto.digest.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;

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
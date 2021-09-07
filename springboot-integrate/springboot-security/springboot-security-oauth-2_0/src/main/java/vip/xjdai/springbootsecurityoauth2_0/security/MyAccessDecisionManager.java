package vip.xjdai.springbootsecurityoauth2_0.security;//package vip.xjdai.springbootdemo.security;
//
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//@Service
//public class MyAccessDecisionManager implements AccessDecisionManager {
//
//    /**
//     * @param authentication UserService中循环添加到GrantedAuthority中的权限信息集合
//     * @param object         包含客户端发起的请求的request信息，可以转换为HTTPRequest
//     * @param collection     url所需的权限集合
//     * @throws AccessDeniedException
//     * @throws InsufficientAuthenticationException
//     */
//    @Override
//    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
//        //判断URL所需的权限集合是否为空，为空则放行
//        if (null == collection || collection.size() <= 0) {
//            return;
//        }
//        String needPermission;
//        for (ConfigAttribute c : collection) {
//            //获得所需的权限
//            needPermission = c.getAttribute();
//            //遍历用户拥有的权限与URL所需的权限进行对比
//            for (GrantedAuthority ga : authentication.getAuthorities()) {
//                if (needPermission.trim().equals(ga.getAuthority())){
//                    return;
//                }
//            }
//        }
//        throw new AccessDeniedException("no permission");
//    }
//
//    @Override
//    public boolean supports(ConfigAttribute configAttribute) {
//        return true;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
//

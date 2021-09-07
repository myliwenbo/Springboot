package vip.xjdai.springbootsecurityoauth2_0.security;//package vip.xjdai.springbootdemo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//
//@Service
//public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
//
//    @Autowired
//    private PermissionDao permissionDao;
//
//    private HashMap<String, Collection<ConfigAttribute>> map = null;
//
//
//    public void loadResourceDefine() {
//        map = new HashMap<>();
//        Collection<ConfigAttribute> array;
//        ConfigAttribute cfg;
//        List<Permission> permissions = permissionDao.findAll();
//        for (Permission permission : permissions) {
//            array = new ArrayList<>();
//            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。
//            // 此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
//            cfg = new SecurityConfig(permission.getName());
//            array.add(cfg);
//            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value
//            map.put(permission.getUrl(), array);
//        }
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        if(map ==null) {
//            loadResourceDefine();
//        }
//        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
//        AntPathRequestMatcher matcher;
//        //遍历权限表中的url
//        for (String url : map.keySet()) {
//            matcher = new AntPathRequestMatcher(url);
//            //与request对比，符合则说明权限表中有该请求的URL
//            if(matcher.matches(request)) {
//                return map.get(url);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
//

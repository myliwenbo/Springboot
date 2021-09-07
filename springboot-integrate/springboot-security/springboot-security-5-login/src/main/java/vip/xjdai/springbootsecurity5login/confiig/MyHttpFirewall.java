//package vip.xjdai.springbootsecurity5login.confiig;
//
//import org.springframework.security.web.firewall.FirewalledRequest;
//import org.springframework.security.web.firewall.HttpFirewall;
//import org.springframework.security.web.firewall.RequestRejectedException;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletResponseWrapper;
//
//@Component
//public class MyHttpFirewall implements HttpFirewall {
//
//    @Override
//    public FirewalledRequest getFirewalledRequest(HttpServletRequest request) throws RequestRejectedException {
//        System.out.println("自定义防火墙");
//        return new FirewalledRequest(request) {
//            @Override
//            public void reset() {
//            }
//        };
//    }
//
//    @Override
//    public HttpServletResponse getFirewalledResponse(HttpServletResponse response) {
//        return new HttpServletResponseWrapper(response) {
//            //定义一个子类去做这个 response 的处理
//        };
//
//    }
//}

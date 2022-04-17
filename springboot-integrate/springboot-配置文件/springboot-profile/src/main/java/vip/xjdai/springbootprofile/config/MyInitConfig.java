// package vip.xjdai.springbootprofile.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;
// import org.springframework.web.WebApplicationInitializer;
//
// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
//
// /**
//  * 现在JavaConfig配置方式在逐步取代xml配置方式。
//  * 而WebApplicationInitializer可以看做是Web.xml的替代，它是一个接口。
//  * 通过实现WebApplicationInitializer，在其中可以添加servlet，listener等，在加载Web项目的时候会加载这个接口实现类，
//  * 从而起到web.xml相同的作用
//  */
// @Component
// public class MyInitConfig implements WebApplicationInitializer {
//     @Override
//     public void onStartup(ServletContext servletContext) throws ServletException {
//         servletContext.setInitParameter("spring.profiles.default", "prd");
//     }
// }

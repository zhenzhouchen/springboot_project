//package com.cskaoyan.sb.springboot_project.interceptor;
//
//import com.cskaoyan.sb.springboot_project.bean.Log;
//import com.cskaoyan.sb.springboot_project.service.LogService;
//import com.cskaoyan.sb.springboot_project.util.OperationJudgeUtil;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//@Api("LogInterceptor")
//public class LogInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    LogService logService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //用于创建Session，不写会报Cannot create a session after the response has been committed
//        //原因可能是跨域请求时每次都会产生一个新的sessionId,导致无法获取原session中的数据
//        //用户登录和退出应当在登录时写入Session，解决后将改行删除
//        request.getSession().setAttribute("username", "vincent");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String username = (String) request.getSession().getAttribute("username");
//        //记录当前登录用户的操作
//        if(username != null) {
//            //获取请求的URI
//            String requestURI = request.getRequestURI();
//            String contextPath = request.getContextPath();
//            String op = requestURI.substring(contextPath.length());
//            //获取请求的操作名
//            String action = OperationJudgeUtil.getActionNameByOp(op);
//            //放行不需要记录日志的操作
//            if("ignore".equals(action)) return;
//            String remoteAddr = request.getRemoteAddr();
//            String errno = (String) request.getAttribute("errno"); //使用了request域进行消息传递
//            String result = (String) request.getAttribute("result");
//            //设置Log Bean
//            Log log = new Log();
//            log.setAdmin(username); //当前登录账户名
//            log.setIp(remoteAddr); //管理员ip地址
//            int type = OperationJudgeUtil.getActionType(op);
//            log.setType(type); //操作分类 0:一般操作 1：安全操作 2：订单操作 3：其他操作
//            log.setAction(action); //操作动作 根据requestUri进行判断
//            if("0".equals(errno)) { //操作状态  true成功 false失败 根据Controller返回值进行过判断
//                log.setStatus(true);
//            } else {
//                log.setStatus(false);
//            }
//            //操作结果，或者成功消息，或者失败消息，消息自定义，未设置默认为空串
//            if(result == null) {
//                result = "";
//            }
//            log.setResult(result);
//            //补充信息 直接默认为空串
//            log.setComment("");
//            //创建时间
//            Date date = new Date();
//            log.setAddTime(date); //加入时间
//            log.setUpdateTime(date); //更新时间
//            log.setDeleted(false); //是否删除
//            //写入数据库
//            logService.insertLog(log);
//        }
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}

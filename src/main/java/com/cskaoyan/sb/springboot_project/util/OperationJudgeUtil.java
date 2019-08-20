package com.cskaoyan.sb.springboot_project.util;

public class OperationJudgeUtil {

    public static String getActionNameByOp(String op) {
        switch (op) {
            case "/admin/admin/update":
                return "修改管理员账户";
            case "/admin/admin/delete":
                return "删除管理员账户";
            case "/admin/admin/create":
                return "新增管理员账户";
            case "/admin/auth/login":
                return "登录";
            case "/admin/auth/logout":
                return "退出";
            default:
                return "ignore";
        }
    }

    public static int getActionType(String op) {
        if(op.contains("/admin/admin") || op.contains("/admin/auth")) {
            return 1;//安全操作
        } else if (op.contains("/admin/order") || op.contains("/admin/ship")){
            return 2;//订单操作
        } else if (op.contains("/admin")) {
            return 0;//一般操作
        } else {
            return 3;//其他操作
        }
    }
}

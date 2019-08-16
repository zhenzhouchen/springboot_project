# SpringBoot 商城项目 —— 推广管理

## 思路与概括

- `前后端分离`
        - 前后端是两个应用
            地址不同，请求都是跨域通信的        
    *前端*
        发送请求
        通过 config 中的地址，转发到后端
          
    *后端*
        通过 application.yml 配置数据库、地址
        

- `Controller 编写`
    
    *RestController*
        - 所有请求利用 json格式
        
    *功能*
        传入分页信息
        
        
## 疑难与解答

- `返回不一致？`
    demo 查询返回的是 3个参数
    自己写返回 5个参数，是否有出现错误然后转发？  —— vue 应用自己进行转发的
    
- `springboot 下注入内容`        
    *springboot 怎么注入 sqlsession、mapScanner等？怎么运行的？* 
    
               
        
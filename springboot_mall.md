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
        由于过后要写小程序，不用 contextPath，用窄化请求，前端发送请求不用改
        

- `Controller 编写`
    
    *RestController*
        - 所有请求利用 json格式
        
    *功能*
        传入分页信息
        
## 功能实现汇总
    
- *广告*
    
    `获得所有广告`
        成功信息封装在 bean 中
        bean 中包含查询结果，以及其分页信息
        需要传入 Page，其中包括 page，limit，order，sort 等
            根据 order sort 进行条件查找
    
    `新增广告`
        上传文件时传入文件，data 返回文件信息
        新增时，传入 ad 信息，返回 ad 信息+addTime和 updateTime
        addTime 和 updateTime 并没有在数据库自动更新，需要在 service 加入       
        *明天讲文件上传 —— 不上传文件无法上传广告*

    `修改广告`
        同上
        
    `删除广告`
        其实是 update，将 deleted 设置成 1即可，搜索时要加上 WHERE deleted = 0        
        
    `搜索广告`
        传入一个 page bean 的同时，传入其他内容会如何？
        和 page bean 变量名对应才会传入？
        如果有 name 和 content，值传入 其中有一个会如何？        
        和查询 list 一个请求，只能一起传入然后判断参数条件    
        - 加入 name 和 content 之后，出现无法回显的情况 
        *后证实，debug时出现问题*
        
        - 直接传入参数，在 if test 中判断
            显示的时候出了问题， —— 希望可以 利用数据库监视
            直接查询一点问题没有
        
        先 pull 然后解决冲突吧
    `pull merge 解决冲突`
        先 merge    

- *优惠券*
    `查询数据库`
        数据库字段与 关键字重复，只能加 `` 来解除
    `新增优惠券`
        传入后端数据全是 null，前端有数据
        前端 content-type 是 json，需要用 json传
        出现 json parsing error —— *需要将 array(json) 转成 String(bean)*    
        转换成 array 才能供前端使用 —— *需要使用 TypeHandler？那不是转换数据库的吗* 
        需要将 String 改成 String[]，然后再转换到数据库  
        RequestBody 只需要写一次，过后流就关闭了          
        新增需要返回 id，只能用 *useGeneratedKeys="true" keyProperty="id"*
            但是返回空数据，暂未解决
    
    `更新优惠券`
        更新页需要返回 id   
        同上，也返回空数据
        —— *据说是 String[] 接收才行，明天试试*
        换成了 String[] 问题依旧，环城了 fastjson，报错，手动接收 jsonobject 然后转成 bean 报错        
        *去掉断点 —— 增删改查全部成功！！！*
            是前端有 超时时间的问题，只要在 超时时间内完成断点即可
        
    `删除优惠券`
        同上，需要 RquestBody 
        没有返回，可以直接删    
        
    `模糊查询`
        传入 name、type、status
        可以在前端分离 searchCondition 方法
        也可以不分离直接在后端 if test 判断 —— 解耦的时候方法名改一下，去掉条件判断和参数即可
        
    `优惠券详情`                           
        read： 直接 selectById 即可
        
- *专题管理*
    `新增专题`
        会用到文件上传，明天再弄
        
- *团购规则*
    `增删改查`
        - 没有图片，直接搬砖即可，有，但是不需要上传和修改 
        
    `增加`
        - 需要多表查询，商品ID 查 —— 名称、图片
        - 添加 add_time update_time                              
                                                               
        
## 疑难与解答

- `返回不一致？`
    demo 查询返回的是 3个参数
    自己写返回 5个参数，是否有出现错误然后转发？  —— vue 应用自己进行转发的
    
- `springboot 下注入内容`        
    *springboot 怎么注入 sqlsession、mapScanner等？怎么运行的？* 
    
    
    
               
        
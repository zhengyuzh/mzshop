# mzshop
美妆商城系统 SpringBoot+Vue + 协同过滤算法 + 敏感词过滤 【计算机毕业设计】

1、系统首页的商品推荐采用协同过滤算法。2、用户发表在线交流和商品评价，采用敏感词过滤算法。过滤脏话~
# 目录导航
美妆商城系统升级版本使用说明
视频效果演示地址：<a href ="https://b23.tv/G3JVfEK" >B站视频传送门</a>
数据库地址：<a href ="https://mbd.pub/o/bread/YZWTkp1yaA==" >传送门</a> 
# 安装使用
- 1、下载代码到本地，可以拉取项目代码（前提是系统安装了Git工具）；如果没有安装相关工具，可以直接下载代码压缩包
 ![image](https://github.com/user-attachments/assets/5ba59c7e-ad11-4002-99b7-1655dd9dc97a)

- 2、IDEA工具导入项目代码
  建议使用Maven，IDEA中集成Maven。项目依赖的jar包比较多、使用Maven 来存储 方便一点。切记要修改Maven 配置文件中的jar包下载地址 镜像。使用阿里云 镜像就可以。
  如果没有Maven，也没关系。下载依赖的速度会比较慢，确保pom文件没有爆红。爆红说明相关依赖没有下载成功。
  
  ![image](https://github.com/user-attachments/assets/b7c9525e-8415-4fcf-b4c9-fb41c5361669)
- 3、获取到数据库脚本后，使用可视化操作工具 将数据库脚本导入。我使用的的数据库 是 Mysql 5.7
- 4、项目中的配置文件，需要修改数据库的账号和密码
 
![image](https://github.com/user-attachments/assets/d7269967-7c81-456f-ab41-67b5c330dcc4)
- 5、项目启动
找到项目的启动类Application、启动成功自动进入系统首页。

![image](https://github.com/user-attachments/assets/f7c6edfc-8297-4821-9976-c47b1eaf4506)

- 6、图片上传问题，图上上传后 保存到项目的静态资源下了。src/main/resources/static/file

**数据库**：数据库由于一些个人原因 未公布在Github 上。我的个人微信公众号：**乡下小哥编程**。数据库在这里：<a href ="https://mbd.pub/o/bread/YZWTkp1yaA==" >数据库地址传送门</a>。微信公众号 回复 **美妆系统数据库**， 就可以自动获取数据库脚本的相关链接，一定要 回复 **美妆系统数据库**。错一个字 都无法自动获取到的。

![image](https://github.com/user-attachments/assets/440a07dc-902c-4906-9e1b-961dec651ba4)

- 7、敏感词过滤文本比较大，也没有放到这里。获取方式和数据获取一致，都放在同一个包里。拿到后替换相关文件即可
  
![image](https://github.com/user-attachments/assets/61a4faa5-905b-4962-a363-c84bece0d424)

# 功能模块划分

## 1.1管理员功能
![管理员功能](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/7a10e396-f067-4bfa-99fc-c55b765e28e7)

## 1.2 用户功能
![用户功能](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/260d06ed-050d-4f94-8ab7-65868601cab6)

# 页面介绍

## 用户界面
### 1.1 登录 注册页

![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/17f95a50-5f95-46d1-9d85-d1a459404596)
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/003c1d59-6637-49d8-ba0d-b8711ad83541)

### 1.2 首页 浏览商品 商品详情
首页采用协同过滤算法来实现用户感兴趣的商品推荐

![image](https://github.com/user-attachments/assets/25c5d380-2521-4c1d-8d9f-1b40e07c142d)

![image](https://github.com/user-attachments/assets/c09c1154-f7ae-4381-8931-8d2f033db3b6)

![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/b90e51c0-65ef-431b-87f3-5ece657c6e1e)

### 1.3 购物车
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/59cdf050-886e-4079-a774-b052dd8ae7cd)

### 1.4 订单
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/dd80a14a-eb38-41b2-9919-3dce9fda9e60)

### 1.5 公告
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/1f05b06e-5ebb-4e33-88e0-a07bb6cdb7fa)

### 1.6 在线交流
在线交流使用了敏感词过滤，过滤敏感文本，脏话之类的！！！

![image](https://github.com/user-attachments/assets/757387eb-f749-4d87-b53a-12616bf62d5f)


### 1.7 个人信息
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/cdd1723b-5990-4b32-8d83-2a28a48fb08a)

## 管理员界面
### 1.1 后台首页
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/fef0ef62-d16b-4338-9a2d-6eaa331cb991)

### 1.2 用户信息
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/938c8275-b21e-4478-ab24-a5a3820ae894)

### 1.3 商品详情
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/0b31abb9-322d-4bec-b2bc-bfe499a83399)
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/91514611-30a0-4330-a322-d7f728797239)
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/7ef6083a-e73e-46cd-ac67-78068ab69b19)

### 1.4 商品种类

![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/0cd5f0a8-0932-4d97-be17-0d9a7acccddb)

### 1.5 订单信息
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/4d1d7f68-53b4-48ab-8435-477606abc083)

### 1.6 公告信息
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/ba228720-6e56-48f2-8c90-c966fefaf5c3)
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/5a9815e8-675a-4b45-b53e-57544a239c95)

### 1.7 在线交流
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/cacf6810-849a-4fba-8fdb-a3a5fecd4bda)

### 1.8 修改密码
![image](https://github.com/zhengyuzh/meizhuangshop/assets/95670150/9691bad3-52b3-47c0-bf67-07b2a3ba9ea7)







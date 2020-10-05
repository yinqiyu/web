# yqyblog
## 基于mvc+jdbc+jsp的web学习项目

### 视图界面

    - 用户登录界面
    - error界面
    - 主界面
    - 下载界面

### controller
    - LoginController
    - CreateVerifyImageController
    - GetDownloadListController
    - DownloadController
    - LogoutController
    
### model
    本质就是普通的Java类
	数据的封装：VO(value object)
User.java：封装用户信息
Download.java：对下载资源信息进行封装
	操作的封装：DAO(data access Object)
UserDao.java：封装对用户对象的数据库操作
CreateImage.java：封装对验证码图片操作
DownloadDao.java：封装对下载资源的数据库操作

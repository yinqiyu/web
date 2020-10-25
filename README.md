最后一次更新 2020/10/25

- 项目要求

  1. **视图**

  （1）用户登录界面

使用静态页面，文件名为login.html，包含的元素：用户名文本框、密码文本框、验证码输入文本框、验证码图片（动态随机的，由控制器createVerifyImage.do生成，以图片字节流形式返回给客户端）、登录按钮。

要求：

n 增加适当的样式，使页面美观

n 鼠标移到验证码图片上，鼠标形状变为手状图标，显示提示信息“看不清，换一个”，点击后可以即时更换一张图片

n 样式文件style.css存放在webroot的css目录中

n 脚本文件login.js存放在webroot下的js目录中

n 页面中所需的图片资源存放在webroot下的images目录中

n 点击登录按钮后，以post方式将请求发送给控制器login.do

  ![image-20201025175014522](https://github.com/yinqiyu/web/blob/main/Untitled%201/image-20201025175014522.png)
  
  （2）错误提示页面

使用动态页面，文件名为error.jsp，相对固定不变的内容使用html标签，从服务器servlet返回的动态错误描述信息使用EL（表达式语言）显示。错误信息下方显示“*秒后自动返回到登录页面”，



  ![image-20201025175030144](https://github.com/yinqiyu/web/blob/main/Untitled%201//image-20201025175030144.png)
  
 (3）主页面

使用动态页面，文件名为main.jsp

采取常用的主页布局方式，页面右上角显示，欢迎你：****  【安全退出】，

下面包含若干个功能导航，导航栏菜单中有一项“下载”

要求：

n ***处显示当前登录用户的中文名，如用户名为admin，则显示“管理员”

n 点击【安全退出】，清除存放在session内存放的登录信息，跳转到登录页面

n 用户打开浏览器，直接输入主页面地址，如http://127.0.0.1/excise1/main.jsp，自动跳转到error.jsp页面，在页面中显示错误信息：“你必须登录后才能访问该资源”

n 点击下载，以超链接方式将请求发送至控制器getDownloadList.do


  2.在第一次作业的基础上，增加以下功能：

  （1）实现一周以内免登录功能

  （2）实现用户权限控制功能

  （3）对JDBC的连接关闭操作进行简单封装

  （4）数据库配置信息存放在jdbc.properties文件中

  登录时，用户如果勾选了“一周内免登录”，一旦用户登录成功以后，一周之内，用户访问main.jsp主页面，均可直接访问。

  修改main.jsp主页面的导航菜单

  ![image-20201025175110300](https://github.com/yinqiyu/web/blob/main/Untitled%201/image-20201025175110300.png)
  （4）下载页面

使用动态页面，文件名为download.jsp，

以列表方式显示所有可下载的资源名称，图形，大小，时间，星级，描述，点击按钮后将请求提交给控制器download.do进行处理，资源id可以作为请求参数，将文件下载到本地
   ![image-20201025175014522](https://github.com/yinqiyu/web/blob/main/Untitled%201/A3668768-7576-4D91-AA4D-A42484FA293C.png)

  3.在作业2的基础上，做以下的修改：

  login.html登录页面

  （1）增加数据校验功能，

  在用户名，密码，验证码文本框的blur事件中判断内容是否输入，在下面给出相应的提示。

  ![image-20201025175201675](https://github.com/yinqiyu/web/blob/main/Untitled%201/image-20201025175201675.png)

  （2）登录验证改为ajax方式

  把登录验证方式从表单提交方式修改为ajax异步提交方式，登录失败，将登录错误信息显示在按钮下面，登录成功，直接重定向到main.jsp主页面。

  （3）增加注册页面

  点击“免费注册”，进入register.html页面

  ![image-20201025175149043](https://github.com/yinqiyu/web/blob/main/Untitled%201/image-20201025175149043.png)


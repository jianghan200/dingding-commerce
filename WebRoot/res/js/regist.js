 //表单是否通过检测
		  var flag={
		    "email":false,
		    "nickname":false,
		    "password":false,
		    "repassword":false,
		    "code":false
		  };
		  $(function(){
		  //给"看不清楚"按钮添加处理
		    $("#imgCode").click(function(){
		       $("#imgVcode").attr("src","user/image.action?dt="+new Date().getTime());
		       return false;//阻止<a>的href动作
		    });
		    //给图片添加点击处理
		    $("#imgVcode").click(function(){
		      $("#imgCode").click();
		    
		    });
		  
		  });
		  //通过ajax检验验证码
		  $(function(){
		    $("#txtCode").blur(function(){
		    flag.code = false;//设置成为通过检测
		      var code=$("#txtCode").val();
		      //非空检测
		      if(code == ""){
		        $("#number\\.info").html("<img src='../images/wrong.gif'/>验证码不能为空");
		        return;
		      }
		      $("#number\\.info").html("<img src='../images/window_loading.gif'/>正在检测");
		      $.post(
		        "user/valid.action",
		        {"code":code},
		        //data是接受到服务器响应回来的数据
		        function(data){
		        
		          if(data){
		           //根据返回的boolean结果显示提示信息
		            $("#number\\.info").html("<img src='../images/right.gif'/>验证码正确");
		            
		            flag.code = true;
		            
		          }else{
		             $("#number\\.info").html("<img src='../images/wrong.gif'/>验证码错误");
		          }
		        }
		      );
		    });
		  });
	
		  //邮箱验证
		  $(function(){
		    $("#txtEmail").blur(function(){
		      flag.email = false;
		      var pattern=/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
		      var email = $("#txtEmail").val();   
		      //非空检测
		      if(email == 0){
		        $("#email\\.info").html("<img src='../images/wrong.gif'/>邮箱不能为空");
		        return;
		      }
		        //去除邮箱两边空格查看是否匹配
		       if(!pattern.test($.trim(email))){
		       
		        $("#email\\.info").html("<img src='../images/wrong.gif'/>邮箱格式不正确");
		        return;
		      }
		     
		      $("#email\\.info").html("<img src='../images/window_loading.gif'/>正在检测");
		      $.post(
		        "user/email.action",
		        {"email":email},
		        function(data){
		        //根据返回的boolean结果显示提示信息
		          if(data){
		            $("#email\\.info").html("<img src='../images/right.gif'/>邮箱可以使用");
		             flag.email = true;
		          }else{
		            $("#email\\.info").html("<img src='../images/wrong.gif'/>邮箱已经被占用");
		          }
		        }
		      );
		      
		    });
		  });
		  // 昵称匹配
		  $(function(){
		    $("#txtNickName").blur(function(){
		       flag.nickname = false;
		      var nickName = $("#txtNickName").val();
		    
		      var namePattern = /^[a-z0-9\u4e00-\u9fa5]+$/;
		      if(nickName == 0){
		        $("#name\\.info").html("<img src='../images/wrong.gif'/>昵称不能为空");
		        return false;
		      }else if(!namePattern.test($.trim(nickName))){
		          
		          $("#name\\.info").html("<img src='../images/wrong.gif'/>昵称格式不匹配"); 
		         return false;
		      }else if(nickName.length<4 || nickName.length>20){
		        $("#name\\.info").html("<img src='../images/wrong.gif'/>昵称长度不正确");
		        return false;
		      }else{
		        $("#name\\.info").html("<img src='../images/right.gif'/>昵称正确");
		       
		        return  flag.nickname = true;
		      }
		      
		    });
		  });
		  //密码
		  $(function(){
		    $("#txtPassword").blur(function(){
		      flag.password = false;
		      var password = $("#txtPassword").val();
		      var passwordPattern = /^[a-zA-Z0-9]+$/;
		      if(password == 0){
		        $("#password\\.info").html("<img src='../images/wrong.gif'/>密码不能为空");
		        return;
		      }else if(!passwordPattern.test($.trim(password))){
		         $("#password\\.info").html("<img src='../images/wrong.gif'/>密码格式不匹配");
		         return;
		      }else if(password.length<6||password.length>20){
		          $("#password\\.info").html("<img src='../images/wrong.gif'/>密码长度不正确");
		          return;
		      }else{
		        $("#password\\.info").html("<img src='../images/right.gif'/>密码正确");
		       
		        return  flag.password= true;
		      }
		    });
		  });
		  //再次输入密码
		  $(function(){
		    flag.repassword = false;
		    $("#txtRepeatPass").blur(function(){
		      var password = $("#txtPassword").val();
		      var RepeatPass = $("#txtRepeatPass").val();
		      if(RepeatPass != 0 && RepeatPass == password){
		        $("#password1\\.info").html("<img src='../images/right.gif'/>密码相同");
		        return  flag.repassword = true;
		      }else{
		         $("#password1\\.info").html("<img src='../images/wrong.gif'/>密码不相同");
		         return  flag.repassword = false;
		      }
		    });
		  });
		  
		  	  //表单提交处理
		  	 
		  $(function(){
		    $("#f").submit(function(){
		      //检测表单是否都通过检查
		      if(flag.code&&flag.email&&flag.nickname&&flag.password&&flag.repassword){
		        return true;
		      }else{
		        alert("请检测表单");
		        return false;
		      }
		    });
		  
		  });
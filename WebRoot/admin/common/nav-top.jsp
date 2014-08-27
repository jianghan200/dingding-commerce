<%@page contentType="text/html;charset=utf-8"%>

 <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">丁丁网管理后台</a>
        </div>
        <div class="navbar-collapse collapse">

          <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle"
              data-toggle="dropdown">设置<span class="caret"></span>
            </a>
          <ul class="dropdown-menu" role="menu">
                <li><a href="#">帮助</a>
                </li>
      
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
           
      
                <li><a href="#">帮助中心</a>
                </li>

                <li><a href="#">登出</a>
                </li>


              </ul>
              </li>
          </ul>


          
        
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath() %>/admin/user.action">用户管理</a></li>
            <li><a href="<%=request.getContextPath() %>/admin/show-product.action">商品管理</a></li>
            <li><a href="<%=request.getContextPath() %>/admin/show-order.action">订单管理</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        
        </div>
      </div>
    </div>
    








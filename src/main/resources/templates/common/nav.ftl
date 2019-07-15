<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                管理系统
            </a>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 报价信息 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header"></li>
                <#list Request["provinces"] as province>

                <li><a href="/quotationSheet/getByProvince?province=${province}">${province}</a></li>
                </#list>
            </ul>
        </li>


        <li>
            <a href="/adminInfo/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>
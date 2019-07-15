<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>省份</th>
                            <th>市/县</th>
                            <th>区</th>
                            <th>预计到达时间</th>
                            <th>软体价格</th>
                            <th>板式价格</th>
                            <th>茶几/大理石块</th>
                            <th>电视柜/大理石块<</th>
                            <th>餐桌/大理石块</th>
                            <th>送货费到楼下</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list quotationSheetList as quotation>
                        <tr>
                            <td>${quotation.province!}</td>
                            <td>${quotation.county!}</td>
                            <td>${quotation.district!}</td>
                            <td>${quotation.getTime!}</td>
                            <td>${quotation.softPrice!}</td>
                            <td>${quotation.plankPrice!}</td>
                            <td>${quotation.teaTablePrice!}</td>
                            <td>${quotation.televisionPrice!}</td>
                            <td>${quotation.diningTablePrice!}</td>
                            <td>${quotation.downstairsPrice!}</td>
                            <td><a href="/quotationSheet/index?id=${quotation.id}">修改</a></td>
                            <#--<td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">删除</a></td>-->
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
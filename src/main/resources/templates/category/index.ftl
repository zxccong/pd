<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#--<#include "../common/nav.ftl">-->

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/quotationSheet/save">
                        <div class="form-group">
                            <label>省份</label>
                            <input name="province" type="text" class="form-control" value="${(category.province)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>市/县</label>
                            <input name="county" type="text" class="form-control" value="${(category.county)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>区</label>
                            <input name="district" type="text" class="form-control" value="${(category.district)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>预计到达时间</label>
                            <input name="getTime" type="text" class="form-control" value="${(category.getTime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>软体价格</label>
                            <input name="softPrice" type="number" class="form-control" value="${(category.softPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>板式</label>
                            <input name="plankPrice" type="number" class="form-control" value="${(category.plankPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>茶几/大理石块</label>
                            <input name="teaTablePrice" type="number" class="form-control" value="${(category.teaTablePrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>电视柜</label>
                            <input name="televisionPrice" type="number" class="form-control" value="${(category.televisionPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>餐桌/大理石块</label>
                            <input name="diningTablePrice" type="number" class="form-control" value="${(category.diningTablePrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>送货费到楼下</label>
                            <input name="downstairsPrice" type="number" class="form-control" value="${(category.downstairsPrice)!''}"/>
                        </div>
                        <input hidden type="text" name="id" value="${(category.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
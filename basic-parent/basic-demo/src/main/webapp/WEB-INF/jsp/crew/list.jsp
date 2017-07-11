<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--右侧区域--%>
<div id="page-wrapper">

    <%--右侧区域：头部标题--%>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Task List</h1>
        </div>
    </div>
    <%--右侧区域：头部标题--%>


    <%--右侧区域：整个表格区域--%>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <%--右侧区域：整个表格，按钮操作栏--%>
                <div class="panel-heading">
                    <jsp:include page="search.jsp"/>
                </div><!-- /.panel-heading -->

                <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" data-toggle="modal" data-target="#modalBoxByAdd_CrewBean">Crew Add</button>

                <%--右侧区域：整个表格，表格列表--%>
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <div class="container-fluid">
                            <table id="example" class="table table-responsive table-striped table-bordered table-hover text-center">
                            </table>
                        </div>
                    </div>

                </div>
                <!-- /.panel-body -->

            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>


</div>
<!-- /#page-wrapper -->
<%--右侧区域--%>

<jsp:include page="add.jsp"/>
<jsp:include page="update.jsp"/>

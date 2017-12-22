<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>查看上传文件</title>
<jsp:include page="menu.jsp"></jsp:include>
<script type="text/javascript">
    /*$(function(){
    	$("#btnExport").click(function(){
    		$.post("/mfeng/fileupload/outputexcel",{},function(){
    			
    		});
    	});
    })*/
</script>
    <div class="container">
        <div class="row">
        <div class="panel panel-custom">
            
            <div class="panel-body">
            <caption>上传的文件</caption>
            <form action="/mfeng/fileupload/outputexcel" method="post">
                <input type="submit" value="导出" id="btnExport">
            </form>            
                <table class="table">
                    <tr>
                        <th>序号</th>
                        <th>文件名称</th> 
                    </tr>                
                    <c:forEach items= "${upfiles}" var="d" varStatus="status">
                       <tr>
                           <td>${status.index+1}</td>
                           <td><a href="${d.filepath}">${d.filename }</a></td>
                       </tr>
                       
                    </c:forEach>
                </table>
            </div>        
        </div>         
        </div>
    </div>

</html>
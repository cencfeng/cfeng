<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>上传</title>
<jsp:include page="menu.jsp"></jsp:include>
<script type="text/javascript">
    $(function(){
    	 $("#btnfileuploadsubmit").click(function() {
             var filepath=$("input[name='upfile']").val();
             var extStart=filepath.lastIndexOf(".");
             var ext=filepath.substring(extStart+1,filepath.length).toUpperCase();
              
             if(ext!="TXT"&&ext!="XLSX"&&ext!="XLS"&&ext!="PDF"){
                  alert("图片限于txt,xlsx,xls,pdf");
                  return false;
             }  
    	 });
    })
</script>

    <div class="container">
        <div class="row">
        <div class="panel panel-custom">
             <div class="panel-heading">
                <h3 class="panel-title pull-left">上传资料</h3>
            </div>
            <div class="panel-body">
             <form id="fileupload" action="/mfeng/fileupload/Upload" enctype="multipart/form-data" method="post">
        文件上传:<input type="file" name="upfile">
        <input type="submit" value="上传" class="btn btn_default" id="btnfileuploadsubmit">
    </form>
            </div>        
        </div>         
        </div>
    </div>

</html>
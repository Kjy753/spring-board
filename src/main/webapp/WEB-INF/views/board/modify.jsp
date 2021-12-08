<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Modify&Delete page</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Modify&Delete
            </div>
            <!-- /.panel-heading -->
           <div class="panel-body">
           <form role="form" action="/board/modify" method="post">
	            <div class="form-group">
	                <label>Bno</label>
	                <input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly" > 
	                <!-- 태그의 name 속성을 BoardVO 클래스의 변수와 일치하게 한다. -->
	            </div>
	            <div class="form-group">
	                <label>Title</label>
	                <input class="form-control" name='title' value='<c:out value="${board.title }"/>' > 
	                <!-- 태그의 name 속성을 BoardVO 클래스의 변수와 일치하게 한다. -->
	            </div>
	             <div class="form-group">
	                <label>Text area</label>
	                <textarea class="form-control" rows="3" name='content' > <c:out value="${board.title }"/></textarea>
	            </div>
	             <div class="form-group">
	                <label>Writer</label>
	                <input class="form-control" name='writer' value='<c:out value="${board.writer }"/>' readonly="readonly" >
	            </div>
	            <button type="submit" data-oper='modify' class="btn btn-default" >Modify</button>
                <button type="submit" data-oper='remove' class="btn btn-danger" >Remove</button>
                <button type="submit" data-oper='list' class="btn btn-info" >List</button>
                
                <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
                <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
           </form>
           </div>
           <!-- /.panel-body -->
       </div>
       <!-- /.panel -->
   </div>
   <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		/* 기본동작을 막음. */
		
		var operation = $(this).data("oper");
		/* data-oper 의 값들을 알고 있음 */
		//console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action", "/board/remove");
		}else if(operation === 'list'){
			// list 페이지로
			formObj.attr("action", "/board/list").attr("method","get");
			
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			
		}
		formObj.submit();
	});
});
</script>
<%@include file="../includes/footer.jsp" %>

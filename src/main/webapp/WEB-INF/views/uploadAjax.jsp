<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Upload With Ajax</h1>

<div class='uploadDiv'>
	<input type='file' name='uploadFile' multiple>
</div>
<button id='uploadBtn'>Upload</button>

<!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
     integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
     crossorigin="anonymous"></script>
     
<script>
$(document).ready(function(){
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; //5MB
	
	function checkExtension(fileName, fileSize){
		
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		
		if(regex.test(fileName)){
			alert("해당 종류으 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	$("#uploadBtn").on("click", function(e){
		
		var formData = new FormData();  // 가상의 폼태그에 필요한 파라미터를 담아서 전송
		
		var inputFile = $("input[name='uploadFile']");
		
		var files = inputFile[0].files;
		
		console.log(files);
		
		for(var i = 0; i<files.length; i++){
			
			
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			url:'uploadAjaxAction',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			success: function(result){
				alert("Uploaded");
			}
		});//end $.ajax
	});//end #uploadBtn
});
</script>
</body>
</html>
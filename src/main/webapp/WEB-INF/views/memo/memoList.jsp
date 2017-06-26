<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

 	$(function() {
		
		getList(1,"","");
		
		$("#btn").click(function() {
			
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			memoWrite(writer,contents);
			
			//첫번째 getList(1,"","");
			$("#writer").val("");			
			$("#contents").val("");
			
		});

		
	});


//첫번째 방법----------------------------------------------
/* 	function getList(curPage,kind,search) {
		$.ajax({
			
			url:"getMemoList",
			type:"GET",
			data:{curPage:curPage,kind:kind,search:search},
			success:function(data){
				$("#result").html(data);
			}
			
		});
		
	} */
	
	
//2번째 방법----------------------------------------------
/* 	function getList(curPage,kind,search) {
		$.ajax({
			
			url:"getMemoList",
			type:"GET",
			data:{curPage:curPage,kind:kind,search:search},
			success:function(data){
				$("#result").html(data);
			}
			
		});
		
	} */

	
//JSON ---------------------------------------------
/* 	function getList(curPage,kind,search) {
		$.ajax({
			
			url:"getMemoList",
			type:"GET",
			data:{curPage:curPage,kind:kind,search:search},
			success:function(data){
				data = data.trim();
				data = JSON.parse(data);  
				var result = "<table>";
				
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.date+"</td>";
					result=result+"</tr>";
				});
				
				result=result+"</table>"
				
				$("#result").html(result);
			}
			
		});
		
	} */


//JACKSON ---------------------------------------------

function getList(curPage,kind,search) {
		$.ajax({
			
			url:"getMemoList",
			type:"GET",
			data:{curPage:curPage,kind:kind,search:search},
			success:function(data){
/* 				data = data.trim();
				data = JSON.parse(data);   */
				var result = "<table>";
				
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.reg_date+"</td>";
					result=result+"</tr>";
				});
				
				result=result+"</table>"
				
				$("#result").html(result);
			}
			
		});
		
	}




	function memoWrite(writer,contents) {
		$.ajax({
			url:"./memoWrite",
			type:"POST",
			data:{writer:writer,contents:contents},
			success:function(data){
				//첫번째 방법: alert(data);
				//2번째 방법: $("#result").html(data);
			
				//JACKSON
				var result = "<table>";
				
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.reg_date+"</td>";
					result=result+"</tr>";
				});
				
				result=result+"</table>"
				
				$("#result").html(result);
				
			}
		});
		
	} 
	
	
	

	
	
	

	
	
	
</script>
</head>
<body>

<div id="result">

</div>

<form action="">
<p>작성자:<input type="text" id="writer"></p>
<p>내용:<textarea rows="" cols="" id="contents"></textarea></p>
<p><input type="button" id="btn" value="click"></p>
</form>


</body>
</html>
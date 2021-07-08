<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="zt-TW">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>PublishDetail-Skill Exchange</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <script src="../font-awesome/css/font-awesome.min.css"
        crossorigin="anonymous"></script>
        <style>
        h6 { 
        	  border:1px solid #000;
			  margin-left:40px
        	} 
        .text { 
				margin-left:40px
        	} 	
     	
        </style>
</head>

<body class="sb-nav-fixed">
 <div id="layoutSidenav">
<jsp:include page="/fragment/left.jsp" />
<div id="layoutSidenav_content">
            <main>
          	<table class="table table-hover">
          	<tr>
			<td>類型</td>	
			<td>點擊數</td>
			 </tr>

	<c:choose>
		<c:when test="${empty allSkills}">
			<tr height='36'><td colspan='7' align='center'><font color='red' >查無技能資料</font></td></tr>
		</c:when>
		
		<c:otherwise>
			<c:forEach var='skills' items='${allSkills}'>
					<tr>		
				<td>${skills.typeCN}</td> <!--提供交流/交換項目-->
				<td>${skills.typeCTR}</td> <!--希望交流/交換的內容-->
					</tr>			
		
										
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	</table> 
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2020</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
   	</div>

</body>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>

</html>

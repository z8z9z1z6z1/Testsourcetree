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
    <title>技能類別-Skill Exchange</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <script src="font-awesome/css/font-awesome.min.css"
        crossorigin="anonymous"></script>

</head>

<body class="sb-nav-fixed">
  <div id="layoutSidenav">
  <jsp:include page="/fragment/left.jsp" />
  <div id="layoutSidenav_content">
            <main>
          	<table class="table table-hover">
									<tbody>
										<tr>
											<td width="200px">會員</td>											
											<td width="240px">主旨</td>
											<td>詳情</td>
											<td width="180px"><a href="queryskillClasssort1.do?name=${allSkills[0].skillType}">更新時間</a></td>
											<td width="90px"><a href="queryskillClasssort.do?name=${allSkills[0].skillType}">點擊數</a></td>
										</tr>
									
									</tbody>
			  

	<c:choose>
		<c:when test="${empty allSkills}">
			<tr height='36'><td colspan='7' align='center'><font color='red' >查無技能資料</font></td></tr>
		</c:when>
		
		<c:otherwise>
			<c:forEach var='skills' items='${allSkills}'>
					
									<tbody>
										<tr>
											<td width="200px"><img src="${skills.member.memberPic}" class="collectImg">${skills.member.memberName}</td>												
											<td width="240px"><a href="queryskillDetail.do?name=${skills.publishNo}">${skills.publishTitle}</a></td>
											<td>${skills.publishDetail}</td>
											<td width="120px">${skills.updateTime}</td>
											<td width="90px">${skills.publishCTR}</td>
										</tr>									
									</tbody>
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
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
</body>
</html>

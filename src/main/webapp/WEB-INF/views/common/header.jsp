<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> header</title>
<style>
   body {
       font-family: Arial, sans-serif;
       margin: 0;
       padding: 0;
   }
   nav {
   	width:100%;
       background-color: #333;
       overflow: hidden;
   }
   nav ul {
       list-style-type: none;
       padding: 0;
       margin: 0;
   }
   nav ul li {
       float: left;
   }
   nav ul li a {
       display: block;
       color: white;
       text-align: center;
       padding: 14px 20px;
       text-decoration: none;
   }
   nav ul li a:hover {
       background-color: #111;
   }
</style>
</head>
<body>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/board/list">Board</a></li>
            <li><a href="${pageContext.request.contextPath}/member/logout">Logout</a></li>
            <li><a href="${pageContext.request.contextPath}/member/register">Register</a></li>
            
            
        </ul>
    </nav>
</body>
</html>

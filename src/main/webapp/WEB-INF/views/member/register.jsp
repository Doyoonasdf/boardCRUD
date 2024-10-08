<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
            margin: 0;
        }
        .register-container {
            width: 100%;
            max-width: 400px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .register-container h2 {
            margin-top: 0;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group input:focus {
            border-color: #0056b3;
            outline: none;
        }
        .form-group .error-message {
            color: red;
            font-size: 0.875em;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #0056b3;
            color: white;
            font-size: 1em;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #004494;
        }
        .form-group .login-link {
            text-align: center;
            margin-top: 10px;
        }
        .form-group .login-link a {
            color: #0056b3;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>
        <form action="${pageContext.request.contextPath}/member/SaveRegister" method="post">
            <div class="form-group">
                <label for="id">아이디:</label>
                <input type="text" id="id" name="id" required placeholder="※8-16자 소문자+숫자">
                <c:if test="${not empty errorMessages.id}">
                  <div class="error-message" style="color: red;">${errorMessages.id}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="pwd">비밀번호:</label>
                <input type="password" id="pwd" name="pwd" placeholder="※8-16자 대문자+소문자+숫자" required >
                <c:if test="${not empty errorMessages.pwd}">
                    <div class="error-message" style="color: red;">${errorMessages.pwd}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="pwdConfirm">비밀번호 확인:</label>
                <input type="password" id="pwdConfirm" name="pwdConfirm" required>
                <c:if test="${not empty errorMessages.pwdConfirm}">
                    <div class="error-message" style="color: red;">${errorMessages.pwdConfirm}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" id="name" name="name" required>
                <c:if test="${not empty errorMessages.name}">
                     <div class="error-message" style="color: red;">${errorMessages.name}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="phoneNumber">전화번호:</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" required placeholder="※010-0000-0000">
                <c:if test="${not empty errorMessages.phoneNumber}">
                     <div class="error-message" style="color: red;">${errorMessages.phoneNumber}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" id="email" name="email" required>
                <c:if test="${not empty errorMessages.email}">
                    <div class="error-message" style="color: red;">${errorMessages.email}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="birthDate">생년월일:</label>
                <input type="date" id="birthDate" name="birthDate" required>
                <c:if test="${not empty errorMessages.birthDate}">
                     <div class="error-message" style="color: red;">${errorMessages.birthDate}</div>
                </c:if>
            </div>
            <div class="form-group">
                <button type="submit">회원가입</button>
            </div>
            <div class="form-group login-link">
                <p>이미 계정이 있나요? <a href="${pageContext.request.contextPath}/member/login">로그인</a></p>
            </div>
        </form>
    ${errorMessages}
    </div>
</body>
</html>
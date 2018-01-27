<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>

<c:set value="${pageContext.request.contextPath}" var="root"/>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Plants DB</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="${root}/resources/css/main.css" />
        <link rel="shortcut icon" type="image/x-icon" href="${root}/resources/favicon.ico">
    </head>
    <body class="subpage login-bg">
        <header id="header" class="alt">
            <div class="logo">
                <a href="${root}">Plants DB</a>
            </div>
            <custom:headerRightContent/>
        </header>
        <section id="post" class="wrapper">
            <div class="inner">
                <article class="box">
                    <header class="text-center">
                        <h3><spring:message code="login.form.name" text="Login Form"/></h3>
                        <i>${error}</i>
                        <sec:authorize access="isAuthenticated()">
                            <i><spring:message code="login.cannot.this.time"
                                               text="You can not login at this time. You are already logged in."/></i>
                        </sec:authorize>
                    </header>
                    <sec:authorize access="isAnonymous()">
                        <div class="content">
                            <spring:url value="/login" var="loginUrl"/>
                            <form:form method="POST" action="${loginUrl}" >
                                <div class="field">
                                    <spring:message code="login.form.field.login" text="Login" var="login"/>
                                    <label for="login">${login}</label>
                                    <input type="text" name="login" id="login" placeholder="${login}" />
                                </div>
                                <div class="field">
                                    <spring:message code="login.form.field.password" text="Password" var="password"/>
                                    <label for="password">${password}</label>
                                    <input type="password" name="password" id="password" placeholder="${password}" />
                                </div>
                                <div class="field text-center">
                                    <input type="checkbox" id="remember_me"
                                           name="remember-me" class="login-button" checked>
                                    <label for="remember_me">
                                        <spring:message code="login.form.field.rememberme" text="Remember me"/>
                                    </label>
                                </div>
                                <div class="text-center">
                                    <spring:message code="login.form.button.login" text="Login" var="loginButton"/>
                                    <input type="submit"  value="${loginButton}" class="login-button button special" />
                                    <p>-<spring:message code="login.form.text.or" text="OR"/>-</p>
                                    <spring:message code="login.form.button.login.facebook" text="Facebook Login" var="facebookLoginButton"/>
                                    <a href="#" class="button login-button icon fa-facebook">${facebookLoginButton}</a>
                                </div>
                            </form:form>
                        </div>
                    </sec:authorize>
                </article>
            </div>
        </section>
        <script src="${root}/resources/js/jquery-1.9.1.js"></script>
        <script src="${root}/resources/js/jquery-migrate-1.1.0.js"></script>
        <script src="${root}/resources/js/jquery.scrollex.min.js"></script>
        <script src="${root}/resources/js/skel.min.js"></script>
        <script src="${root}/resources/js/util.js"></script>
        <script src="${root}/resources/js/main.js"></script>
        <script src="${root}/resources/js/localization.js"></script>
    </body>
</html>

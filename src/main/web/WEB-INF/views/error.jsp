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
    <body class="subpage">
        <header id="header" class="alt">
            <div class="logo">
                <a href="${root}">Plants DB</a>
            </div>
            <custom:headerRightContent/>
        </header>
        <section id="post" class="wrapper">
            <div class="inner">
                <article class="">
                    <header class="text-center">
                        <h3>${errorMsg}</h3>
                    </header>
                    <div class="content text-center">
                        <img src="${root}/resources/img/tenor.gif" alt="plant fight" class="error-img">
                    </div>
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

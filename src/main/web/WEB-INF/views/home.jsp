<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<head>
    <title>Plants DB</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
</head>

<body class="subpage">
<header id="header" class="alt">
    <div class="logo">
        <a href="#">Plants Search</a>
    </div>
    <div class="locale">
        <input type="hidden" id="currentLang" value="${pageContext.response.locale}">
        <a href="?lang=en" class="js-lang-en">EN</a>|<a href="?lang=ua" class="js-lang-ua">UA</a>
    </div>
</header>
<!-- Content -->
<!--
        Note: To show a background image, set the "data-bg" attribute below
        to the full filename of your image. This is used in each section to set
        the background image.
    -->
<section id="post" class="wrapper bg-img" data-bg="banner1.jpg">
    <div class="inner">
        <article class="box">
            <header>
                <h2><spring:message code="form.name" text="Criteria form"/></h2>
                <p><spring:message code="form.description" text="Enter criteria to find plants"/></p>
            </header>
            <div class="content">
                <form:form method="POST" modelAttribute="plantForm" cssClass="js-form">
                    <div class="field">
                        <spring:message code="form.field.name" text="Name" var="name"/>
                        <form:label path="name">${name}</form:label>
                        <form:input path="name" name="name" type="text" placeholder="${name}"/>
                        <span class="js-error-name"></span>
                    </div>
                    <div class="field">
                        <spring:message code="form.field.color" text="Color" var="color"/>
                        <form:label path="color">${color}</form:label>
                        <div class="select-wrapper">
                            <form:select path="color" name="color">
                                <form:option value="" label="-"/>
                                <form:options items="${colors}" itemValue="value" itemLabel="displayName"/>
                            </form:select>
                            <span class="js-error-color"></span>
                        </div>
                    </div>
                    <div class="field half first">
                        <spring:message code="form.field.price.from" text="Price from" var="priceFrom"/>
                        <form:label path="priceFrom">${priceFrom}</form:label>
                        <form:input name="priceFrom" path="priceFrom" type="number" placeholder="${priceFrom}"/>
                        <span class="js-error-priceFrom"></span>
                    </div>
                    <div class="field half">
                        <spring:message code="form.field.price.to" text="Price to" var="priceTo"/>
                        <form:label path="priceTo">${priceTo}</form:label>
                        <form:input name="priceTo" path="priceTo" type="number" placeholder="${priceTo}"/>
                        <span class="js-error-priceTo"></span>
                    </div>
                    <div class="field half first">
                        <spring:message code="form.field.height.from" text="Height from" var="heightFrom"/>
                        <form:label path="heightFrom">${heightFrom}</form:label>
                        <form:input name="heightFrom" path="heightFrom" type="number" placeholder="${heightFrom}"/>
                        <span class="js-error-heightFrom"></span>
                    </div>
                    <div class="field half">
                        <spring:message code="form.field.height.to" text="Height to" var="heightTo"/>
                        <form:label path="heightTo">${heightTo}</form:label>
                        <form:input name="heightTo" path="heightTo" type="number" placeholder="${heightTo}"/>
                        <span class="js-error-heightTo"></span>
                    </div>
                    <ul class="actions">
                        <li>
                            <spring:message code="form.button.submit" text="Submit" var="submit"/>
                            <input value="${submit}" class="button alt js-submit" type="submit">
                        </li>
                        <li>
                            <spring:message code="form.button.reset" text="Reset" var="reset"/>
                            <input value="${reset}" class="button alt" type="reset">
                        </li>
                    </ul>
                </form:form>
            </div>
        </article>
    </div>
</section>
<!-- Footer -->
<footer id="footer">
    <div class="inner">
        <h2><spring:message code="search.results" text="Search results"/></h2>
        <div class="js-table-container">

        </div>
    </div>
    <div>
        <a href="#" id="scrollToTop">
            <svg id="svg1"  viewBox="0 0 60 60" preserveAspectRatio="xMaxYMax">
                <image href="resources/img/arrow.svg" width="100%" height="100%" />
            </svg>
        </a>
    </div>
</footer>

<!-- Scripts -->
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery-migrate-1.1.0.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script src="resources/js/jquery.twbsPagination.js"></script>
<script src="resources/js/jquery.twbsPagination.min.js"></script>
<script src="resources/js/jquery.scrolly.min.js"></script>
<script src="resources/js/jquery.scrollex.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/util.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/formsubmit.js"></script>
<script src="resources/js/scrolltop.js"></script>
<script src="resources/js/localization.js"></script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>Plants DB</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
</head>

<body class="subpage">
<header id="header" class="alt">
    <div class="logo"><a href="#">Plants Search </a></div>
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
                <h2>Criteria form</h2>
                <p>Enter criteria to find plants</p>
            </header>
            <div class="content">
                <form:form method="POST" modelAttribute="plantForm" cssClass="js-form">
                    <div class="field">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" name="name" type="text" placeholder="Name"/>
                        <span class="js-error-name hidden"></span>
                    </div>
                    <div class="field">
                        <form:label path="color">Color</form:label>
                        <div class="select-wrapper">
                            <form:select path="color" name="color">
                                <c:forEach var="color" items="${colors}">
                                    <form:option value="${color.value}">${color.displayName}</form:option>
                                </c:forEach>
                            </form:select>
                            <span class="js-error-color hidden"></span>
                        </div>
                    </div>
                    <div class="field half first">
                        <form:label path="priceFrom">Price from</form:label>
                        <form:input name="priceFrom" path="priceFrom" type="number" placeholder="Price from"/>
                        <span class="js--error-priceFrom hidden"></span>
                    </div>
                    <div class="field half">
                        <form:label path="priceTo">Price to</form:label>
                        <form:input name="priceTo" path="priceTo" type="number" placeholder="Price to"/>
                        <span class="js-error-priceTo hidden"></span>
                    </div>
                    <div class="field half first">
                        <form:label path="heightFrom">Height from</form:label>
                        <form:input name="heightFrom" path="heightFrom" type="number" placeholder="Height from"/>
                        <span class="js-error-heightFrom hidden"></span>
                    </div>
                    <div class="field half">
                        <form:label path="heightTo">Height to</form:label>
                        <form:input name="heightTo" path="heightTo" type="number" placeholder="Height to"/>
                        <span class="js-error-heightTo hidden"></span>
                    </div>
                    <ul class="actions">
                        <li>
                            <input value="Submit" class="button alt js-submit" type="submit"></li>
                        <li>
                            <input value="Reset" class="button alt" type="reset"></li>
                    </ul>
                </form:form>
            </div>
        </article>
    </div>
</section>
<!-- Footer -->
<footer id="footer">
    <div class="inner">
        <h2>Search results</h2>
        <div class="table-wrapper">
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Color</th>
                        <th>Height, m</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Color</th>
                    <th>Height, m</th>
                    <th>Price</th>
                </tr>
                    <%--content added with js--%>
                </tbody>
            </table>
        </div>
    </div>
    <div class="center">
        <div class="pagination">
            <a href="#">&laquo;</a>
            <a href="#">1</a>
            <a class="active" href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">&raquo;</a>
        </div>
    </div>
</footer>
<!-- Scripts -->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.scrolly.min.js"></script>
<script src="resources/js/jquery.scrollex.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/util.js"></script>
<script src="resources/js/main.js"></script>
<script src="resources/js/app.js"></script>
</body>
</html>
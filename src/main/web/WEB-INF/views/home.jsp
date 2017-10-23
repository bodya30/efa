<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="${pageContext.request.contextPath}" var="root" scope="application"/>

<head>
    <title>Plants DB</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
</head>

<body class="subpage">
<header id="header" class="alt">
    <div class="logo"><a href="#">Plants Data Base </a></div>
</header>
<!-- Content -->
<!--
        Note: To show a background image, set the "data-bg" attribute below
        to the full filename of your image. This is used in each section to set
        the background image.
    -->
<section id="post" class="wrapper bg-img" data-bg="banner3.jpg">
    <div class="inner">
        <article class="box">
            <header>
                <h2>Criteria form</h2>
                <p>Enter criteria to find plants</p>
            </header>
            <div class="content">
                <form action="#" method="POST">
                    <div class="field">
                        <label for="name">Name</label>
                        <input name="name" id="name" type="text" placeholder="Name"></div>
                    <div class="field">
                        <label for="color">Color</label>
                        <div class="select-wrapper">
                            <select name="color" id="color">
                                <option value="">Color</option>
                                <option value="1">Manufacturing</option>
                                <option value="1">Shipping</option>
                                <option value="1">Administration</option>
                                <option value="1">Human Resources</option>
                            </select>
                        </div>
                    </div>
                    <div class="field half first">
                        <label for="priceFrom">Price from</label>
                        <input name="priceFrom" id="priceFrom" type="number" placeholder="Price from"/></div>
                    <div class="field half">
                        <label for="priceTo">Price to</label>
                        <input name="priceTo" id="priceTo" type="number" placeholder="Price to"/></div>
                    <div class="field half first">
                        <label for="heightFrom">Height from</label>
                        <input name="heightFrom" id="heightFrom" type="number" placeholder="Height from"/></div>
                    <div class="field half">
                        <label for="heightTo">Height to</label>
                        <input name="heightTo" id="heightTo" type="number" placeholder="Height to"/></div>
                    <ul class="actions">
                        <li>
                            <input value="Submit" class="button alt" type="submit"></li>
                        <li>
                            <input value="Reset" class="button alt" type="reset"></li>
                    </ul>
                </form>
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
                        <td>Item 1</td>
                        <td>Ante turpis integer aliquet porttitor.</td>
                        <td>29.99</td>
                        <td>29.99</td>
                        <td>29.99</td>
                    </tr>
                    <tr>
                        <td>Item 2</td>
                        <td>Vis ac commodo adipiscing arcu aliquet.</td>
                        <td>19.99</td>
                    </tr>
                    <tr>
                        <td>Item 3</td>
                        <td> Morbi faucibus arcu accumsan lorem.</td>
                        <td>29.99</td>
                    </tr>
                    <tr>
                        <td>Item 4</td>
                        <td>Vitae integer tempus condimentum.</td>
                        <td>19.99</td>
                    </tr>
                    <tr>
                        <td>Item 5</td>
                        <td>Ante turpis integer aliquet porttitor.</td>
                        <td>29.99</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2"></td>
                        <td>100.00</td>
                    </tr>
                </tfoot>
            </table>
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
</body>
</html>
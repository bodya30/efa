<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="table-wrapper">
    <c:choose>
        <c:when test="${not empty pageableData.plants}">
            <spring:message code="search.results.table.column.image" text="Image" var="image"/>
            <spring:message code="search.results.table.column.name" text="Name" var="name"/>
            <spring:message code="search.results.table.column.color" text="Color" var="color"/>
            <spring:message code="search.results.table.column.height" text="Height, m" var="height"/>
            <spring:message code="search.results.table.column.price" text="Price" var="price"/>
            <table>
                <thead>
                <tr>
                    <th>${image}</th>
                    <th>${name}</th>
                    <th>${color}</th>
                    <th>${height}</th>
                    <th>${price}</th>
                </tr>
                </thead>
                <tbody class="js-img-popups-parent">
                    <c:forEach items="${pageableData.plants}" var="plant">
                        <tr>
                            <td>
                                <span class="image left">
                                    <a href="images/${plant.img}">
                                        <img src="images/${plant.img}">
                                    </a>
                                </span>
                            </td>
                            <td data-label="${name}">${plant.name}</td>
                            <td data-label="${color}">${plant.color.displayName}</td>
                            <td data-label="${height}">${plant.height}</td>
                            <td data-label="${price}">${plant.price}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p><spring:message code="search.results.table.empty" text="No plants found"/></p>
        </c:otherwise>
    </c:choose>
</div>
<div class="center">
    <input type="hidden" name="totalPageCount" value="${pageableData.totalPageCount}"/>
    <input type="hidden" name="pageSize" value="${pageableData.pageSize}"/>
    <input type="hidden" name="pageNumber" value="${pageableData.pageNumber}"/>
    <div class="js-pagination pagination"></div>
    <script src="resources/js/imgpopup.js"></script>
</div>
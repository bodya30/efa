<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="table-wrapper">
    <c:choose>
        <c:when test="${not empty pageableData.plants}">
            <table>
                <thead>
                <tr>
                    <th><spring:message code="search.results.table.column.image" text="Image"/></th>
                    <th><spring:message code="search.results.table.column.name" text="Name"/></th>
                    <th><spring:message code="search.results.table.column.color" text="Color"/></th>
                    <th><spring:message code="search.results.table.column.height" text="Height, m"/></th>
                    <th><spring:message code="search.results.table.column.price" text="Price"/></th>
                </tr>
                </thead>
                <tbody class="js-img-popups-parent">
                    <c:forEach items="${pageableData.plants}" var="plant">
                        <tr>
                            <td>
                                <span class="image left">
                                    <a href="resources/img/plants/${plant.img}">
                                        <img src="resources/img/plants/${plant.img}">
                                    </a>
                                </span>
                            </td>
                            <td>${plant.name}</td>
                            <td>${plant.color.displayName}</td>
                            <td>${plant.height}</td>
                            <td>${plant.price}</td>
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
    <div class="js-pagination"></div>
    <script src="resources/js/imgpopup.js"></script>
</div>
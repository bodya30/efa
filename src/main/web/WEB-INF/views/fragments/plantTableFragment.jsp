<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="table-wrapper">
    <c:choose>
        <c:when test="${not empty pageableData.plants}">
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
                    <c:forEach items="${pageableData.plants}" var="plant">
                        <tr>
                            <td>
                                <span class="image left">
                                    <img src="resources/img/plants/${plant.img}">
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
            <p>No plants found</p>
        </c:otherwise>
    </c:choose>
</div>
<div class="center">
    <input type="hidden" name="totalPageCount" value="${pageableData.totalPageCount}"/>
    <input type="hidden" name="pageSize" value="${pageableData.pageSize}"/>
    <input type="hidden" name="pageNumber" value="${pageableData.pageNumber}"/>
    <div class="js-pagination"></div>
</div>
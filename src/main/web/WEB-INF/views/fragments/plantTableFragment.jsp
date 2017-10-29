<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</div>
<c:if test="${pageableData.totalPageCount gt 1}">
    <div class="center">
        <div class="pagination js-pagination">
            <c:forEach begin="0" end="${pageableData.totalPageCount-1}" varStatus="iteration">
                <c:set var="i" value="${iteration.index}"/>
                <c:if test="${iteration.first}">
                    <a href="${i-1}">&laquo;</a>
                </c:if>
                <a class="js-page ${pageableData.pageNumber eq i ? 'active' : ''}" href="${i}">${i+1}</a>
                <c:if test="${iteration.last}">
                    <a href="${i+1}">&raquo;</a>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:if>
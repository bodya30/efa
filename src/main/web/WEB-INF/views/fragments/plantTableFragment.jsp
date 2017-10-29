<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${pageableData.plants}" var="plant">
    <tr>
        <td>
            <span class="image left">
                <img src="${plant.imgUrl}">
            </span>
        </td>
        <td>${plant.name}</td>
        <td>${plant.color.displayName}</td>
        <td>${plant.height}</td>
        <td>${plant.price}</td>
    </tr>
</c:forEach>
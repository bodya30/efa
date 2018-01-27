<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<sec:authorize url="/logout">
    <spring:url value="/logout" var="logoutUrl"/>
    <%--use http post because of csrf--%>
    <form:form method="post" action="${logoutUrl}" cssClass="logout-form">
        <spring:message code="logout.form.button" text="Logout" var="logout"/>
        <input type="submit" value="${logout}" class="logout-button button alt small"/>
    </form:form>
</sec:authorize>

<div class="locale">
    <input type="hidden" id="currentLang" value="${pageContext.response.locale}">
    <a href="?lang=en" class="js-lang-en">EN</a>|<a href="?lang=ua" class="js-lang-ua">UA</a>
</div>
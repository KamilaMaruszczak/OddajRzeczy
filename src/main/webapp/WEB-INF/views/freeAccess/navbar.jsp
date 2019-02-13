<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
<script src="/resources/js/app.js"></script>
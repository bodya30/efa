"use strict";
$(document).ready(function() {
    var currentLang = $("#currentLang").val();
    $(".js-lang-" + currentLang).css("font-weight", "bold");
});
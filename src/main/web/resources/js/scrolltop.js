"use strict";
$(document).ready(function(){
    var scrollButton = $('#scrollToTop');

    $(window).scroll(function(){
        if ($(this).scrollTop() > 1000) {
            scrollButton.fadeIn()
        } else {
            scrollButton.fadeOut();
        }
    });

    scrollButton.click(function(){
        $('html, body').animate({scrollTop : 0},500);
    });

});
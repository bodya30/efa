"use strict";
$(document).ready(function() {
    $('.js-img-popups-parent').magnificPopup({
        delegate: 'a',
        type: 'image',
        key: 'img-popup',
        removalDelay: 500,
        mainClass: 'mfp-with-zoom',
        zoom: {
            enabled: true,
            duration: 300,
            easing: 'ease-in-out',
            opener: function (openerElement) {
                return openerElement.is('img') ? openerElement : openerElement.find('img');
            }
        }
    });
});
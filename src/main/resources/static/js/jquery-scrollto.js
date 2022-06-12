
(function($) {
    /**
     * Copyright 2014, Min Utvikler
     * http://minutvikler.no/
     *
     * Licensed under the MIT license.
     *
     * @author Kristoffer A. Iversen
     * @description A small plugin that animate scrolling to
     *              the id referenced in the href-parameter.
     */
    $.fn.scrollTo = function(speed, offset, easing, callback) {
        if (speed === undefined || speed === null) {
            speed = 'slow';
        }
        if (offset === undefined || offset === null) {
            offset = 0;
        }
        if (easing === undefined || easing === null) {
            easing = 'swing';
        }
        $('html, body').animate({
            scrollTop: $(this.attr('href')).position().top - offset
        }, speed, easing, callback);
        return true;
    }
})(jQuery);


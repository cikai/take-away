define([ "ordering" ], function(ordering) {

    'use strict';

    function init() {

        var deferred = new $.Deferred();

        ordering.init();

        initListener();

        deferred.resolve();

        return $.when(deferred);
    }

    function initListener() {
        $("#shop").off("click").on("click", shopBtnClickHandler);
        $("#eleme").off("click").on("click", elemeBtnClickHandler);
    }

    function shopBtnClickHandler (e) {
        e.preventDefault();
        window.location = "https://www.ele.me/shop/385702";
    }

    function elemeBtnClickHandler (e) {
        e.preventDefault();
        window.location = "https://www.ele.me";
    }

    return({
        "init": init
    });
});

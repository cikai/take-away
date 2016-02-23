require.config({
    paths: {
        top: 'top'
    }
});

require([ "top" ], function(top) {
    $(function() {
        top.init();
    });
});
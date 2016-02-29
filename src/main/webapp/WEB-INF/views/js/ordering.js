define([], function() {

    'use strict';

    function init() {

        initDataTable();

        initSubmitBtn();

    }

    function initDataTable() {
        $.ajax({
            url: 'list',
            dataType: 'json',
            success: function(data) {
                console.log(data.list);
                createTable(data.list);
            },
            error: function(data) {
                alert("服务器异常！");
            }
        });
    }

    function createTable(list) {
        $('#orderForm').DataTable({
            data: list[1],
            columns: [ {
                title: "姓名"
            }, {
                title: "美食名称"
            }, {
                title: "数量"
            }
            /*
            , {
                title: "下单时间"
            }
            */
            , {
                title: "付款方式"
            } ]
        });
    }

    function initSubmitBtn() {
        $("#submit").off("click").on("click", submitBtnClickHandler);
    }

    function submitBtnClickHandler(e) {
        e.preventDefault();
        var form = $("#orderingForm").serialize();
        $.ajax({
            type: 'get',
            url: 'add',
            data: form,
            cache: false,
            dataType: 'json',
            success: function(data) {
                console.log("success");
            }
        });
        initDataTable();
    }

    return {
        "init": init
    };
});

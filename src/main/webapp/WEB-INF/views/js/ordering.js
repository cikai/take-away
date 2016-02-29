define([], function() {

    'use strict';

    function init() {
        var dataSet = [ [ "慈凯", "经典烤肉饭", "1", "2016/02/22 09:23:15", "微信" ], [ "尹荐", "经典烤肉饭", "1", "2016/02/22 08:17:34", "微信" ], [ "邵勇", "经典烤肉饭", "1", "2016/02/22 09:01:37", "微信" ], [ "王长远", "经典烤肉饭", "1", "2016/02/22 08:45:46", "支付宝" ], [ "王磊", "经典烤肉饭", "1", "2016/02/22 09:15:39", "支付宝" ], [ "尚小彬", "经典烤肉饭", "1", "2016/02/22 09:20:22", "支付宝" ] ];

        initDataTable();

        initSubmitBtn();

    }

    function initDataTable() {
        $.ajax({
            url: 'list',
            dataType: 'json',
            success: function(data) {
                console.log(data.list);
                //createTable(data.list);
            },
            error: function(data) {
                alert("error");
            }
        });
    }

    function createTable(list) {
        $('#example').DataTable({
            data: list,
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

define([], function() {

	'use strict';

	function init() {

		initDataTable();

		initSubmitBtn();

	}

	function initDataTable() {
		var dataList = new Array();
		var tableList = [];
		$.ajax({
			url : 'list',
			dataType : 'json',
			success : function(data) {
				for (var i = 0; i < data.list.length; i++) {
					dataList.push(data.list[i].name);
					dataList.push(getFood(data.list[i].food));
					dataList.push(data.list[i].count);
					dataList.push(getTime(data.list[i].time));
					dataList.push(getPayment(data.list[i].payment));
				}
				for (var i = 0; i < dataList.length; i += 5) {
					tableList.push(dataList.slice(i, i + 5));
				}
				createTable(tableList);
			},
			error : function(data) {
				alert("服务器异常！");
			}
		});
	}

	function createTable(tableList) {
		$('#orderForm').DataTable({
			data : tableList,
			columns : [ {
				title : "姓名",
				name : "name"
			}, {
				title : "美食名称",
				name : "food"
			}, {
				title : "数量",
				name : "count"
			}, {
				title : "下单时间",
				name : "time"
			}, {
				title : "付款方式",
				name : "payment"
			} ]
		});
	}

	function initSubmitBtn() {
		$("#submit").off("click").on("click", submitBtnClickHandler);
	}

	function submitBtnClickHandler(e) {
		e.preventDefault();
		if(!$("#name").val()) {
			alert("请输入姓名");
			return;
		}
		var form = $("#orderingForm").serialize();
		$.ajax({
			type : 'get',
			url : 'add',
			data : form,
			cache : false,
			dataType : 'json'
		});
		location.reload();
	}

	function getFood(food) {
		if (food = "0") {
			return "经典烤肉饭";
		}
		return;
	}

	function getTime(time) {
		if (!time) {
            return time;
        }
        var datetime = new Date(parseInt(time));
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
        var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	}

	function getPayment(payment) {
		if (payment == "0") {
			return "微信支付";
		}
		if (payment == "1") {
			return "支付宝";
		}
		if (payment == "2") {
			return "现金支付";
		}
		return;
	}

	return {
		"init" : init
	};
});

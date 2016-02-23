<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="bookmark" type="image/x-icon" />
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="icon" type="image/x-icon" />
<link href="images/favicon.ico" mce_href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel='stylesheet' type='text/css' href='css/libs/bootstrap.css'>
<link rel='stylesheet' type='text/css' href='css/libs/jquery.dataTables.css'>
<link rel='stylesheet' type='text/css' href='css/libs/dataTables.bootstrap.css'>

<link rel="stylesheet" type="text/css" href="css/top.css">
<script src="js/libs/jquery-2.1.4.js"></script>
<script src="js/libs/bootstrap.js"></script>
<script src="js/libs/jquery.dataTables.js"></script>
<script src="js/libs/dataTables.bootstrap.js"></script>
<script data-main="js/main" src="js/libs/require.js"></script>

<!--[if lt IE 9]>
    <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<title>激动组订餐系统</title>
</head>

<body>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">

      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
          data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Menu</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:void(0)"><b>激动组订餐系统</b></a> <a class="navbar-brand">经典烤肉饭</a>
      </div>

      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <form class="navbar-form navbar-right">
          <a>友情链接：</a>
          <button class="btn btn-default" id="shop">美好时代</button>
          <button class="btn btn-default" id="eleme">饿了么</button>
        </form>
      </div>

    </div>
  </nav>

  <div id="page">
    <form class="form-inline" id="orderingForm">
      <div class="form-group">
        <label for="name">姓名：</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
      </div>
      <div class="form-group">
        <label for="food">美食：</label>
        <select name="food" id="food" class="form-control">
          <option value="0">经典烤肉饭</option>
        </select>
      </div>
      <div class="form-group">
        <label for="count">数量：</label>
        <input type="text" name="count" class="form-control" id="count" value="1">
      </div>
      <div class="form-group">
        <label for="payment">支付方式：</label>
        <select name="payment" id="payment" class="form-control">
          <option value="0">微信支付</option>
          <option value="1">支付宝</option>
          <option value="2">现金支付</option>
        </select>
      </div>
      <button class="btn btn-info" id="submit">订 餐</button>
    </form>
  </div>

  <table id="example" class="display" width="100%"></table>

</body>
</html>

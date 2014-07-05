$(document).ready(function() {
	$('#reset_submit').click(function() {
		$('#username').val('登录名');
		$('#password').val('');
	});
	$('#username').focus(function() {
		if ($(this).val() == '登录名')
			$(this).val('');
	});
	$('#username').blur(function() {
		if ($(this).val() == '')
			$(this).val('登录名');
	});
	$('#login_submit').click(function() {
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
			type : 'post',
			url : '/HomeWorkTest/admin/login.do',
			dataType : 'json',
			data : {
				username : username,
				password : password
			},
			success : function(map) {
				if (map.result == 'failed') {
					alert('用户名密码错误,请重新登录!');
				} else {
					var username = map.admin;
					location.href ='result.jsp?username=' + username;
				}
			},
			failure : function(data) {
				alert('网络连接异常，请重新登录!');
			}
		});
	});
});

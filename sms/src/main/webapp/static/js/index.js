$(function() {
	$('form').bootstrapValidator({
		/*
		 * message : 'This value is not valid', feedbackIcons : { valid :
		 * 'glyphicon glyphicon-ok', invalid : 'glyphicon glyphicon-remove',
		 * validating : 'glyphicon glyphicon-refresh' },
		 */
		fields : {
			sno : {
				message : '账号验证失败',
				validators : {
					notEmpty : {
						message : '账号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{5,10}$/,
						message : '账号必须为5到10位的数字'
					}
				}
			},
			tno : {
				message : '账号验证失败',
				validators : {
					notEmpty : {
						message : '账号不能为空'
					},
					/*
					 * stringLength : { min : 4, max : 18, regexp:/^[0-9]*$/,
					 * message : '用户名必须为4到10位之间的数字' },
					 */
					regexp : {
						regexp : /^[0-9]{5,10}$/,
						message : '账号必须为5到10位的数字'
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					}
				}
			}
		}
	});
});
$(function() {
	if (jQuery.cookie('username') && jQuery.cookie('password'))
		$('#rememberMe').prop('checked', true);
	$("#username").val(jQuery.cookie('username'));
	$("#password").val(jQuery.cookie('password'));
	$("#submitBtn").click(function() {
		// var isRember = $("#rememberMe").attr("checked");
		var isRember = $('#rememberMe').is(':checked');
		if (isRember) { // 如果记住
			jQuery.cookie('username', $("#username").val());
			jQuery.cookie('password', $("#password").val());
		} else {
			jQuery.cookie("username", '', {
				expires : -1
			});
			jQuery.cookie("password", '', {
				expires : -1
			});
		}
	});
});
$(function() {
	if (jQuery.cookie('uname') && jQuery.cookie('psword'))
		$('#rmbMe').prop('checked', true);
	$("#uname").val(jQuery.cookie('uname'));
	$("#psword").val(jQuery.cookie('psword'));
	$("#sBtn").click(function() {
		// var isRember = $("#rememberMe").attr("checked");
		var isRember = $('#rmbMe').is(':checked');
		if (isRember) { // 如果记住
			jQuery.cookie('uname', $("#uname").val());
			jQuery.cookie('psword', $("#psword").val());
		} else {
			jQuery.cookie("uname", '', {
				expires : -1
			});
			jQuery.cookie("psword", '', {
				expires : -1
			});
		}
		/* $("form").submit(); */
	});
});
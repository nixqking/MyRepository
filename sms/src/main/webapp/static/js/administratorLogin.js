$(function() {
	$('form').bootstrapValidator({
		/*
		 * message : 'This value is not valid', feedbackIcons : { valid :
		 * 'glyphicon glyphicon-ok', invalid : 'glyphicon glyphicon-remove',
		 * validating : 'glyphicon glyphicon-refresh' },
		 */
		fields : {
			account : {
				message : '账号验证失败',
				validators : {
					notEmpty : {
						message : '账号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : '账号必须为5位的数字'
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
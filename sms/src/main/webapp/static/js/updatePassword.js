$(function() {
	$('form').bootstrapValidator({
		fields : {
			oldPassword : {
				message : '原密码验证失败',
				validators : {
					notEmpty : {
						message : '原密码不能为空'
					},
					regexp : {
						regexp : /^[0-9A-Za-z]+$/,
						message : '密码只能由字母、数字组成'
					}
				}
			},
			newPassword : {
				message : '新密码验证失败',
				validators : {
					notEmpty : {
						message : '新密码不能为空'
					},
					identical : {// 相同
						field : 'newPassword', // 需要进行比较的input name值
						message : '两次输入的密码不一致'
					},
					different : {
						field : 'oldPassword',
						message : '不能与原密码相同'
					},
					regexp : {
						regexp : /^[0-9A-Za-z]+$/,
						message : '密码只能由字母、数字组成'
					}
				}
			},
			repeatPassword : {
				validators : {
					notEmpty : {
						message : '请再次输入新密码'
					},

					identical : {// 相同
						field : 'newPassword',
						message : '两次输入的密码不一致'
					},
					regexp : {
						regexp : /^[0-9A-Za-z]+$/,
						message : '密码只能由字母、数字组成'
					}
				}
			}
		}
	});
});
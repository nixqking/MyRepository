$(function() {
	$('form').bootstrapValidator({
		fields : {
			tno : {
				message : '教职工号验证失败',
				validators : {
					notEmpty : {
						message : '教职工号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : '教职工号由5位数字组成'
					}
				}
			},
			tname : {
				message : '教师姓名验证失败',
				validators : {
					notEmpty : {
						message : '教师姓名不能为空'
					}
				}
			},
			sex : {
				message : '教师性别验证失败',
				validators : {
					notEmpty : {
						message : '教师性别不能为空'
					},
					regexp : {
						regexp : /female|male/g,
						message : '教师性别只能是female或者male'
					}
				}
			}
		}
	});
});
$(function() {
	$('form').bootstrapValidator({
		fields : {
			cno : {
				message : '课程编号验证失败',
				validators : {
					notEmpty : {
						message : '课程编号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{4}$/,
						message : '课程编号由4位数字组成'
					}
				}
			},
			cname : {
				message : '课程名称验证失败',
				validators : {
					notEmpty : {
						message : '课程名称不能为空'
					}
				}
			},
			tno : {
				message : '教师工号验证失败',
				validators : {
					notEmpty : {
						message : '教师工号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : '教师工号由5位数字组成'
					}
				}
			}
		}
	});
});
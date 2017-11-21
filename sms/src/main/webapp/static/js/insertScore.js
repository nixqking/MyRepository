$(function() {
	$('form').bootstrapValidator({
		fields : {
			sno : {
				message : '学生学号验证失败',
				validators : {
					notEmpty : {
						message : '学生学号不能为空'
					},
					regexp : {
						regexp : /^[0-9]{10}$/,
						message : '学生学号由10位数字组成'
					}
				}
			},
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
			score : {
				message : '课程成绩验证失败',
				validators : {
					notEmpty : {
						message : '课程成绩不能为空'
					},
					regexp : {
						regexp : /^([1]?\d{1,2})$/,
						message : '课程成绩由0至100的数字组成'
					}
				}
			}
		}
	});
});
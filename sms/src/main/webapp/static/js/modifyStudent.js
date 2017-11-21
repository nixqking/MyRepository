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
			sname : {
				message : '学生姓名验证失败',
				validators : {
					notEmpty : {
						message : '学生姓名不能为空'
					}
				}
			},
			sex : {
				message : '学生性别验证失败',
				validators : {
					notEmpty : {
						message : '学生性别不能为空'
					},
					regexp : {
						regexp : /female|male/g,
						message : '学生性别只能是female或者male'
					}
				}
			},
			sdept : {
				message : '所属学院验证失败',
				validators : {
					notEmpty : {
						message : '所属学院不能为空'
					}
				}
			},
			classe : {
				message : '所属班级验证失败',
				validators : {
					notEmpty : {
						message : '所属班级不能为空'
					},
					regexp : {
						regexp : /^[0-9]{4}$/,
						message : '所属班级由4位数字组成'
					}
				}
			}
		}
	});
});
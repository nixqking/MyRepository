package com.neil.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neil.pojo.Sc;
import com.neil.pojo.Teacher;
import com.neil.serviceImpl.QueryStudentScoreServiceImpl;

@Controller
public class QueryStudentScoreController {
	@Autowired
	QueryStudentScoreServiceImpl qsssi;
	String tno;

	@RequestMapping("/queryStudentScore")
	public String queryStudentScore(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(defaultValue = "1") Integer pageNum) {
		ArrayList<Sc> al = null;
		if (req.getSession().getAttribute("teacher") != null
				&& ((Teacher) req.getSession().getAttribute("teacher")).getTno() != null) {
			tno = ((Teacher) req.getSession().getAttribute("teacher")).getTno();
			try {
				al = (ArrayList<Sc>) qsssi.queryStudentScore(req, tno, pageNum);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (req.getParameter("request") != null && req.getParameter("request").equals("all") && al != null) {
				// 创建HSSFWorkbook对象
				HSSFWorkbook wb = new HSSFWorkbook();
				// 创建HSSFSheet对象
				HSSFSheet sheet = wb.createSheet("sheet0");
				// 创建HSSFRow对象
				HSSFRow row = sheet.createRow(0);
				// 创建HSSFCell对象
				HSSFCell cell = row.createCell(0);
				// 设置单元格的值
				cell.setCellValue("课程编号");
				cell = row.createCell(1);
				cell.setCellValue("课程名称");
				cell = row.createCell(2);
				cell.setCellValue("课程成绩");
				cell = row.createCell(3);
				cell.setCellValue("学生学号");
				cell = row.createCell(4);
				cell.setCellValue("学生姓名");
				cell = row.createCell(5);
				cell.setCellValue("学生性别");
				cell = row.createCell(6);
				cell.setCellValue("所属学院");
				cell = row.createCell(7);
				cell.setCellValue("学生班级");
				for (int i = 0; i < al.size(); i++) {
					row = sheet.createRow(i + 1);
					for (int j = 0; j < 8; j++) {
						cell = row.createCell(j);
						switch (j) {
						case 0:
							cell.setCellValue(al.get(i).getCourse().getCno());
							break;
						case 1:
							cell.setCellValue(al.get(i).getCourse().getCname());
							break;
						case 2:
							cell.setCellValue(al.get(i).getScore());
							break;
						case 3:
							cell.setCellValue(al.get(i).getSno());
							break;
						case 4:
							cell.setCellValue(al.get(i).getStudent().getSname());
							break;
						case 5:
							cell.setCellValue(al.get(i).getStudent().getSex());
							break;
						case 6:
							cell.setCellValue(al.get(i).getStudent().getSdept());
							break;
						case 7:
							cell.setCellValue(al.get(i).getStudent().getClasse());
							break;
						default:
							break;
						}
					}
				}
				// 输出Excel文件
				OutputStream output;
				try {
					output = res.getOutputStream();
					res.reset();
					res.setHeader("Content-disposition", "attachment; filename=score.xls");
					res.setContentType("application/msexcel");
					wb.write(output);
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			req.getSession().setAttribute("studentScore", al);
			return "queryStudentScore";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "logout");
			return "index";
		}
	}
}

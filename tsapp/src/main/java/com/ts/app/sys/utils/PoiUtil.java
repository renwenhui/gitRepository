package com.ts.app.sys.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.record.formula.functions.T;

public class PoiUtil {
	
	/**
	 * 导出数据到excel表格（从数据中获取的数据不经处理）
	 * 参数说明：
	 * List<T> results  数据记录的集合 
	 * LinkedHashMap<String,Integer> titles  excel表格的表头和对应的宽度，key pojo属性  value 表头宽度    (LinkedHashMap 能够保证输入与输出的顺序一致)
	 * int[] widths 每一列对应的宽度
	 * String excelName excel表名称
	 * @param response
	 * @param list
	 */
    public static void exportOrgData(HttpServletRequest request,HttpServletResponse response,List<T> results,LinkedHashMap<String,String> titles,int[] widths,String excelName){
    	try {
			//设置表头格式
			WritableCellFormat wcfFCHead__ = ExportUtil.getHeaderCellStyle();
			//设置表体格式
			WritableCellFormat wcfFC__ = ExportUtil.getBodyCellStyle();
			
			double DateLen = results.size(); 
			double SheetMaxLen = 60000;// 减去每页的标题
			double pageNum = Math.ceil(DateLen/SheetMaxLen); //sheet总页数
			if(pageNum == 0d){
				pageNum = 1d;
			}
		    WritableWorkbook wwb = null;//初始化生成文件工具
		    WritableSheet ws[] = new WritableSheet[(int) pageNum];
			OutputStream os = null;//初始化文件流
			String sheetName = excelName;	//excel名称		
			response.reset();
			response.setContentType("application/x-msdownload");
			request.setCharacterEncoding("GBK");
			String fileName = "";
			os = response.getOutputStream();
			wwb = Workbook.createWorkbook(os);	//创建EXCEL
			
			int count = 0; // 记录序号
			int num = 0;
			for(int i=0;i<ws.length;i++){
				ws[i] = wwb.createSheet(sheetName + "_" + (i + 1), i);//创建SHEET页
				ws[i].addCell(new Label(0,0,"序号",wcfFCHead__));
				ws[i].setColumnView(0,10);
				num = 1;
				for(Entry<String, String> entry :titles.entrySet()){
					ws[i].addCell(new Label(num,0,entry.getValue(),wcfFCHead__));
					if(num<widths.length){
						ws[i].setColumnView(num,widths[num]);
					}
					num++;
				}
				num = 1; // 记录当前sheet页记录条数
				for(int j = 0; j < results.size();j++){
					count = 1;
					ws[i].addCell(new Label(0,num,String.valueOf(j+1),wcfFC__));
					Map<String, Object> result = convertBean2Map(results.get(j));
					for(String key:titles.keySet()){
						Object obj = result.get(key);
						if(obj instanceof Date){
						   obj = DateTimeUtil.getFormatTime((Date)obj, "yyyy-MM-dd HH:mm:ss");
						}
						ws[i].addCell(new Label(count++,num,obj.toString()));	
					}
					num ++;
					if(num == 60001){
						break;
					}
				}
			}			
			fileName = new String((sheetName+DateTimeUtil.getFormatTime(new Date(),"_yyyyMMddHHmmss")).getBytes("GBK"), "ISO8859_1");
			response.addHeader("Content-Disposition","attachment;filename="+fileName+".xls");
			wwb.write();
			wwb.close();
			os.flush();
			os.close();
			os = null;
			response.flushBuffer(); 		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 导出数据到excel表格（经过转换后的数据）
	 * 参数说明：
	 * LinkedHashMap<String,Integer> titles   标题和对应列宽的集合 （选择LinkedHashMap是为了保证数据的录入顺序和输出顺序一致）
	 * List<List<Object>> dataList  填充数据的集合
	 * 
     */
    public static void exportConvert(HttpServletRequest request,HttpServletResponse response,LinkedHashMap<String,Integer> titles,List<List<Object>> dataList,String excelName){
    	try {
			//设置表头格式
			WritableCellFormat wcfFCHead__ = ExportUtil.getHeaderCellStyle();
			//设置表体格式
			WritableCellFormat wcfFC__ = ExportUtil.getBodyCellStyle();
			
			double DateLen = dataList.size(); 
			double SheetMaxLen = 60000;// 减去每页的标题
			double pageNum = Math.ceil(DateLen/SheetMaxLen); //sheet总页数
			if(pageNum == 0d){
				pageNum = 1d;
			}
		    WritableWorkbook wwb = null;//初始化生成文件工具
		    WritableSheet ws[] = new WritableSheet[(int) pageNum];
			OutputStream os = null;//初始化文件流
			String sheetName = excelName;	//excel名称		
			response.reset();
			response.setContentType("application/x-msdownload");
			request.setCharacterEncoding("GBK");
			String fileName = "";
			os = response.getOutputStream();
			wwb = Workbook.createWorkbook(os);	//创建EXCEL
			
			int num = 0;
			for(int i=0;i<ws.length;i++){
				ws[i] = wwb.createSheet(sheetName + "_" + (i + 1), i);//创建SHEET页
				num = 0;
				for(Entry<String, Integer> entry :titles.entrySet()){
					ws[i].addCell(new Label(num,0,entry.getKey(),wcfFCHead__));
				    ws[i].setColumnView(num,entry.getValue());
					num++;
				}
				if(dataList != null){
					num = 1; // 记录当前sheet页记录条数
				    for(List<Object> o:dataList){
				    	for(int j = 0; j < o.size();j++){
				    	  Object obj=o.get(j);
				    	  if(obj == null){
				    		  ws[i].addCell(new Label(j,num,"")); continue;	
				    	  }else if(obj instanceof Date){
							   obj = DateTimeUtil.getFormatTime((Date)obj, "yyyy-MM-dd HH:mm:ss");
						  }
				    	  ws[i].addCell(new Label(j,num,obj.toString()));
				    	}
				    	num ++;
						if(num == 60001){
							break;
						}
				    }
				}
			}			
			fileName = new String((sheetName+DateTimeUtil.getFormatTime(new Date(),"yyyyMMddHHmmss")).getBytes("GBK"), "ISO8859_1");
			response.addHeader("Content-Disposition","attachment;filename="+fileName+".xls");
			wwb.write();
			wwb.close();
			os.flush();
			os.close();
			os = null;
			response.flushBuffer(); 		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 将一个Javabean转化成map
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static Map<String, Object> convertBean2Map(Object bean)
            throws Exception
        {
            Class<? extends Object> type = bean.getClass();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++)
            {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!"class".equals(propertyName))
                {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null)
                    {
                        returnMap.put(propertyName, result);
                    }
                    else
                    {
                        returnMap.put(propertyName, null);
                    }
                }
            }
            return returnMap;
        }
}

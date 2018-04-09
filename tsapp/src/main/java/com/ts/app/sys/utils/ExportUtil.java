package com.ts.app.sys.utils;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

public class ExportUtil {
	/**
	 * 
	 * @Description：设置表体 <p>
	 * 创建人：
	 * @return
	 * @throws WriteException
	 * WritableCellFormat
	 */
	public static WritableCellFormat getBodyCellStyle() throws WriteException {
		WritableFont wfont__ = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD);// 设置字体
		
		WritableCellFormat wcfFC__ = new WritableCellFormat(wfont__);
		wcfFC__.setBorder(Border.ALL, BorderLineStyle.THIN);// 设置边框
		// 设置居中
		wcfFC__.setAlignment(Alignment.CENTRE);
		wcfFC__.setVerticalAlignment(VerticalAlignment.CENTRE);
		return wcfFC__;
	}
	
	/**
	 * 
	 * @Description：设置表头 <p>
	 * 创建人：
	 * @return
	 * @throws WriteException
	 * WritableCellFormat
	 */
	public static WritableCellFormat getHeaderCellStyle() throws WriteException {
		WritableFont wfont__ = new WritableFont(WritableFont.ARIAL, 12,
				WritableFont.BOLD);// 设置字体
		WritableCellFormat wcfFC__ = new WritableCellFormat(wfont__);
		wcfFC__.setBorder(Border.ALL, BorderLineStyle.THIN);// 设置边框
		// 设置居中
		wcfFC__.setAlignment(Alignment.CENTRE);
		wcfFC__.setVerticalAlignment(VerticalAlignment.CENTRE);
		return wcfFC__;
	}
}

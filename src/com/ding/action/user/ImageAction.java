package com.ding.action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.ding.action.BaseAction;
import com.ding.util.ImageUtil;

public class ImageAction extends BaseAction{
	/**input*/ 
	
	/**output*/
	private InputStream imageStream;
	
	public String execute()throws Exception{
		/**generate a image dynamically*/
		Map<String ,BufferedImage> map = ImageUtil.createImage();
		/**obtain the symbolic of the image*/
		String key = map.keySet().iterator().next();
		/**put'key'in'session', for future comparing*/
		session.put("code", key);
		/**obtain the object of the image*/
		BufferedImage image = map.get(key);
		/**convert the info of the image to imageStream using InputStream type*/
		imageStream = ImageUtil.change(image);
		/**Result call result in a stream type*/
		/**output imageStream to client in byte stream way*/
		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
}

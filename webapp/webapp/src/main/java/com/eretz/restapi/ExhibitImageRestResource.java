package com.eretz.restapi;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eretz.model.Exhibit;
import com.eretz.services.ExhibitService;
import com.eretz.services.FilePathService;

@Controller
@RequestMapping("/exhibitImg")
public class ExhibitImageRestResource {
	@Autowired
	private ExhibitService exhibitService;
	
	@Autowired
	private FilePathService filePathService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "image/jpg")
	public @ResponseBody
	byte[] getExhibitImage(@RequestParam("imageId") Long imageId)
			throws IOException {
		InputStream is = filePathService.getStream(imageId);

		BufferedImage img = ImageIO.read(is);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", bao);
		return bao.toByteArray();
	}

}

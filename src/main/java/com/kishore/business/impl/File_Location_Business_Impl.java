package com.kishore.business.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kishore.business.interfaces.File_Location_Business_Interfaces;
import com.viki.dao.interfaces.File_Location_DAO_Interfaces;
import com.viki.service.entities.File_Location;

@Service
public class File_Location_Business_Impl implements File_Location_Business_Interfaces
{
	@Autowired
	File_Location_DAO_Interfaces file_Location_DAO_Interfaces;
	
	private String saveDirectory = "/Users/kishorekumar/Desktop/MyFile/";
	
	@Override
	public String save_File(CommonsMultipartFile[] commonsMultipartFiles)
	{
		try 
		{
			if (commonsMultipartFiles != null && commonsMultipartFiles.length > 0)
			{
				for (CommonsMultipartFile aFile : commonsMultipartFiles)
				{	
					System.out.println("Saving file: " + aFile.getOriginalFilename().replace(" ", "_"));
					
					if (!aFile.getOriginalFilename().equals("")) 
					{
						aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename().replace(" ", "_")));

						File_Location file_Location = new File_Location();
						file_Location.setLocation(saveDirectory+""+aFile.getOriginalFilename().replace(" ", "_"));
						System.out.println(saveDirectory+""+aFile.getOriginalFilename().replace(" ", "_"));
						file_Location_DAO_Interfaces.save_File(file_Location);
					}
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		return "Success";
	}
	
}
package com.viki.business.interfaces;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface File_Location_Business_Interfaces 
{
	String save_File(CommonsMultipartFile[] commonsMultipartFiles);
}

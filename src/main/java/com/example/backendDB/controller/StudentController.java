package com.example.backendDB.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backendDB.pojo.Student;
import com.example.backendDB.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("student")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity saveStudent(@RequestBody Student student)
	{
		LOGGER.trace("Control is in save student method ");
		LOGGER.debug("Studet details are {}" + student);
		ResponseEntity re=new ResponseEntity<>(HttpStatus.CREATED);
		studentservice.saveStudent(student);
		LOGGER.info("Student successfully created.");
		return re;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity updateStudent(@RequestBody Student student)
	{
		ResponseEntity re=new ResponseEntity<>(HttpStatus.OK);
		studentservice.updateStudent(student);
		return re;
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@RequestBody Student student)
	{
		ResponseEntity re=new ResponseEntity<>(HttpStatus.OK);
		studentservice.deleteStudent(student);
		return re;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentByid(@PathVariable("id")Integer id)
	{

	Student std=studentservice.getStudentByid(id);
     ResponseEntity<Student> re=new ResponseEntity<Student>(std,HttpStatus.OK);
     return re;
	}
	
	@RequestMapping(value=("/all/{pageno}/{pagesize}"),method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudents(@PathVariable("pageno") Integer pageno,@PathVariable("pagesize") Integer pagesize)
	{
		
		List<Student> stdlist=studentservice.getStudents(pageno,pagesize);
		ResponseEntity re=new ResponseEntity(stdlist,HttpStatus.OK);
		return re;
	}


	  @RequestMapping(value="/getStd")
	  public List<Student> getStd(String name)
	   {
		   return studentservice.getStd(name);
	   }
	 
	  //using findby name we get total record
	  
	    @RequestMapping(value="/findbyName")
		public  List<Student> findByName(String name)
		{
			return studentservice.findByName(name);
		}
	  
	 
	    @RequestMapping(value="/checkstudent/{name}")
	    public ResponseEntity<Boolean> checkStudent(@PathVariable String name)
	    {
	    	Boolean result=studentservice.checkStudent(name);
			return new ResponseEntity<Boolean>(result,HttpStatus.OK);

	    }
	
	  
	 //-----------------------------------------------------------------------------
	  
	     @RequestMapping(value="/findbyQual")
		public  List<Student> findByQual(String qual)
		{
			return studentservice.findByQual(qual);
		}
	     
	     //file save to database
	     
	     @RequestMapping(value="/fileupload",method=RequestMethod.POST)
	     public void fileUpload(MultipartFile studentfile) throws IOException
	     {
	    	 System.out.println(studentfile.getOriginalFilename());
	    	 String filename=studentfile.getOriginalFilename();
	    	 File file=new File("D:\\f19\\"+filename);
	    	 studentfile.transferTo(file);
	    	 
	    	 FileReader fr=new FileReader(file);
	    	 BufferedReader br=new BufferedReader(fr);
	    	 
	    	 String line=br.readLine();
	    	 while(line!=null)
	    	 {
	    		 String[] values=line.split(",");
	    		 if(values.length==3) {
	    			 
	    			 Student student=new Student();
	    			 student.setName(values[0]);
	    			 student.setPhone(Integer.parseInt(values[1]));
	    			 student.setQual(values[2]);
	    			 studentservice.saveStudent(student);
	    			 line=br.readLine();
	    		 }
	    	 }
	    	 fr.close();
	    	 br.close();
	    	 
	     }
	     
	     //download file from database
	     
	     @RequestMapping(value="/download", method=RequestMethod.GET)
	     public ResponseEntity<ByteArrayResource> downloadStudentData() throws IOException
	     {
	    	 List<Student> studentlist=studentservice.getStudents();
	    	 FileWriter fr=new FileWriter("D:\\f19\\allstudents.txt",true);
	    	 BufferedWriter bw=new BufferedWriter(fr);
	    	 for (Student student : studentlist) {
				
	    		 bw.newLine();
	    		 bw.write(student.getName()+","+student.getPhone()+","+student.getQual());
			}
	    	 
	    	 bw.close();
	    	 fr.close();
	    	 
	    	 Path path=Paths.get("D:\\f19\\allstudents.txt");
	    	 byte [] bytes=Files.readAllBytes(path);
	    	 ByteArrayResource bar=new ByteArrayResource(bytes);
	    	 return ResponseEntity.ok()
	    			 .header("Content-Disposition", "attachment;filename=abc.txt").body(bar);
	    	 

	    	 
	     }
	     
	     
	     
	     //get file from database 
	    /* @RequestMapping(value="/download")
	     public void downloadStudentData() throws IOException
	     {
	    	 List<Student> studentlist=studentservice.getStudents();
	    	 FileWriter fr=new FileWriter("D:\\f19\\allstudents.txt",true);
	    	 BufferedWriter bw=new BufferedWriter(fr);
	    	 for (Student student : studentlist) {
				
	    		 bw.newLine();
	    		 bw.write(student.getName()+","+student.getPhone()+","+student.getQual());
			}
	    	 
	    	 bw.close();
	    	 fr.close();
	    	 
	     }*/
	     
	     //file downloading
	    /* @RequestMapping(value="/downloadfile")
	 	public void  fileDownload(HttpServletResponse resp) throws IOException
	 	{
	 		File file=new File("D:\\f19\\allstudents.txt");
	 		resp.setHeader("Content-Disposition", "attachment;filename="+file);

	 		FileInputStream fis=new FileInputStream(file);
	 		PrintWriter pw=resp.getWriter();
	 		int bytes=fis.read();
	 		
	 		while(bytes!=-1)
	 		{
	 			pw.write(bytes);
	 			bytes=fis.read();
	 		}
	 		
	 		fis.close();
	 	}*/
	     
	     //--------------------------------------------------------
	     
	     //download excel from database
	     
	     @RequestMapping(value="/download/excel", method=RequestMethod.GET)
	     public ResponseEntity<ByteArrayResource> downloadStudentDataExcel() throws IOException
	     {
	    	List<Student> studentlist=studentservice.getStudents();
	    	 
	    	    XSSFWorkbook workbook = new  XSSFWorkbook();
			    XSSFSheet sheet = workbook.createSheet();
			    XSSFRow rowhead = sheet.createRow(0);
			    rowhead.createCell(0).setCellValue("id");
			    rowhead.createCell(1).setCellValue("name");
			    rowhead.createCell(2).setCellValue("phone");
			    rowhead.createCell(3).setCellValue("qual");

			    
			    int i = 1;

                   for (Student st : studentlist) {
	
			        XSSFRow row = sheet.createRow(i);
			        row.createCell(0).setCellValue(st.getId());
			        row.createCell(1).setCellValue(st.getName());
			        row.createCell(2).setCellValue(st.getQual());
			        row.createCell(3).setCellValue(st.getPhone());

			        i++;
			    }
			    
			    FileOutputStream file = new FileOutputStream("D:\\f19\\excel\\sample.xlsx");
			    workbook.write(file);
			    file.close();
	    	 
	    	 
	    	 Path path=Paths.get("D:\\f19\\excel\\sample.xlsx");
	    	 byte [] bytes=Files.readAllBytes(path);
	    	 ByteArrayResource bar=new ByteArrayResource(bytes);
	    	 return ResponseEntity.ok()
	    			 .header("Content-Disposition", "attachment;filename=sample.xlsx").body(bar);
	    	
	     }
	     
	     //-------------------------------------------------------
	     
	     //excel sheet save to database
	     
	     
	     
	   /*  @RequestMapping(value="/fileupload/{excel}",method=RequestMethod.POST)
	     public void excelFileUpload(MultipartFile studentfile) throws IOException
	     {
	    	 try
	         {
	             FileInputStream file = new FileInputStream(new File("D:\\f19\\excel\\sample.xlsx"));
	             XSSFWorkbook workbook = new XSSFWorkbook(file);
	             XSSFSheet sheet = workbook.getSheetAt(0);
	             Iterator<Row> rowIterator = sheet.iterator();
	             while (rowIterator.hasNext())
	             {
	                 Row row = rowIterator.next();
	                 Iterator<Cell> cellIterator = row.cellIterator();
	                  
	                 while (cellIterator.hasNext())
	                 {
	                     Cell cell = cellIterator.next();
	                     Student student=new Student();
	                     
	                     switch (cell.getCellType())
	                     {
	                         case Cell.CELL_TYPE_NUMERIC:
	                             //System.out.print(cell.getNumericCellValue() + "t");
	                        	// student.setId(int) row.getCell(0).getStringCellValue());
	                        	 student.setName(row.getCell(1).getStringCellValue());
 
	                             break;
	                         case Cell.CELL_TYPE_STRING:
	                             System.out.print(cell.getStringCellValue() + "t");
	                             break;
	                     }
	                 }
	             }
	             
	             file.close();
	         }
	         catch (Exception e)
	         {
	             e.printStackTrace();
	         }
        }*/
                 
}

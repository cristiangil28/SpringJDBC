package com.cristian.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.cristian.beans.dao.AdminDao;
import com.cristian.beans.pojo.Admin;

public class Execute {
	public static void main(String[] args) {
ApplicationContext app= new ClassPathXmlApplicationContext("com/cristian/beans/beans.xml");
        
        
		AdminDao dao= (AdminDao) app.getBean("adminDao");
		Timestamp ts= new Timestamp(new Date().getTime());
//        Admin admin = new Admin();
//        admin.setCargo("gerente");
//        admin.setNombre("david");
//        admin.setFechaCreacion(ts);
        
        try {
        	//dao.save(admin);
        	
//        	List <Admin> admins=dao.findAll();
//        	
//        	for (Admin admin2 : admins) {
//				System.out.println(admin2);
//			}	
			
//        	Admin admin= dao.findId(5);
//        	System.out.println(admin);
//        	admin.setCargo("operario");
//        	admin.setNombre("kross");
//        	
//        	if (dao.update(admin)) {
//				System.out.println("actualizado correctamente: "+admin);
//			}
//        	if (dao.delete(admin.getId())) {
//				System.out.println("administrador: "+admin.getNombre()+" eliminado");
//			}
//        	System.out.println(dao.findId(1));
//        	System.out.println(dao.findId(8));
//        	System.out.println(dao.findByNombre("c").toString());
        	
        	
        	//manejo de batch update
        	
        	List<Admin> admins= new ArrayList<Admin>();
        	
        	admins.add(new Admin("camilo","director",ts));
        	admins.add(new Admin("diego","jefe de ventas",ts));
        	admins.add(new Admin("charly ","desarrolladora",ts));
        	
        	int [] values= dao.saveAll(admins);
        	
        	for (int i : values) {
				System.out.println("filas afectaadas: "+i);
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		}
        catch (DataAccessException e) {
			e.printStackTrace();
		}
        
           
        ((ClassPathXmlApplicationContext)app).close();
	}
}

package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.Validator.ImageValidator;
import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Value("upload_path")
    String upload_path;


    public void addOrder(Orders order,MultipartFile file) throws IOException {
        if(ordersRepo.findByOrder_name(order.getOrder_name())!=null){
            return;
        }
        if(file!=null){
            if(!ImageValidator.validate(file,null)){
                return;
            }
            saveFile(order,file);
        }
        ordersRepo.save(order);
    }

    public void saveOrder(Orders order){
        ordersRepo.save(order);
    }

    public void editOrder(Orders order,MultipartFile file){
        if(file!=null){
            if(!ImageValidator.validate(file,null)){
                return;
            }
        }
        ordersRepo.save(order);
    }

    public void deleteOrders(Orders order){
        ordersRepo.delete(order);
    }

    public boolean saveFile(Orders order, MultipartFile file) throws IOException {
        if(!ImageValidator.validate(file,null)){
            return false;
        }
        File up_dir = new File(upload_path);
        if(!up_dir.exists()){
            if(!up_dir.mkdir()){
                throw new IOException("Unable to create directory");
            }
        }
        String uuid = UUID.randomUUID().toString();
        String result_schema_name = uuid+"."+file.getOriginalFilename();
        order.setOrder_scheme_name(result_schema_name);
        file.transferTo(Paths.get(upload_path+result_schema_name));
        return true;
    }

    public InputStream getFile(Long id,String filename){
        InputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream(upload_path+filename));
        } catch (IOException ex) {
            return null;
        }
        return is;
    }
}


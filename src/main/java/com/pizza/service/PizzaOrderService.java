package com.pizza.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pizza.StorageProperties;
import com.pizza.exception.StorageException;
import com.pizza.exception.StorageFileNotFoundException;
import com.pizza.helper.PizzaLexicalShortHelper;



@Service
public class PizzaOrderService implements StorageService {

    private final Path rootLocation;
    
    @Autowired
    private PizzaLexicalShortHelper pizzaLexicalShortHelper;

    @Autowired
    public PizzaOrderService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        
    	Map<String, LocalDateTime> shortedMap;
    	StringBuffer readableFile = new StringBuffer("Your Orders Are Placed in Shorted/Readable Format ");
    	readableFile.append(System.getProperty("line.separator"));
    	try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
           shortedMap = pizzaLexicalShortHelper.pizzaShort(file);
           shortedMap.forEach((k,v)->
            {
            	readableFile.append(k + " Pizza Is Ordered @  : " + v );
            	readableFile.append(System.getProperty("line.separator"));
           
            });
           
            Files.write(this.rootLocation.resolve("Shorted_"+file.getOriginalFilename()), readableFile.toString().getBytes());
            //Files.copy(file.getInputStream(), this.rootLocation.resolve("Shorted_"+file.getOriginalFilename()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

      
    
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}

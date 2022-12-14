package kz.pashim.kubedockertest.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String USERS_FILE_PATH = "classpath:user/users.txt";

    public void saveUser(String name) {
        try {
            var file = ResourceUtils.getFile(USERS_FILE_PATH);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(name + "\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<String> listUsers() {
        var result = new ArrayList<String>();
        try {
            var file = ResourceUtils.getFile(USERS_FILE_PATH);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                var line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}

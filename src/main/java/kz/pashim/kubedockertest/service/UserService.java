package kz.pashim.kubedockertest.service;

import jakarta.annotation.PostConstruct;
import kz.pashim.kubedockertest.domain.UserEntity;
import kz.pashim.kubedockertest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Value("${users.file.path}")
    private String usersFilePath;

    private final UserRepository userRepository;

    @PostConstruct
    public void init() throws IOException {
        var file = new File(usersFilePath);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    public void saveUser(String name) {
        userRepository.save(UserEntity.builder().name(name).build());
        try {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(usersFilePath, true)))) {
                writer.write(name + "\n");
            } catch (Exception e) {
                log.error(e.toString());
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public List<String> listUsers() {
        var result = new ArrayList<String>();
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(usersFilePath)))) {
                var line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (Exception e) {
                log.error(e.toString());
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }
}

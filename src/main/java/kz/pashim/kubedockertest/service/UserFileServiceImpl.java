package kz.pashim.kubedockertest.service;

import jakarta.annotation.PostConstruct;
import kz.pashim.kubedockertest.dto.UserDTO;
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
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFileServiceImpl implements UserService {

    @Value("${users.file.path}")
    private String usersFilePath;

    @PostConstruct
    public void init() throws IOException {
        var file = new File(usersFilePath);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(usersFilePath, true)))) {
                writer.write(userDTO.getName() + "\n");
            } catch (Exception e) {
                log.error(e.toString());
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
        return userDTO;
    }

    @Override
    public void deleteUser(UUID id) {
        // ignored
    }

    @Override
    public List<UserDTO> getUsers() {
        var result = new ArrayList<UserDTO>();
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(usersFilePath)))) {
                var line = reader.readLine();
                while (line != null) {
                    result.add(UserDTO.builder().name(line).build());
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

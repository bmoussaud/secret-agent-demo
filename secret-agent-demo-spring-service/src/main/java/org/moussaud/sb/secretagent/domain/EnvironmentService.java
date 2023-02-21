package org.moussaud.sb.secretagent.domain;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class EnvironmentService {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.application.name}")
    private String appName;

    @Transactional(readOnly = true)
    public Stream<EnvironmentResponse> getAll() {
        List<EnvironmentResponse> data = new ArrayList<EnvironmentResponse>();

        try (Connection connection = dataSource.getConnection();) {
            data.add(new EnvironmentResponse("Application Name", appName));
            final DatabaseMetaData metaData = connection.getMetaData();
            data.add(new EnvironmentResponse("URL", metaData.getURL()));
            data.add(new EnvironmentResponse("User", metaData.getUserName()));
            data.add(new EnvironmentResponse("Driver", metaData.getDriverName()));
            data.add(new EnvironmentResponse("DriverVersion", metaData.getDriverVersion()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data.stream();
    }
}

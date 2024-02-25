package org.example.config;

import org.example.elements.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    Connection conn = Database.getInstance().getConnection();
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalWork = new ArrayList<>();
        String filePath = "src/SQL/3_find_max_salary_worker.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            ResultSet resultSet = st.executeQuery(content);
            while (resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(resultSet.getString("name"), resultSet.getInt("salary"));
                maxSalWork.add(maxSalaryWorker);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return maxSalWork;
    }
    public List<MaxProjectsClient> findMaxProjectsClient() {
        List<MaxProjectsClient> maxProjClient = new ArrayList<>();
        String filePath = "src/SQL/4_find_max_projects_client.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            ResultSet resultSet = st.executeQuery(content);
            while (resultSet.next()) {
                MaxProjectsClient maxProjectsClient = new MaxProjectsClient(resultSet.getString("name"), resultSet.getInt("project_count"));
                maxProjClient.add(maxProjectsClient);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return maxProjClient;
    }
    public List<LongestProject> findLongestProject() {
        List<LongestProject> longProj = new ArrayList<>();
        String filePath = "src/SQL/5_find_longest_project.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            ResultSet resultSet = st.executeQuery(content);
            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject(resultSet.getInt("id"), resultSet.getInt("month_count"));
                longProj.add(longestProject);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return longProj;
    }
    public List<YoungestAndEldestWorkers> findYoungestAndEldestWorkers() {
        List<YoungestAndEldestWorkers> youngOldWorkers = new ArrayList<>();
        String filePath = "src/SQL/6_find_youngest_eldest_workers.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            ResultSet resultSet = st.executeQuery(content);
            while (resultSet.next()) {
                YoungestAndEldestWorkers youngestAndEldestWorker = new YoungestAndEldestWorkers(resultSet.getString("type"), resultSet.getString("name"), LocalDate.parse(resultSet.getString("birthday")));
                youngOldWorkers.add(youngestAndEldestWorker);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return youngOldWorkers;
    }
    public List<ProjectsPrices> findProjectsPrices() {
        List<ProjectsPrices> projPrice = new ArrayList<>();
        String filePath = "src/SQL/7_print_project_prices.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            ResultSet resultSet = st.executeQuery(content);
            while (resultSet.next()) {
                ProjectsPrices projectsPrices = new ProjectsPrices(resultSet.getInt("project_id"), resultSet.getInt("price"));
                projPrice.add(projectsPrices);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return projPrice;
    }
}

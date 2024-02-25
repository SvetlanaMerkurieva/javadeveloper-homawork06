package org.example;

import org.example.config.DatabaseQueryService;
import org.example.elements.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        System.out.println("MaxSalaryWorkers:");
        System.out.println(maxSalaryWorkers.toString());

        List<MaxProjectsClient> maxProjectsClients = new DatabaseQueryService().findMaxProjectsClient();
        System.out.println("MaxProjectsClients:");
        System.out.println(maxProjectsClients.toString());

        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        System.out.println("LongestProjects:");
        System.out.println(longestProjects.toString());

        List<YoungestAndEldestWorkers> youngestAndEldestWorkers = new DatabaseQueryService().findYoungestAndEldestWorkers();
        System.out.println("YoungestAndEldestWorkers:");
        System.out.println(youngestAndEldestWorkers.toString());

        List<ProjectsPrices> projectsPrices = new DatabaseQueryService().findProjectsPrices();
        System.out.println("ProjectsPrices:");
        System.out.println(projectsPrices.toString());

    }
}
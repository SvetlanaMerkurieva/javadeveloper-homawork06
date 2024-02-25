SELECT project_id, SUM(worker.salary) * DATEDIFF ('MONTH', project.start_date, project.finish_date) AS PRICE
FROM project_worker
JOIN worker ON worker.id = project_worker.worker_id
JOIN project ON project.id = project_worker.project_id
GROUP BY project_id;
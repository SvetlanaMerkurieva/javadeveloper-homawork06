SELECT 'ELDEST' AS TYPE, name, birthday FROM worker WHERE birthday IN (SELECT MIN(birthday) FROM worker)
UNION
SELECT 'YOUNGEST', name, birthday FROM worker WHERE birthday IN (SELECT MAX(birthday) FROM worker);
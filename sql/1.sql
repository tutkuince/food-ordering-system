-- Select countries where the total number of inhabitants (population) in all cities is greater than 400.
SELECT c.Name
FROM Country c
JOIN City ci on c.CountryID = ci.CountryID
GROUP BY c.CountryID, c.Name
HAVING SUM(ci.Popultaion) > 400;
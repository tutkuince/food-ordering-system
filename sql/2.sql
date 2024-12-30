-- Select names of the countries that have no buildings at all.
SELECT c.Name
FROM Country c
LEFT JOIN City ci ON c.CountryID = ci.CountryID
LEFT JOIN Building b on ci.CityID = b.CityID
WHERE b.BuildingID IS NULL;
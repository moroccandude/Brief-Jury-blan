ALTER DATABASE ecommerv2 


-- ajouter column "annee" de tableau factSalles pour le attaquer pour (partitionement)
ALTER TABLE factSalles ADD annee INT;
UPDATE factSalles
SET annee = d.annee
FROM factSalles f
INNER JOIN DimDate d ON d.id = f.id_date;
-- 1️⃣ Créer la fonction de partition

CREATE PARTITION FUNCTION pf_year (INT)
AS RANGE LEFT FOR VALUES (2021, 2022, 2023);

-- 2️⃣ Ajouter les filegroups (un par année)
ALTER DATABASE ecommerv2 ADD FILEGROUP FG_2021;
ALTER DATABASE ecommerv2 ADD FILEGROUP FG_2022;
ALTER DATABASE ecommerv2 ADD FILEGROUP FG_2023;
-- Utilisation de PRIMARY comme filegroup par défaut
ALTER DATABASE ecommerv2 ADD FILEGROUP FG_OTHER;

-- 3️⃣ Créer le schéma de partition
CREATE PARTITION SCHEME ps_year
AS PARTITION pf_year TO ([FG_2021], [FG_2022], [FG_2023], [FG_OTHER]);

exec sp_help factSalles

--drop Primary key
drop index idx_clients_dateID on factSalles
alter table factSalles
drop constraint index_product
--
CREATE CLUSTERED INDEX idx_factSalles
ON factSalles (annee)
ON makePartition(annee);




create clustered  INDEX CIX_factSalles ON factSalles(annee) ON ps_years(annee)



SELECT annee, COUNT(*) AS TotalRows
FROM factSalles
GROUP BY annee;

SELECT partition_id, rows
FROM sys.partitions
WHERE OBJECT_ID = OBJECT_ID('factSalles') AND index_id = 1;



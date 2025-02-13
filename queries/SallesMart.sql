-- Renommer les colonnes si nécessaire (décommenter pour exécuter)
/*
EXEC sp_rename 'DimShipping.id_shipping', 'id', 'COLUMN';
EXEC sp_rename 'Dimdate.day', 'jour', 'COLUMN';
*/

-- Utiliser la base de données SalesMart pour créer la table
USE SalesMart;
GO

-- Créer la table and delete if existe
IF OBJECT_ID('SalesDataMart', 'U') IS NOT NULL  
    DROP TABLE SalesDataMart;

-- Créer la table SalesDataMart
CREATE  TABLE SalesDataMart (
    ProduitQuantitySold INT,
    ProduitTotalAmount DECIMAL(10,2),
    DiscountAmount DECIMAL(10,2),
    NetAmount DECIMAL(10,2),
    CustomerName NVARCHAR(255),
    CustomerSegment NVARCHAR(255),
    Customer_RueNumber NVARCHAR(50),
    Customer_RueNOM NVARCHAR(255),
    Customer_num_logement NVARCHAR(50),
    Customer_code_militaire NVARCHAR(50),
    Customer_num_militaire NVARCHAR(50),
    Customer_ville NVARCHAR(255),
    Customer_Region NVARCHAR(255),
    Customer_code_postal NVARCHAR(20),
    annee INT,
    mois INT,
    jour INT,
    Produit_chiffreAffaires DECIMAL(10,2),
    ProductCategory NVARCHAR(255),
    ProductSubCategory NVARCHAR(255),
    ProductPrice DECIMAL(10,2),
    ProductName NVARCHAR(255)
);
GO

-- Utiliser la base de données ecommerv2 pour l'insertion des données
USE ecommerv2;
GO

-- Insérer les données dans SalesMart.SalesDataMart
INSERT INTO SalesMart.dbo.SalesDataMart
SELECT
    salles.QuantitySold AS ProduitQuantitySold,
    salles.TotalAmount AS ProduitTotalAmount,
    salles.DiscountAmount,
    salles.NetAmount,
    cus.CustomerName,
    cus.CustomerSegment,
    cus.num_rue AS Customer_RueNumber,
    cus.nom_rue AS Customer_RueNOM,
    cus.num_logement AS Customer_num_logement,
    cus.code_militaire AS Customer_code_militaire,
    cus.num_militaire AS Customer_num_militaire,
    cus.ville AS Customer_ville,
    cus.region AS Customer_Region,
    cus.code_postal AS Customer_code_postal,
    datee.annee,
    datee.mois,
    datee.jour,
    product.chiffreAffaires AS Produit_chiffreAffaires,
    product.ProductCategory,
    product.ProductSubCategory,
    product.ProductPrice,
    product.ProductName
FROM
    dbo.factSalles salles
    LEFT JOIN dbo.Dimcustomer cus ON cus.id = salles.id_costumer
    LEFT JOIN dbo.Dimdate datee ON datee.id = salles.id_date
    LEFT JOIN dbo.DimShipping ship ON ship.id = salles.id_shipping
    LEFT JOIN dbo.Dimproduct product ON product.id = salles.id_product;
GO


USE SalesMart;
GO
--Meilleurs produits et catégories par chiffre d’affaires
SELECT 
    
    ProductCategory,
    ProductName,
    SUM(Produit_chiffreAffaires) AS TOTALChiffreAffaires
FROM 
    SalesDataMart
GROUP BY 
   
    ProductCategory,
    ProductName
ORDER  BY 
TOTALChiffreAffaires DESC

--Segmentation des clients par région, tranche d’âge ou comportement d’achat.


select Customer_Region,Customer_ville,CustomerName,COUNT(ProductName) AS TotalProductBought from SalesDataMart 
GROUP BY Customer_Region,Customer_ville,CustomerName
ORDER BY TotalProductBought DESC

select CustomerSegment,COUNT(ProductName) AS TotalProductBought from SalesDataMart 
GROUP BY CustomerSegment
ORDER BY TotalProductBought DESC

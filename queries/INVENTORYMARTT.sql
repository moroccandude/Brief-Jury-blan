USE InventaireMart;
GO

-- V�rification et suppression de la table ProductDimension si elle existe
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'ProductDimension')
BEGIN
    DROP TABLE dbo.ProductDimension;
END
GO

-- Cr�ation de la table ProductDimension
CREATE TABLE dbo.ProductDimension (
    id INT NOT NULL PRIMARY KEY,  -- Cl� primaire ajout�e
    ProductName VARCHAR(50),
    ProductCategory VARCHAR(50),
    ProductSubCategory VARCHAR(50),
    ProductPrice DECIMAL(10,2),  -- Utilisation de DECIMAL pour une meilleure pr�cision
    chiffreAffaires DECIMAL(10,2)  -- Suppression de la virgule en trop
);

-- Int�gration des donn�es depuis Dimproduct dans ProductDimension
USE ecommerv2;
GO

INSERT INTO InventaireMart.dbo.ProductDimension (id, ProductName, ProductCategory, ProductSubCategory, ProductPrice, chiffreAffaires)
SELECT id, ProductName, ProductCategory, ProductSubCategory, ProductPrice, chiffreAffaires
FROM ecommerv2.dbo.Dimproduct;  -- Assurez-vous que Dimproduct existe dans la base ecommerv2

SELECT * FROM InventaireMart.dbo.ProductDimension;
GO

-- Ex�cution de la proc�dure sp_help pour dimSupplier
EXEC sp_help 'dimSupplier';
GO

USE InventaireMart;
GO

-- V�rification et suppression de la table SupplierDimension si elle existe
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'SupplierDimension')
BEGIN
    DROP TABLE dbo.SupplierDimension;
END
GO

-- Cr�ation de la table SupplierDimension
CREATE TABLE dbo.SupplierDimension (
    id INT NOT NULL PRIMARY KEY,  -- Cl� primaire ajout�e
    SupplierName VARCHAR(250),
    SupplierLocation VARCHAR(250),
    SupplierContact VARCHAR(250)
);

-- Int�gration des donn�es depuis dimSupplier dans SupplierDimension
INSERT INTO InventaireMart.dbo.SupplierDimension (SupplierName, SupplierLocation, SupplierContact, id)
SELECT SupplierName, SupplierLocation, SupplierContact, id
FROM ecommerv2.dbo.dimSupplier;
GO

-- V�rification et suppression de la table TimeDimension si elle existe
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'TimeDimension')
BEGIN
    DROP TABLE dbo.TimeDimension;
END
GO

-- Cr�ation de la table TimeDimension
CREATE TABLE dbo.TimeDimension (
    id INT NOT NULL PRIMARY KEY,  -- Cl� primaire ajout�e
    annee INT,
    mois INT,
    jour INT
);

-- Int�gration des donn�es depuis Dimdate dans TimeDimension
INSERT INTO InventaireMart.dbo.TimeDimension (id, annee, mois, jour)
SELECT id, annee, mois, jour
FROM ecommerv2.dbo.Dimdate;
GO

-- Ex�cution de la proc�dure sp_help pour factinventory
EXEC sp_help 'factinventory';
GO

-- V�rification et suppression de la table InventoryFact si elle existe
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'InventoryFact')
BEGIN
    DROP TABLE dbo.InventoryFact;
END
GO

-- Cr�ation de la table InventoryFact
CREATE TABLE dbo.InventoryFact (
    StockReceived DECIMAL(10,2),
    StockSold DECIMAL(10,2),
    StockOnHand DECIMAL(10,2),
    id_supplier INT NOT NULL FOREIGN KEY REFERENCES InventaireMart.dbo.SupplierDimension(id),
    id_date INT NOT NULL FOREIGN KEY REFERENCES InventaireMart.dbo.TimeDimension(id),
    id_product INT NOT NULL FOREIGN KEY REFERENCES InventaireMart.dbo.ProductDimension(id)
);

-- Int�gration des donn�es depuis factinventory dans InventoryFact
INSERT INTO InventaireMart.dbo.InventoryFact (StockReceived, StockSold, StockOnHand, id_supplier, id_date, id_product)
SELECT StockReceived, StockSold, StockOnHand, id_supplier, id_date, id_product
FROM ecommerv2.dbo.factinventory;
GO

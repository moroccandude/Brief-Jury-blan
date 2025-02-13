
USE SalesMart;
GO
--------------------------------------SallesMart
create table SalesMart(
QuantitySold int ,
TotalAmount DECIMAL(10,2),
DiscountAmount DECIMAL(10,2),
NetAmount DECIMAL(10,2),
id_product int FOREIGN KEY REFERENCES SalesMart.dbo.ProductDimension(id),
id_customer int  FOREIGN KEY REFERENCES SalesMart.dbo.CustomerDimension(id),
id_date int FOREIGN KEY REFERENCES SalesMart.dbo.TimeDimension(id)
)


insert into SalesMart(QuantitySold,TotalAmount,DiscountAmount,NetAmount,id_product,id_customer,id_date)
select QuantitySold,TotalAmount,DiscountAmount,NetAmount,id_product,id_customer,id_date  from  InventaireMart.dbo.SalesFact

---------------------------------------------Product

USE SalesMart;
GO

-- Création de la table ProductDimension
CREATE TABLE SalesMart.dbo.ProductDimension (
    id INT NOT NULL PRIMARY KEY,  -- Clé primaire ajoutée
    ProductName VARCHAR(50),
    ProductCategory VARCHAR(50),
    ProductSubCategory VARCHAR(50),
    ProductPrice DECIMAL(10,2),  -- Utilisation de DECIMAL pour une meilleure précision
    chiffreAffaires DECIMAL(10,2)  -- Suppression de la virgule en trop
);

-- Intégration des données depuis Dimproduct dans ProductDimension


INSERT INTO SalesMart.dbo.ProductDimension (id, ProductName, ProductCategory, ProductSubCategory, ProductPrice, chiffreAffaires)
SELECT id, ProductName, ProductCategory, ProductSubCategory, ProductPrice, chiffreAffaires
FROM InventaireMart.dbo.ProductDimension;  -- Assurez-vous que Dimproduct existe dans la base 



-------------------------------------------------time
-- Création de la table TimeDimension
CREATE TABLE SalesMart.dbo.TimeDimension (
    id INT NOT NULL PRIMARY KEY,  -- Clé primaire ajoutée
    annee INT,
    mois INT,
    jour INT
);

-- Intégration des données depuis Dimdate dans TimeDimension
INSERT INTO SalesMart.dbo.TimeDimension (id, annee, mois, jour)
SELECT id, annee, mois, jour
FROM InventaireMart.dbo.TimeDimension;
GO


-------------------------------------customer
CREATE TABLE SalesMart.dbo.CustomerDimension(
CustomerName Varchar(250),
CustomerEmail Varchar(250),
CustomerPhone Varchar(250),
CustomerSegment Varchar(250),
id int primary key Not null,
num_rue Varchar(250),
nom_rue Varchar(250),
type_logement Varchar(250),
num_logement VARCHAR(250),
code_militaire VARCHAR(16),
num_militaire varchar(20),
ville VARCHAR(250),
region VARCHAR(15));

INSERT INTO CustomerDimension(CustomerName,CustomerEmail,CustomerPhone,CustomerSegment,id,num_rue,nom_rue,type_logement,num_logement,code_militaire,num_militaire,ville,region)
SELECT CustomerName,CustomerEmail,CustomerPhone,CustomerSegment,id,num_rue,nom_rue,type_logement,num_logement,code_militaire,num_militaire,ville,region FROM InventaireMart.dbo.CustomerDimension
go


USE InventaireMart;
GO
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'CustomerDimension')
BEGIN
    DROP TABLE dbo.CustomerDimension;
END
GO


CREATE TABLE CustomerDimension(
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
SELECT CustomerName,CustomerEmail,CustomerPhone,CustomerSegment,id,num_rue,nom_rue,type_logement,num_logement,code_militaire,num_militaire,ville,region FROM ecommerv2.dbo.Dimcustomer
go


select * from ecommerv2.dbo.factSalles
USE InventaireMart;
GO
create table SalesFact(
QuantitySold int ,
TotalAmount DECIMAL(10,2),
DiscountAmount DECIMAL(10,2),
NetAmount DECIMAL(10,2),
id_product int FOREIGN KEY REFERENCES InventaireMart.dbo.ProductDimension(id),
id_customer int  FOREIGN KEY REFERENCES InventaireMart.dbo.CustomerDimension(id),
id_date int FOREIGN KEY REFERENCES InventaireMart.dbo.TimeDimension(id)
)


insert into SalesFact(QuantitySold,TotalAmount,DiscountAmount,NetAmount,id_product,id_customer,id_date)
select QuantitySold,TotalAmount,DiscountAmount,NetAmount,id_product,id_costumer,id_date  from  ecommerv2.dbo.factSalles
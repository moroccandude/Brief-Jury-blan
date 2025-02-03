SELECT TOP (4000) [CustomerName]
      ,[CustomerEmail]
      ,[CustomerPhone]
      ,[CustomerSegment]
      ,[id]
      ,[num_rue]
      ,[nom_rue]
      ,[type_logement]
      ,[num_logement]
      ,[code_militaire]
      ,[num_militaire]
      ,[ville]
      ,[region]
      ,[code_postal]
  FROM [ecommerv2].[dbo].[Dimcustomer]
  SELECT * FROM dbo.Dimcustomer WHERE id = 993;
  DBCC CHECKIDENT ('dbo.Dimcustomer', RESEED, (SELECT MAX(id) FROM dbo.Dimcustomer));


  exec sp_help Dimcustomer;

  alter table Dimcustomer
  drop constraint PK__Dimcusto__3213E83F300DF155;

  alter table Dimcustomer
  add constraint unique_customer Unique (id);
  
--  select count(*) from  Dimcustomer;

 select * from FactSalles
 --exec sp_help FactSalles
 SELECT COLUMN_NAME, DATA_TYPE 
FROM INFORMATION_SCHEMA.COLUMNS 
WHERE TABLE_NAME = 'FactSalles' AND COLUMN_NAME = 'id_costumer';

  alter table FactSalles
  ADD CONSTRAINT FK_CUSTOMER FOREIGN KEY(id_costumer)
  references Dimcustomer(id) ;

 
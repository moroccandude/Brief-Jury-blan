SELECT TOP (1000) [SupplierName]
      ,[SupplierLocation]
      ,[SupplierContact]
      ,[id]
  FROM [ecommerv2].[dbo].[dimSupplier]


  exec sp_help [dimSupplier]
   exec sp_help FactSalles

exec sp_help factinventory

SELECT * 
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
WHERE TABLE_NAME = 'dimSupplier'


SELECT id FROM dbo.dimSupplier
WHERE id NOT IN (SELECT id FROM factinventory);

alter table [dimSupplier]
add constraint pk_supplier primary key (id);





 alter table factinventory
 ADD CONSTRAINT FKkk_supplier FOREIGN KEY(id_supplier)
 references dimSupplier(id) ;

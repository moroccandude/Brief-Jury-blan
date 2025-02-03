SELECT TOP (1000) [ShipperName]
      ,[ShippingMethod]
      ,[id_shipping]
  FROM [ecommerv2].[dbo].[DimShipping]

  exec sp_help "DimShipping"

   alter table FactSalles
  ADD CONSTRAINT FK_SHUUPING FOREIGN KEY(id_date)
  references Dimdate(id) ;
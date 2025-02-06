SELECT TOP (1000) [QuantitySold]
      ,[TotalAmount]
      ,[DiscountAmount]
      ,[NetAmount]
      ,[id_product]
      ,[id_shipping]
      ,[id_costumer]
      ,[id_date]
      ,[id]
  FROM [ecommerv2].[dbo].[factSalles]


  --verifier cluster index is active 
  select * from [factSalles]
  where id=6

  ---

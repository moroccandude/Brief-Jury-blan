
--verifier cluster index is active 
   SELECT * FROM factSalles
  where id=6

  SELECT * FROM factSalles
where id_product=1610

 ---
CREATE NONCLUSTERED INDEX index_product
ON factSalles(id_product);

CREATE NONCLUSTERED INDEX idx_clients_dateID 
ON factSalles(id_date);
CREATE NONCLUSTERED INDEX idx_clients_shippingID 
ON factSalles(id_shipping);

CREATE NONCLUSTERED INDEX idx_clients_customerID 
ON factSalles(id_costumer);

CREATE NONCLUSTERED INDEX ProductName_
ON Dimproduct(ProductName);